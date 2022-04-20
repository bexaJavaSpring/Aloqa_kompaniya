package com.example.aloqa_kompaniya.repository;

import com.example.aloqa_kompaniya.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
