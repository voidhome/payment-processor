package paymentprocessor.exception

data class SerializationException(val ex: Throwable) : RuntimeException(ex)