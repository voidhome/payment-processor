package paymentprocessor.service.impl

import org.springframework.stereotype.Service
import paymentprocessor.service.PaymentValidationService
import paymentprocessor.table.Payment
import reactor.core.publisher.Mono

@Service
class PaymentValidationServiceImpl : PaymentValidationService {

    override fun validatePayment(payment: Payment): Mono<Payment> {
        return if (payment.amount > 0) {
            Mono.just(payment.copy(success = true, reason = null))
        } else {
            Mono.just(payment.copy(success = false, reason = "Сумма должна быть положительной"))
        }
    }
}