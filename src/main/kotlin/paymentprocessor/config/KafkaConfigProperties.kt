package paymentprocessor.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "kafka")
class KafkaConfigProperties {
    @Value("\${spring.kafka.bootstrap-servers}")
    lateinit var bootstrapServers: String

    @Value("\${spring.kafka.consumer.group-id}")
    lateinit var groupId: String

    @Value("\${spring.kafka.consumer.enable-auto-commit-config}")
    lateinit var enableAutoCommitConfig: String

    @Value("\${spring.kafka.consumer.trusted-packages}")
    lateinit var trustedPackages: String

    @Value("\${spring.kafka.consumer.value-default-type}")
    lateinit var valueDefaultType: String

    @Value("\${spring.kafka.consumer.type-mappings}")
    lateinit var typeMappings: String

    @Value("\${spring.kafka.producer.acks-config}")
    lateinit var acksConfig: String

    @Value("\${spring.kafka.producer.retries-config}")
    val retriesConfig: Int = 0

    @Value("\${spring.kafka.producer.delivery-timeout-ms-config}")
    val deliveryTimeoutMsConfig: Int = 0

    @Value("\${spring.kafka.producer.max-request-size-config}")
    val maxRequestSizeConfig: Int = 0

    @Value("\${spring.kafka.producer.request-timeout-ms-config}")
    val requestTimeoutMsConfig: Int = 0
}