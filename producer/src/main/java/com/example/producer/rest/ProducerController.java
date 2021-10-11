package com.example.producer.rest;

import com.example.producer.dto.PaymentRequestDto;
import com.example.producer.dto.PaymentResponseDto;
import com.example.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
@RequiredArgsConstructor
public class ProducerController {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final ProducerService producerService;

    @PostMapping("/payments")
    public PaymentResponseDto send(@RequestHeader Optional<String> authorization, @RequestBody @Valid PaymentRequestDto paymentRequestDto) {
        logger.info("payment has been sent for execution");
        producerService.payments(paymentRequestDto);
        return new PaymentResponseDto("payment has been sent for execution");
    }

}
