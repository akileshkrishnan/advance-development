package com.yoga.sree.service.impl;

import org.springframework.stereotype.Service;

import com.yoga.sree.dto.request.PaymentRequest;
import com.yoga.sree.dto.response.RegisterResponse;
import com.yoga.sree.model.Payment;
import com.yoga.sree.model.User;
import com.yoga.sree.model.UserCourse;
import com.yoga.sree.repository.PaymentRepository;
import com.yoga.sree.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
     @SuppressWarnings("null")
    @Override
     public RegisterResponse addPayment(PaymentRequest request) {
        var user=Payment.builder()
                .amount(request.getAmount())
               
                // .usercourse_id(request.getUsercourse_id())
                .build();
                paymentRepository.save(user);
        return RegisterResponse.builder()
        .message("Payment done successfuly")
        .build();
    }


}
