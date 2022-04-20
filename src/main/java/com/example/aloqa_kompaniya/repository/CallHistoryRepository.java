package com.example.aloqa_kompaniya.repository;

import com.example.aloqa_kompaniya.entity.CallHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallHistoryRepository extends JpaRepository<CallHistory,Integer> {
}
