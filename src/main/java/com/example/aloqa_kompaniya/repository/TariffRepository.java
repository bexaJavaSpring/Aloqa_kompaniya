package com.example.aloqa_kompaniya.repository;

import com.example.aloqa_kompaniya.entity.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff,Integer> {

    boolean existsByName(String name);
}
