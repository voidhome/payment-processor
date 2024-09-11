package paymentprocessor.domain

import java.time.Instant
import java.util.*

data class OutboxRecord(
    var id: UUID?,
    var type: OutboxRecordType,
    var aggregateId: UUID?,
    var data: ByteArray,
    var status: OutboxRecordStatus,
    var version: Long,
    var createdAt: Instant?,
    var updatedAt: Instant?
)
