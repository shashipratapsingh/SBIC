package com.SBICARD.dto;

import com.SBICARD.entity.SbicCustomer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
@Getter
@Setter
@NoArgsConstructor
public class SbicCustomerResponse {
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

    // Convert Entity to DTO
    public static SbicCustomerResponse fromEntity(SbicCustomer sbicCustomer) {
        SbicCustomerResponse sbicCustomerResponse = new SbicCustomerResponse();
        BeanUtils.copyProperties(sbicCustomer, sbicCustomerResponse);
        return sbicCustomerResponse;
    }

}
