package com.example.aloqa_kompaniya.controller;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.dto.EmployeeDto;
import com.example.aloqa_kompaniya.entity.Company;
import com.example.aloqa_kompaniya.entity.Employee;
import com.example.aloqa_kompaniya.repository.CompanyRepository;
import com.example.aloqa_kompaniya.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api/employee")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CompanyRepository companyRepository;

    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody EmployeeDto dto) {
        ApiResponse apiResponse = new ApiResponse();
        if (employeeRepository.existsByUsername(dto.getUsername())) {
            Employee employee = new Employee();
            Optional<Company> byId = companyRepository.findById(dto.getCompanyId());
            employee.setCompany(byId.get());
            employee.setEmail(dto.getEmail());
            employee.setFullName(dto.getFullName());
            employee.setPhone(dto.getPhone());
            employee.setPassword(dto.getPassword());
            employeeRepository.save(employee);
            apiResponse.setMessage("Edited");
            apiResponse.setSuccess(true);
        }
        apiResponse.setMessage("Not found");
        apiResponse.setSuccess(false);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}
