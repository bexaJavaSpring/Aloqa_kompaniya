package com.example.aloqa_kompaniya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private Timestamp expiredDate;
    @Column(length = 13, unique = true)
    private String number;
    @ManyToOne
    private Employee employee;
    private String pinCode;
    private Double balance;
    private int mb;
    private int sms;
    private int minute;
    @OneToOne
    private MobileOperator mobileOperator;
    private boolean active;


}
