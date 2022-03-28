package com.modelclasses;

public class CreditCardDetails {
    private String creditCardNo;
    public CreditCardDetails(String creditCardNo){
        this.creditCardNo=creditCardNo;

    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardNo='" + creditCardNo + '\'' +
                '}';
    }
}
