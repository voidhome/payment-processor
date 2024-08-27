package paymentprocessor.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PaymentDto(
    @JsonProperty("amount") val amount: Double,
    @JsonProperty("currency") val currency: String,
    @JsonProperty("paymentMethod") val paymentMethod: String
)