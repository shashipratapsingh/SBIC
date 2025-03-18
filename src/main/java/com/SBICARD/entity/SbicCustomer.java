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
    private String cibilSegmentation;
    private boolean multiCarding;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUniqueCustomerIdentifier() {
        return uniqueCustomerIdentifier;
    }

    public void setUniqueCustomerIdentifier(String uniqueCustomerIdentifier) {
        this.uniqueCustomerIdentifier = uniqueCustomerIdentifier;
    }

    public String getUniqueAccountIdentifier() {
        return uniqueAccountIdentifier;
    }

    public void setUniqueAccountIdentifier(String uniqueAccountIdentifier) {
        this.uniqueAccountIdentifier = uniqueAccountIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getSurrogate() {
        return surrogate;
    }

    public void setSurrogate(String surrogate) {
        this.surrogate = surrogate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public int getCibilScore() {
        return cibilScore;
    }

    public void setCibilScore(int cibilScore) {
        this.cibilScore = cibilScore;
    }

    public String getCibilSegmentation() {
        return cibilSegmentation;
    }

    public void setCibilSegmentation(String cibilSegmentation) {
        this.cibilSegmentation = cibilSegmentation;
    }

    public boolean isMultiCarding() {
        return multiCarding;
    }

    public void setMultiCarding(boolean multiCarding) {
        this.multiCarding = multiCarding;
    }

    @Override
    public String toString() {
        return "SbicCustomer{" +
                "uniqueId='" + uniqueId + '\'' +
                ", uniqueCustomerIdentifier='" + uniqueCustomerIdentifier + '\'' +
                ", uniqueAccountIdentifier='" + uniqueAccountIdentifier + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", income=" + income +
                ", surrogate='" + surrogate + '\'' +
                ", product='" + product + '\'' +
                ", premium=" + premium +
                ", feeAmount=" + feeAmount +
                ", cibilScore=" + cibilScore +
                ", cibilSegmentation='" + cibilSegmentation + '\'' +
                ", multiCarding=" + multiCarding +
                '}';
    }

    public SbicCustomer(String uniqueId, String uniqueCustomerIdentifier, String uniqueAccountIdentifier, String name, int age, String city, double income, String surrogate, String product, boolean premium, double feeAmount, int cibilScore, String cibilSegmentation, boolean multiCarding) {
        this.uniqueId = uniqueId;
        this.uniqueCustomerIdentifier = uniqueCustomerIdentifier;
        this.uniqueAccountIdentifier = uniqueAccountIdentifier;
        this.name = name;
        this.age = age;
        this.city = city;
        this.income = income;
        this.surrogate = surrogate;
        this.product = product;
        this.premium = premium;
        this.feeAmount = feeAmount;
        this.cibilScore = cibilScore;
        this.cibilSegmentation = cibilSegmentation;
        this.multiCarding = multiCarding;
    }
}