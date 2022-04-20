package com.example.aloqa_kompaniya.service;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.dto.FilialDto;
import com.example.aloqa_kompaniya.entity.Company;
import com.example.aloqa_kompaniya.entity.Employee;
import com.example.aloqa_kompaniya.entity.Filial;
import com.example.aloqa_kompaniya.repository.CompanyRepository;
import com.example.aloqa_kompaniya.repository.EmployeeRepository;
import com.example.aloqa_kompaniya.repository.FilialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilialService {

    final FilialRepository filialRepository;
    final CompanyRepository companyRepository;
    final EmployeeRepository employeeRepository;
    public ApiResponse add(FilialDto dto) {
        if(filialRepository.existsByName(dto.getName())){
            return new ApiResponse("Already exist",false);
        }
        Filial filial=new Filial();
        filial.setName(dto.getName());
        Optional<Company> byId = companyRepository.findById(dto.getCompanyId());
        filial.setCompany(byId.get());
        Optional<Employee> byId1 = employeeRepository.findById(dto.getDirectorId());
        filial.setDirector(byId1.get());
        filialRepository.save(filial);
        return new ApiResponse("Added",true);
    }

    public ApiResponse edit(Integer id, FilialDto dto) {
        Optional<Filial> byId2 = filialRepository.findById(id);
        if (!byId2.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Filial filial = byId2.get();
        filial.setName(dto.getName());
        Optional<Company> byId = companyRepository.findById(dto.getCompanyId());
        filial.setCompany(byId.get());
        Optional<Employee> byId1 = employeeRepository.findById(dto.getDirectorId());
        filial.setDirector(byId1.get());
        filialRepository.save(filial);
        return new ApiResponse("Edited",true);
    }
}
