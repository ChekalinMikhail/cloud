package com.example.aggregator.util;

import com.example.aggregator.dto.PaymentResponseDto;
import com.example.aggregator.dto.PaymentWithUsernameResponseDto;

public class PaymentAndUserBinding {
    public static PaymentWithUsernameResponseDto bind(PaymentResponseDto payment, String username) {
        return new PaymentWithUsernameResponseDto(
                payment.getId(),
                payment.getSenderId(),
                username,
                payment.getSendersCardNumber(),
                payment.getAmount(),
                payment.getReceiversCardNumber(),
                payment.getComment()
        );
    }
}
