package com.example.aloqa_kompaniya.entity;

import com.example.aloqa_kompaniya.entity.enums.SimCardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "smhistory")
public class SMSHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private SimCard fromUser;
    @ManyToOne
    private SimCard toUser;
    @CreationTimestamp
    private Timestamp when;
    private String message;
    @Enumerated(EnumType.STRING)
    private SimCardStatus status;
}
