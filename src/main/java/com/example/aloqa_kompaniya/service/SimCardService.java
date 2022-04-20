package com.example.aloqa_kompaniya.service;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.dto.SimCardDto;
import com.example.aloqa_kompaniya.entity.Employee;
import com.example.aloqa_kompaniya.entity.MobileOperator;
import com.example.aloqa_kompaniya.entity.SimCard;
import com.example.aloqa_kompaniya.repository.EmployeeRepository;
import com.example.aloqa_kompaniya.repository.MobileOperatorRepository;
import com.example.aloqa_kompaniya.repository.SimCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimCardService {
    final SimCardRepository simCardRepository;
     final MobileOperatorRepository mobileOperatorRepository;
     final EmployeeRepository employeeRepository;

    public ApiResponse add(SimCardDto dto) {
        if (simCardRepository.existsByNumber(dto.getNumber())) {
            return new ApiResponse("Already exist",false);
        }
        SimCard simCard=new SimCard();
        simCard.setActive(dto.isActive());
        simCard.setNumber(dto.getNumber());
        simCard.setBalance(dto.getBalance());
        simCard.setPinCode(dto.getPinCode());
        simCard.setExpiredDate(dto.getExpiredDate());
        simCard.setMb(dto.getMb());
        simCard.setSms(dto.getSms());
        simCard.setMinute(dto.getMinute());
        Optional<MobileOperator> byId = mobileOperatorRepository.findById(dto.getMobileOperatorId());
        simCard.setMobileOperator(byId.get());
        Optional<Employee> byId1 = employeeRepository.findById(dto.getEmployeeId());
        simCard.setEmployee(byId1.get());
        simCardRepository.save(simCard);
        return new ApiResponse("Added",true);

    }

    public ApiResponse edit(Integer id, SimCardDto dto) {
        Optional<SimCard> byId = simCardRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        SimCard simCard = byId.get();
        simCard.setActive(dto.isActive());
        simCard.setNumber(dto.getNumber());
        simCard.setBalance(dto.getBalance());
        simCard.setPinCode(dto.getPinCode());
        simCard.setExpiredDate(dto.getExpiredDate());
        simCard.setMb(dto.getMb());
        simCard.setSms(dto.getSms());
        simCard.setMinute(dto.getMinute());
        Optional<MobileOperator> byId1 = mobileOperatorRepository.findById(dto.getMobileOperatorId());
        simCard.setMobileOperator(byId1.get());
        Optional<Employee> byId2 = employeeRepository.findById(dto.getEmployeeId());
        simCard.setEmployee(byId2.get());
        simCardRepository.save(simCard);
        return new ApiResponse("Edited",true);
    }
}
