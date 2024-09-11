package paymentprocessor.dto

import paymentprocessor.domain.Payment

data class PaymentValidationDto(
    val isValid: Boolean,
    val payment: Payment
) : BaseDto(payment.id, payment.version)