package com.example.aloqa_kompaniya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TariffDto {
    private String name;
    private Integer mobileOperatorId;
    private Double payOfMonth;
    private Timestamp expiredDate;
    private String status;
    private boolean active;
    private int mb;
    private int sms;
    private int minute;

}
