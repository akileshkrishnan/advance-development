package com.yoga.sree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoga.sree.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}
