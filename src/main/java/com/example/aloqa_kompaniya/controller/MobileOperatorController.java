package com.example.aloqa_kompaniya.controller;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.dto.MobileOperatorDto;
import com.example.aloqa_kompaniya.repository.MobileOperatorRepository;
import com.example.aloqa_kompaniya.service.MobileOperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/mobileOperator")
@RestController
@RequiredArgsConstructor
public class MobileOperatorController {
    final MobileOperatorRepository mobileOperatorRepository;
    MobileOperatorService mobileOperatorService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(mobileOperatorRepository.findAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getone(@PathVariable Integer id){
        return ResponseEntity.ok().body(mobileOperatorRepository.findById(id).get());
    }
    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody MobileOperatorDto dto){
        ApiResponse apiResponse=mobileOperatorService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody MobileOperatorDto dto){
        ApiResponse apiResponse=mobileOperatorService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
