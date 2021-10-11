package com.example.aggregator.rest;

import com.example.aggregator.dto.PaymentResponseDto;
import com.example.aggregator.dto.PaymentWithUsernameResponseDto;
import com.example.aggregator.service.AggregatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AggregatorController {
    private final AggregatorService service;

    @GetMapping("/payments")
    public List<PaymentWithUsernameResponseDto> getPayments(
            @RequestParam(value = "page", defaultValue = "0") @Min(0) int page,
            @RequestParam(value = "count", defaultValue = "10") @Min(10) @Max(50) int count,
            @RequestHeader Optional<String> authorization
    ) {
        return service.findAll(page, count);
    }

}
