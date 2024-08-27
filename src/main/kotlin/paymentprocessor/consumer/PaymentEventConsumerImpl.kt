package paymentprocessor.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import paymentprocessor.dto.PaymentDto
import paymentprocessor.service.PaymentService

@Component
class PaymentEventConsumerImpl(private val paymentService: PaymentService) : PaymentEventConsumer {

    private val logger = LoggerFactory.getLogger(PaymentEventConsumerImpl::class.java)

    @KafkaListener(topics = arrayOf("payment-created-events-topic"), groupId = "test-group")
    override fun consumeEvents(paymentDto: PaymentDto) {
        paymentService.processPayment(paymentDto)
    }
}