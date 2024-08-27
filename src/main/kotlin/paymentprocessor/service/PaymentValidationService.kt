package paymentprocessor.service

import paymentprocessor.table.Payment
import reactor.core.publisher.Mono

interface PaymentValidationService {

    fun validatePayment(payment: Payment): Mono<Payment>
}