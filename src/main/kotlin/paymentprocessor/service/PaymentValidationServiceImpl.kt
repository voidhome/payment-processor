package paymentprocessor.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import paymentprocessor.config.KafkaTopicsConfig
import paymentprocessor.domain.Payment
import paymentprocessor.dto.PaymentValidationDto
import paymentprocessor.publisher.EventPublisher

@Service
class PaymentValidationServiceImpl(
    private val eventPublisher: EventPublisher,
    private val topicsConfig: KafkaTopicsConfig
) : PaymentValidationService {

    override suspend fun validatePayment(payment: Payment): Boolean {
        return if (payment.amount > 0) {
            log.info("Платеж успешно валидирован")
            eventPublisher.publish(topicsConfig.paymentProcessed.name, PaymentValidationDto(true, payment))
            true
        } else {
            log.warn("Валидация платежа завершилась неудачей: сумма платежа ${payment.amount} должна быть положительной.")
            false
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(PaymentValidationServiceImpl::class.java)
    }
}