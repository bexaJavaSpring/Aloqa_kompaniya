package com.example.aloqa_kompaniya.repository;

import com.example.aloqa_kompaniya.entity.MobileOperator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobileOperatorRepository extends JpaRepository<MobileOperator,Integer> {

    boolean existsByName(String name);

}
