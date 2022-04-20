package com.example.aloqa_kompaniya.controller;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.entity.Company;
import com.example.aloqa_kompaniya.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api/company")
@RestController
@RequiredArgsConstructor
public class CompanyController {
   final CompanyRepository companyRepository;

   @GetMapping
   public HttpEntity<?> getAll(){
      return ResponseEntity.ok().body(companyRepository.findAll());
   }
   @PostMapping("/add")
   public HttpEntity<?> add(@Valid @RequestBody Company company){
      ApiResponse apiResponse=new ApiResponse();
      if(!companyRepository.existsByName(company.getName())) {
         Company company1 = new Company();
         company1.setName(company.getName());
         company1.setDirector(company.getDirector());
         company1.setActive(company.isActive());
         companyRepository.save(company1);
         apiResponse.setMessage("Added");
         apiResponse.setSuccess(true);
      }
      apiResponse.setMessage("Already exist");
      apiResponse.setSuccess(false);
      return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
   }
   @PutMapping("/{id}")
   public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody Company company){
      ApiResponse apiResponse=new ApiResponse();
      Optional<Company> byId = companyRepository.findById(company.getId());
      if (!byId.isPresent()) {
         apiResponse.setSuccess(false);
         apiResponse.setMessage("Not found");
      }
      Company company1 = byId.get();
      company1.setName(company.getName());
      company1.setDirector(company.getDirector());
      company1.setActive(true);
       companyRepository.save(company1);
       apiResponse.setMessage("Added");
       apiResponse.setSuccess(true);
       return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
   }
}
