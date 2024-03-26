package com.yoga.sree.service;

import com.yoga.sree.dto.request.PaymentRequest;
import com.yoga.sree.dto.response.RegisterResponse;

public interface PaymentService {

    RegisterResponse addPayment(PaymentRequest request);

}
