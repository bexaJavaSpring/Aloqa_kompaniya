package com.example.aloqa_kompaniya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private Integer  companyId;
    private String phone;

    private String username;

    private String email;

    private String fullName;

    private String password;
}
