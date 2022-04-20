package com.example.aloqa_kompaniya.service;

import com.example.aloqa_kompaniya.dto.ApiResponse;
import com.example.aloqa_kompaniya.dto.TariffDto;
import com.example.aloqa_kompaniya.entity.Tariff;
import com.example.aloqa_kompaniya.entity.enums.TariffStatus;
import com.example.aloqa_kompaniya.repository.TariffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TariffService {
    final TariffRepository tariffRepository;

    public ApiResponse add(TariffDto dto) {
        if(tariffRepository.existsByName(dto.getName())){
            return new ApiResponse("Already exist",false);
        }
        Tariff tariff=new Tariff();
        tariff.setName(dto.getName());
        tariff.setPayOfMonth(dto.getPayOfMonth());
        tariff.setExpiredDate(dto.getExpiredDate());
        tariff.setActive(dto.isActive());
        tariff.setMb(dto.getMb());
        tariff.setSms(dto.getSms());
        tariff.setMinute(dto.getMinute());
        tariff.setTariffStatus(TariffStatus.valueOf(dto.getStatus()));
       tariffRepository.save(tariff);
       return new ApiResponse("Added",true);
    }

    public ApiResponse edit(Integer id, TariffDto dto) {
        Optional<Tariff> byId = tariffRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Tariff tariff = byId.get();
        tariff.setName(dto.getName());
        tariff.setPayOfMonth(dto.getPayOfMonth());
        tariff.setExpiredDate(dto.getExpiredDate());
        tariff.setActive(dto.isActive());
        tariff.setMb(dto.getMb());
        tariff.setSms(dto.getSms());
        tariff.setMinute(dto.getMinute());
        tariff.setTariffStatus(TariffStatus.valueOf(dto.getStatus()));
        tariffRepository.save(tariff);
        return new ApiResponse("Edited",true);
    }
}
