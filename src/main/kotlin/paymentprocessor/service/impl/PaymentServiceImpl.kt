package paymentprocessor.service.impl

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import paymentprocessor.dto.PaymentDto
import paymentprocessor.mapper.PaymentMapper
import paymentprocessor.repository.PaymentRepository
import paymentprocessor.service.PaymentService
import paymentprocessor.service.PaymentValidationService
import paymentprocessor.table.Payment
import reactor.core.publisher.Mono

@Service
class PaymentServiceImpl(
    private val paymentRepository: PaymentRepository,
    private val paymentValidationService: PaymentValidationService,
    private val kafkaTemplate: KafkaTemplate<String, Payment>,
    private val paymentMapper: PaymentMapper
) : PaymentService {

    override fun processPayment(paymentDto: PaymentDto): Mono<Void> {
        val payment = paymentMapper.toPayment(paymentDto)
        return paymentValidationService.validatePayment(payment)
            .flatMap { savePayment(it) }
            .doOnSuccess { sendPaymentToKafka(it) }
            .then()
    }

    private fun savePayment(payment: Payment): Mono<Payment> {
        return paymentRepository.save(payment)
    }

    private fun sendPaymentToKafka(payment: Payment) {
        kafkaTemplate.send("payment-results", payment)
    }
}