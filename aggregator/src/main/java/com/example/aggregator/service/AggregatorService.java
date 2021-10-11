package com.example.aggregator.service;

import com.example.aggregator.client.DataClient;
import com.example.aggregator.client.UsersClient;
import com.example.aggregator.dto.PaymentResponseDto;
import com.example.aggregator.dto.PaymentWithUsernameResponseDto;
import com.example.aggregator.dto.UserResponseDto;
import com.example.aggregator.dto.UsersRequestDto;
import com.example.aggregator.util.PaymentAndUserBinding;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AggregatorService {
    private final DataClient dataClient;
    private final UsersClient usersClient;

    public List<PaymentWithUsernameResponseDto> findAll(int page, int count) {
        final List<PaymentResponseDto> payments = dataClient.getPayments(page, count);
        final List<Long> ids = payments.stream().map(PaymentResponseDto::getSenderId).collect(Collectors.toList());
        final List<UserResponseDto> users = usersClient.getUsers(new UsersRequestDto(ids));
        final Map<Long, String> usernames = new HashMap<>();
        users.forEach(user -> usernames.put(user.getId(), user.getUsername()));

        return payments.stream()
                .map(payment -> PaymentAndUserBinding.bind(payment, usernames.get(payment.getSenderId())))
                .collect(Collectors.toList());
    }
}
