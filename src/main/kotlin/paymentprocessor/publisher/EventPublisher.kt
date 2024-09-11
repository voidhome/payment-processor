package paymentprocessor.publisher

interface EventPublisher {

    suspend fun publish(topic: String?, data: Any)
}