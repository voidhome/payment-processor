package paymentprocessor.service

import paymentprocessor.dto.PaymentDto
import reactor.core.publisher.Mono

interface PaymentService {

    fun processPayment(paymentDto: PaymentDto): Mono<Void>
}