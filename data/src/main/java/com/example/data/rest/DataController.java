package com.example.data.rest;

import com.example.data.dto.PaymentResponseDto;
import com.example.data.service.DataService;
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
public class DataController {
    private final DataService dataService;

    @GetMapping("/payments")
    public List<PaymentResponseDto> getPayments(
            @RequestParam(value = "page", defaultValue = "0") @Min(0) int page,
            @RequestParam(value = "count", defaultValue = "10") @Min(10) @Max(50) int count,
            @RequestHeader Optional<String> authorization
    ) {
        return dataService.findAll(page, count);
    }

}
