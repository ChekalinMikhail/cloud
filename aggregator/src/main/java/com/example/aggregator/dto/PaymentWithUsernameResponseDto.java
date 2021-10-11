package com.example.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentWithUsernameResponseDto {
    private long id;
    private long senderId;
    private String username;
    private String sendersCardNumber;
    private long amount;
    private String receiversCardNumber;
    private String comment;
}
