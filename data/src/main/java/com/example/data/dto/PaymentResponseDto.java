package com.example.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentResponseDto {
    private long id;
    private long senderId;
    private String sendersCardNumber;
    private long amount;
    private String receiversCardNumber;
    private String comment;
}
