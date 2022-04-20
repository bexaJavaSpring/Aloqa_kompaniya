package com.example.aloqa_kompaniya.repository;

import com.example.aloqa_kompaniya.entity.SimCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimCardRepository extends JpaRepository<SimCard,Integer> {

    boolean existsByNumber(String number);
}
