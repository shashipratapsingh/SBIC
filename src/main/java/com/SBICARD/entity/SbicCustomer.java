package com.SBICARD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SbicCustomer {
    @Id
    private String uniqueId;
    private String uniqueCustomerIdentifier;
    private String uniqueAccountIdentifier;
    private String name;
    private int age;
    private String city;
    private double income;
    private String surrogate;
    private String product;
    private boolean premium;
    private double feeAmount;
    private int cibilScore;
    private String adharCardNo;
    private String cibilSegmentation;
    private boolean multiCarding;
    private String status;
}