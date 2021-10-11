package com.example.data.service;

import com.example.data.data.Payment;
import com.example.data.dto.PaymentResponseDto;
import com.example.data.entity.PaymentEntity;
import com.example.data.mapper.PaymentMapper;
import com.example.data.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DataService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;
    private final Sort idAscDesc = Sort.by(Sort.Direction.DESC, "id");

    public void createPayment(Payment payment) {
        paymentRepository.save(new PaymentEntity(
                0L,
                payment.getSenderId(),
                payment.getSendersCardNumber(),
                payment.getAmount(),
                payment.getReceiversCardNumber(),
                payment.getComment()
        ));
    }

    public List<PaymentResponseDto> findAll(int page, int count) {
        return mapper.fromEntities(paymentRepository.findAll(PageRequest.of(page, count, idAscDesc)).toList());
    }
}
