package com.example.aloqa_kompaniya.controller;

import com.example.aloqa_kompaniya.repository.SmsHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/smshitory")
@RestController
@RequiredArgsConstructor
public class SMSHistoryController {
    final SmsHistoryRepository smsHistoryRepository;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(smsHistoryRepository.findAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(smsHistoryRepository.findById(id).get());
    }
}
