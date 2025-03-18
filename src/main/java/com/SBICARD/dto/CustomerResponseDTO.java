//package com.SBICARD.dto;
//
//import com.SBICARD.entity.Customer;
//import lombok.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Builder
//@Data
//public class CustomerResponseDTO {
//    private String uniqueCustomerId;
//    private String name;
//    private int age;
//    private String city;
//    private double income;
//    private String product;
//    private String uniqueAccountIdentifier;
//    private boolean multiCardingFlag;
//    private double feeAmount;
//    private String eCardUrl;
//
//    public CustomerResponseDTO(String uniqueCustomerId, String name, int age, String city, double income, String product, String uniqueAccountIdentifier, boolean multiCardingFlag, double feeAmount, String eCardUrl) {
//        this.uniqueCustomerId = uniqueCustomerId;
//        this.name = name;
//        this.age = age;
//        this.city = city;
//        this.income = income;
//        this.product = product;
//        this.uniqueAccountIdentifier = uniqueAccountIdentifier;
//        this.multiCardingFlag = multiCardingFlag;
//        this.feeAmount = feeAmount;
//        this.eCardUrl = eCardUrl;
//    }
//
//    // CHANGED: Updated constructor to properly map fields from the Customer entity
//    public CustomerResponseDTO(Customer customer) {
//        this.uniqueCustomerId = customer.getUniqueCustomerId();
//        this.name = customer.getName();
//        this.age = customer.getAge();
//        this.city = customer.getCity();
//        this.income = customer.getIncome();
//        this.product = customer.getProduct();
//        this.uniqueAccountIdentifier = customer.getUniqueAccountIdentifier();
//        this.multiCardingFlag = customer.isMultiCardingFlag();
//        this.feeAmount = customer.getFeeAmount();
//        this.eCardUrl = customer.geteCardUrl();
//    }
//
//    // Getters and setters are provided by Lombok
//    @Override
//    public String toString() {
//        return "CustomerResponseDTO{" +
//                "uniqueCustomerId='" + uniqueCustomerId + '\'' +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", city='" + city + '\'' +
//                ", income=" + income +
//                ", product='" + product + '\'' +
//                ", uniqueAccountIdentifier='" + uniqueAccountIdentifier + '\'' +
//                ", multiCardingFlag=" + multiCardingFlag +
//                ", feeAmount=" + feeAmount +
//                ", eCardUrl='" + eCardUrl + '\'' +
//                '}';
//    }
//}
