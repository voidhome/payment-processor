package paymentprocessor.service

import paymentprocessor.domain.Payment

interface PaymentValidationService {

    suspend fun validatePayment(payment: Payment): Boolean
}