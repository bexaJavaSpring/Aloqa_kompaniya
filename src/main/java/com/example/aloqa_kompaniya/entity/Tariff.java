package com.example.aloqa_kompaniya.entity;

import com.example.aloqa_kompaniya.entity.enums.TariffStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private MobileOperator mobileOperator;
    private String name;
    private Double payOfMonth;
    private int mb;
    private int sms;
    private int minute;
    private Timestamp expiredDate;
    @Enumerated(EnumType.STRING)
    private TariffStatus tariffStatus;
    private boolean active;
}
