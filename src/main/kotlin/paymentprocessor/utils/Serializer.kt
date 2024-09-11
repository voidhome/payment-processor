package paymentprocessor.utils

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import paymentprocessor.exception.SerializationException

@Component
class Serializer(private val objectMapper: ObjectMapper) {

    fun <T> deserialize(data: ByteArray, clazz: Class<T>): T {
        return try {
            objectMapper.readValue(data, clazz)
        } catch (ex: Exception) {
            log.error("Ошибка при десериализации данных: ${ex.localizedMessage}")
            throw SerializationException(ex)
        }
    }

    fun serializeToBytes(data: Any): ByteArray {
        return try {
            objectMapper.writeValueAsBytes(data)
        } catch (ex: Exception) {
            log.error("Ошибка при сериализации данных: ${ex.localizedMessage}")
            throw SerializationException(ex)
        }
    }

    fun serializeToString(data: Any): String {
        return try {
            objectMapper.writeValueAsString(data)
        } catch (ex: Exception) {
            log.error("Ошибка при сериализации данных: ${ex.localizedMessage}")
            throw SerializationException(ex)
        }
    }

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(Serializer::class.java)
    }
}