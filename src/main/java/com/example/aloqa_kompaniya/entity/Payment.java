package com.example.aloqa_kompaniya.entity;

import com.example.aloqa_kompaniya.entity.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     @OneToOne
     private Employee employee;
     @Enumerated(EnumType.STRING)
     private PaymentType paymentType;
     private Timestamp PayDate;

}
