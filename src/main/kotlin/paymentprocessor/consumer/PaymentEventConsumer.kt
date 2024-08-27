package paymentprocessor.consumer

import paymentprocessor.dto.PaymentDto

interface PaymentEventConsumer {

    fun consumeEvents(paymentDto: PaymentDto)
}