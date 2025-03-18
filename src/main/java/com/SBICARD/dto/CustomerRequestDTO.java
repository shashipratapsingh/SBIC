//package com.SBICARD.dto;
//
//import lombok.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Builder
//@Data
//public class CustomerRequestDTO {
//    //@NotNull(message = "Unique Customer ID is required") // Validation (optional)
//    private String uniqueCustomerId;
//    private String name;
//    private int age;
//    private String city;
//    private double income;
//    private String product;
//    private String uniqueAccountIdentifier;
//    private boolean multiCardingFlag;
//    private double feeAmount;
//
//    // Getters, setters, constructor, and toString() (generated or manually written)
//    // (The code below is redundant with Lombok annotations, but provided as per your code style)
//    public String getUniqueCustomerId() {
//        return uniqueCustomerId;
//    }
//
//    public void setUniqueCustomerId(String uniqueCustomerId) {
//        this.uniqueCustomerId = uniqueCustomerId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public double getIncome() {
//        return income;
//    }
//
//    public void setIncome(double income) {
//        this.income = income;
//    }
//
//    public String getProduct() {
//        return product;
//    }
//
//    public void setProduct(String product) {
//        this.product = product;
//    }
//
//    public String getUniqueAccountIdentifier() {
//        return uniqueAccountIdentifier;
//    }
//
//    public void setUniqueAccountIdentifier(String uniqueAccountIdentifier) {
//        this.uniqueAccountIdentifier = uniqueAccountIdentifier;
//    }
//
//    public boolean isMultiCardingFlag() {
//        return multiCardingFlag;
//    }
//
//    public void setMultiCardingFlag(boolean multiCardingFlag) {
//        this.multiCardingFlag = multiCardingFlag;
//    }
//
//    public double getFeeAmount() {
//        return feeAmount;
//    }
//
//    public void setFeeAmount(double feeAmount) {
//        this.feeAmount = feeAmount;
//    }
//
//    public CustomerRequestDTO(String uniqueCustomerId, String name, int age, String city, double income, String product, String uniqueAccountIdentifier, boolean multiCardingFlag, double feeAmount) {
//        this.uniqueCustomerId = uniqueCustomerId;
//        this.name = name;
//        this.age = age;
//        this.city = city;
//        this.income = income;
//        this.product = product;
//        this.uniqueAccountIdentifier = uniqueAccountIdentifier;
//        this.multiCardingFlag = multiCardingFlag;
//        this.feeAmount = feeAmount;
//    }
//
//    @Override
//    public String toString() {
//        return "CustomerRequestDTO{" +
//                "uniqueCustomerId='" + uniqueCustomerId + '\'' +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", city='" + city + '\'' +
//                ", income=" + income +
//                ", product='" + product + '\'' +
//                ", uniqueAccountIdentifier='" + uniqueAccountIdentifier + '\'' +
//                ", multiCardingFlag=" + multiCardingFlag +
//                ", feeAmount=" + feeAmount +
//                '}';
//    }
//}
