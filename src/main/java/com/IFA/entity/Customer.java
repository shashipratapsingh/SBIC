package com.IFA.entity;

import com.IFA.enums.CardStatus;
import com.IFA.enums.CibilSegment;
import com.IFA.enums.CustomerType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@Data
public class Customer {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 // @Column(unique = true, nullable = false) // Uncomment if needed
 private String uniqueCustomerId; // Unique ID from CDP

 private String name;
 private int age;
 private String city;
 private double income;
 private String surrogate;
 private String product;
 private String uniqueAccountIdentifier;
 private boolean multiCardingFlag;

 @Enumerated(EnumType.STRING)
 private CibilSegment cibilSegment; // CIBIL-Based segmentation

 @Enumerated(EnumType.STRING)
 private CustomerType customerType; // PREMIUM / NON-PREMIUM

 private double feeAmount;
 private LocalDate createdDate;

 @Enumerated(EnumType.STRING)
 private CardStatus cardStatus;
 private String eCardUrl; // Link to e-card

 // Getters and setters (if not using Lombok) are provided below

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getUniqueCustomerId() {
  return uniqueCustomerId;
 }

 public void setUniqueCustomerId(String uniqueCustomerId) {
  this.uniqueCustomerId = uniqueCustomerId;
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

 public String getUniqueAccountIdentifier() {
  return uniqueAccountIdentifier;
 }

 public void setUniqueAccountIdentifier(String uniqueAccountIdentifier) {
  this.uniqueAccountIdentifier = uniqueAccountIdentifier;
 }

 public boolean isMultiCardingFlag() {
  return multiCardingFlag;
 }

 public void setMultiCardingFlag(boolean multiCardingFlag) {
  this.multiCardingFlag = multiCardingFlag;
 }

 public CibilSegment getCibilSegment() {
  return cibilSegment;
 }

 public void setCibilSegment(CibilSegment cibilSegment) {
  this.cibilSegment = cibilSegment;
 }

 public CustomerType getCustomerType() {
  return customerType;
 }

 public void setCustomerType(CustomerType customerType) {
  this.customerType = customerType;
 }

 public double getFeeAmount() {
  return feeAmount;
 }

 public void setFeeAmount(double feeAmount) {
  this.feeAmount = feeAmount;
 }

 public LocalDate getCreatedDate() {
  return createdDate;
 }

 public void setCreatedDate(LocalDate createdDate) {
  this.createdDate = createdDate;
 }

 public CardStatus getCardStatus() {
  return cardStatus;
 }

 public void setCardStatus(CardStatus cardStatus) {
  this.cardStatus = cardStatus;
 }

 public String geteCardUrl() {
  return eCardUrl;
 }

 public void seteCardUrl(String eCardUrl) {
  this.eCardUrl = eCardUrl;
 }

 @Override
 public String toString() {
  return "Customer{" +
          "id=" + id +
          ", uniqueCustomerId='" + uniqueCustomerId + '\'' +
          ", name='" + name + '\'' +
          ", age=" + age +
          ", city='" + city + '\'' +
          ", income=" + income +
          ", surrogate='" + surrogate + '\'' +
          ", product='" + product + '\'' +
          ", uniqueAccountIdentifier='" + uniqueAccountIdentifier + '\'' +
          ", multiCardingFlag=" + multiCardingFlag +
          ", cibilSegment=" + cibilSegment +
          ", customerType=" + customerType +
          ", feeAmount=" + feeAmount +
          ", createdDate=" + createdDate +
          ", cardStatus=" + cardStatus +
          ", eCardUrl='" + eCardUrl + '\'' +
          '}';
 }
}
