package paymentprocessor.table

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("payment")
data class Payment(

    @Id val id: UUID,
    val amount: Double,
    val currency: String,
    val paymentMethod: String,
    val success: Boolean,
    val reason: String?
)