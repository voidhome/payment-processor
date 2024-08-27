package paymentprocessor.mapper

import org.mapstruct.Mapper
import paymentprocessor.dto.PaymentDto
import paymentprocessor.table.Payment

@Mapper(componentModel = "spring")
interface PaymentMapper {

    fun toPayment(paymentDto: PaymentDto): Payment
}