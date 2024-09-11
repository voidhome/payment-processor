package paymentprocessor.publisher;

import kotlinx.coroutines.future.await
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import paymentprocessor.utils.Serializer

@Component
class EventPublisherImpl(
    private val kafkaTemplate: KafkaTemplate<String, ByteArray>,
    private val serializer: Serializer
) : EventPublisher {

    override suspend fun publish(topic: String?, data: Any) {
        val msg = ProducerRecord<String, ByteArray>(topic, serializer.serializeToBytes(data))
        val result = kafkaTemplate.send(msg).await()
        log.info("Результат успешно опубликован: $result")
    }

    companion object {
        private val log = LoggerFactory.getLogger(EventPublisherImpl::class.java)
    }
}