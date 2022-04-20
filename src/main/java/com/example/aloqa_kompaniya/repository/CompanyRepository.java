package com.example.aloqa_kompaniya.repository;

import com.example.aloqa_kompaniya.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    boolean existsByName(String name);

}
