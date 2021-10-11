package com.example.producer.dto;

import com.example.producer.support.validation.CardNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Validated
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentRequestDto {
    private long senderId;
    @CardNumber
    private String sendersCardNumber;
    @Min(1)
    private long amount;
    @CardNumber
    private String receiversCardNumber;
    private String comment;
}
