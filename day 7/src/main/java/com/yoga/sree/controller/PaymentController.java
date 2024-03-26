package com.yoga.sree.controller;

import static com.yoga.sree.utils.MyConstant.PAYMENT;
import static com.yoga.sree.utils.MyConstant.PAYMENTLIST;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.sree.dto.request.PaymentRequest;
import com.yoga.sree.dto.response.RegisterResponse;
import com.yoga.sree.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RequestMapping(PAYMENT)
@RestController
@RequiredArgsConstructor
public class PaymentController {
   private final PaymentService paymentService;
     @PostMapping(PAYMENTLIST)
       public ResponseEntity<RegisterResponse> addPayment(@RequestBody PaymentRequest request)
       {
           RegisterResponse response=new RegisterResponse();
           try{
                response=paymentService.addPayment(request);
                return new ResponseEntity<>(response,HttpStatus.OK);
           }
           catch(Exception e)
           {
                response.setMessage("Something went wrong");
                return new ResponseEntity<>(response, EXPECTATION_FAILED);
           }
}
 
}
