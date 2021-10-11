package com.example.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long senderId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String sendersCardNumber;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String receiversCardNumber;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;
}
