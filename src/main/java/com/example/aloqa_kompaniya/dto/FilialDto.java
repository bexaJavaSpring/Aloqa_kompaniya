package com.example.aloqa_kompaniya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilialDto {
    private String name;
    private Integer directorId;
    private Integer companyId;
}
