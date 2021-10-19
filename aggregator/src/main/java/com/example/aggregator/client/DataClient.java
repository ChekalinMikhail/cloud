package com.example.aggregator.client;

import com.example.aggregator.dto.PaymentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "data")
public interface DataClient {
    @GetMapping("/api/payments")
    List<PaymentResponseDto> getPayments(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count);

}
