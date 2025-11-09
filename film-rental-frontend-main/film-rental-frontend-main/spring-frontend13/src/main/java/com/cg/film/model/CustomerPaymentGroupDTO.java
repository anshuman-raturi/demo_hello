package com.cg.film.model;

import java.util.List;

public class CustomerPaymentGroupDTO {
    private String firstName;
    private String lastName;
    private List<PaymentDetailDTO> payments;
    public CustomerPaymentGroupDTO() {
    	
    }
    
    public CustomerPaymentGroupDTO(String firstName, String lastName, List<PaymentDetailDTO> payments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.payments = payments;
    }
    
    

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public List<PaymentDetailDTO> getPayments() { return payments; }
    public void setPayments(List<PaymentDetailDTO> payments) { this.payments = payments; }
}
    

   
