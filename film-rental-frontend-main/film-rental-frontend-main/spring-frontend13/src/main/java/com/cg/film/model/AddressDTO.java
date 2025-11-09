package com.cg.film.model;
import java.sql.Timestamp;

public class AddressDTO {
    private Long addressId;
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
    private Timestamp lastUpdate;

  
    public Long getAddressId() { return addressId; }
    public void setAddressId(Long addressId) { this.addressId = addressId; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getAddress2() { return address2; }
    public void setAddress2(String address2) { this.address2 = address2; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Timestamp getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(Timestamp lastUpdate) { this.lastUpdate = lastUpdate; }
}