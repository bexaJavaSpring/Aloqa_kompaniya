package com.example.aloqa_kompaniya.controller;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.dto.TariffDto;
import com.example.aloqa_kompaniya.repository.TariffRepository;
import com.example.aloqa_kompaniya.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/tariff")
@RestController
@RequiredArgsConstructor
public class TariffController {
    final TariffRepository tariffRepository;
    final TariffService tariffService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(tariffRepository.findAll());
    }
    @PostMapping("/add")
    public HttpEntity<?>add(@Valid @RequestBody TariffDto dto){
        ApiResponse apiResponse=tariffService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody TariffDto dto){
        ApiResponse apiResponse=tariffService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}
