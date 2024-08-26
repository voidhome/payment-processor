package paymentprocessor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaymentProcessorApplication

fun main(args: Array<String>) {
    runApplication<PaymentProcessorApplication>(*args)
}
