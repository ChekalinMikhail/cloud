package com.example.data.mapper;

import com.example.data.dto.PaymentResponseDto;
import com.example.data.entity.PaymentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public List<PaymentResponseDto> fromEntities(List<PaymentEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PaymentResponseDto> list = new ArrayList<PaymentResponseDto>( entities.size() );
        for ( PaymentEntity paymentEntity : entities ) {
            list.add( paymentEntityToPaymentResponseDto( paymentEntity ) );
        }

        return list;
    }

    protected PaymentResponseDto paymentEntityToPaymentResponseDto(PaymentEntity paymentEntity) {
        if ( paymentEntity == null ) {
            return null;
        }

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();

        paymentResponseDto.setId( paymentEntity.getId() );
        paymentResponseDto.setSenderId( paymentEntity.getSenderId() );
        paymentResponseDto.setSendersCardNumber( paymentEntity.getSendersCardNumber() );
        paymentResponseDto.setAmount( paymentEntity.getAmount() );
        paymentResponseDto.setReceiversCardNumber( paymentEntity.getReceiversCardNumber() );
        paymentResponseDto.setComment( paymentEntity.getComment() );

        return paymentResponseDto;
    }
}
