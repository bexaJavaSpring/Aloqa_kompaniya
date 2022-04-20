package com.example.aloqa_kompaniya.repository;

import com.example.aloqa_kompaniya.entity.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilialRepository extends JpaRepository<Filial,Integer> {

    boolean existsByName(String name);
}
