package paymentprocessor.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer
import org.springframework.kafka.support.serializer.JsonDeserializer
import paymentprocessor.dto.PaymentDto


@Configuration
@EnableKafka
class KafkaConsumerConfig {

    @Bean
    fun consumerConfig(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer::class.java)
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "paymentprocessor.dto")
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "paymentprocessor.dto.PaymentDto")
        props.put(JsonDeserializer.TYPE_MAPPINGS, "paymentservice.dto.PaymentDto:paymentprocessor.dto.PaymentDto")
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false)
        return props
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, PaymentDto> {
        return DefaultKafkaConsumerFactory(consumerConfig())
    }

    @Bean
    fun kafkaListenerContainerFactory(): KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, PaymentDto>> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, PaymentDto> =
            ConcurrentKafkaListenerContainerFactory()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}