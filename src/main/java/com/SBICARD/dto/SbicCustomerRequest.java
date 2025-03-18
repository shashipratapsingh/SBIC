package com.SBICARD.dto;

import com.SBICARD.entity.SbicCustomer;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class SbicCustomerRequest {
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

    // Convert DTO to Entity
    public SbicCustomer toEntity() {
        SbicCustomer sbicCustomer = new SbicCustomer();
        BeanUtils.copyProperties(this, sbicCustomer);
        return sbicCustomer;
    }
}