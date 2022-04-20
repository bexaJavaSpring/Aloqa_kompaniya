package com.example.aloqa_kompaniya.controller;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.dto.SimCardDto;
import com.example.aloqa_kompaniya.repository.SimCardRepository;
import com.example.aloqa_kompaniya.service.SimCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/simcard")
@RestController
@RequiredArgsConstructor
public class SimCardController {

    final SimCardRepository simCardRepository;
    final SimCardService simCardService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(simCardRepository.findAll());
    }
    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody SimCardDto dto){
        ApiResponse apiResponse=simCardService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody SimCardDto dto){
        ApiResponse apiResponse=simCardService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
