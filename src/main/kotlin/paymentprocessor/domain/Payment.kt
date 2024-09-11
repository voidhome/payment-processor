package paymentprocessor.domain

import java.time.Instant
import java.util.*

data class Payment(
    val id: UUID?,
    val amount: Double,
    val currency: String,
    val paymentMethod: String,
    val description: String?,
    val status: PaymentStatus,
    var version: Long,
    var createdAt: Instant?,
    var updatedAt: Instant?
)