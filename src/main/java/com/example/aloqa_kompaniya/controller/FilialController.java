package com.example.aloqa_kompaniya.controller;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.dto.FilialDto;
import com.example.aloqa_kompaniya.repository.FilialRepository;
import com.example.aloqa_kompaniya.service.FilialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/filial")
@RestController
@RequiredArgsConstructor
public class FilialController {
    final FilialRepository filialRepository;
    final FilialService filialService;

    @GetMapping
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok().body(filialRepository.findAll());
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody FilialDto dto) {
        ApiResponse apiResponse=filialService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody FilialDto dto){
        ApiResponse apiResponse=filialService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}
