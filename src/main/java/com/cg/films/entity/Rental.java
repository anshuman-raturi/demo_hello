package com.cg.films.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rental_date", "inventory_id", "customer_id"})
})
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer rentalId;

    @Column(name = "rental_date", nullable = false)
    private LocalDateTime rentalDate;

    @Column(name = "inventory_id", nullable = false)
    private Integer inventoryId;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "staff_id", nullable = false)
    private Integer staffId;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;


    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}