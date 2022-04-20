package com.example.aloqa_kompaniya.repository;

import com.example.aloqa_kompaniya.entity.SMSHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsHistoryRepository extends JpaRepository<SMSHistory,Integer> {
}
