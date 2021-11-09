package com.testyfood.omf.service;

import com.testyfood.omf.model.Payment;
import com.testyfood.omf.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    @Override
    public Payment savePayment(Payment payment) {
        return repository.save(payment);
    }
}
