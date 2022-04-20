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
@Entity(name = "calhistory")
public class CallHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private SimCard fromUser;
    @ManyToOne
    private SimCard toUser;
    @CreationTimestamp
    private Timestamp when;
    private Integer seconds = 0;
    @Enumerated(EnumType.STRING)
    private SimCardStatus status;

}
