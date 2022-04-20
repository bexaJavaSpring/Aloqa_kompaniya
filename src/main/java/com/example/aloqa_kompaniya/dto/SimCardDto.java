package com.example.aloqa_kompaniya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimCardDto {
    private String number;
    private Timestamp expiredDate;
    private Integer employeeId;
    private String pinCode;
    private Double balance;
    private Integer mobileOperatorId;
    private int mb;
    private int sms;
    private int minute;
    private boolean active;
}
