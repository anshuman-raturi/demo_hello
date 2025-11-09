package com.cg.film.model;

public class StaffBasicDTO {
    private String firstName;
    private String lastName;
    private String fullName;
    private Long addressId;
    public StaffBasicDTO() {}
    public StaffBasicDTO(String firstName, String lastName, Long addressId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.addressId = addressId;
    }
 
	public String getFirstName() {
		return firstName;
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
	public String getLastName() {
		return lastName;
	}
 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
	public String getFullName() {
		return fullName;
	}
 
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
 
	public Long getAddressId() {
		return addressId;
	}
 
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
 
    // Getters and setters
}