package com.example.aloqa_kompaniya.service;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.dto.MobileOperatorDto;
import com.example.aloqa_kompaniya.entity.MobileOperator;
import com.example.aloqa_kompaniya.repository.MobileOperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MobileOperatorService {
    final MobileOperatorRepository mobileOperatorRepository;

    public ApiResponse add(MobileOperatorDto dto) {
        if(mobileOperatorRepository.existsByName(dto.getName())){
            return new ApiResponse("Already exist",false);
        }
        MobileOperator mobileOperator=new MobileOperator();
        mobileOperator.setName(dto.getName());

        mobileOperatorRepository.save(mobileOperator);
        return new ApiResponse("Added",true);
    }

    public ApiResponse edit(Integer id, MobileOperatorDto dto) {
        Optional<MobileOperator> byId = mobileOperatorRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        MobileOperator mobileOperator = byId.get();
        mobileOperator.setName(dto.getName());

        return new ApiResponse("Edited",true);
    }
}
