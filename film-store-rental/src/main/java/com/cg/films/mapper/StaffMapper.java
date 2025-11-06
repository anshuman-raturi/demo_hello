package com.cg.films.mapper;
 
import com.cg.films.dto.AddressDTO;
import com.cg.films.dto.StaffBasicDTO;
import com.cg.films.entity.Staff;
import com.cg.films.entity.Address;
 
public class StaffMapper {
 
    public static StaffBasicDTO toBasicDTO(Staff staff) {
        if (staff == null) return null;
 
        Long addressId = staff.getAddress() != null ? staff.getAddress().getAddressId() : null;
        return new StaffBasicDTO(staff.getFirstName(), staff.getLastName(), addressId);
    }
 
    public static AddressDTO toAddressDTO(Address address) {
        if (address == null) return null;
 
        AddressDTO dto = new AddressDTO();
        dto.setAddressId(address.getAddressId());
        dto.setAddress(address.getAddress());
        dto.setAddress2(address.getAddress2());
        dto.setDistrict(address.getDistrict());
        dto.setPostalCode(address.getPostalCode());
        dto.setPhone(address.getPhone());
        dto.setLastUpdate(address.getLastUpdate());
        return dto;
    }
}