package paymentprocessor.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import paymentprocessor.table.Payment
import java.util.*

@Repository
interface PaymentRepository : ReactiveCrudRepository<Payment, UUID> {
}