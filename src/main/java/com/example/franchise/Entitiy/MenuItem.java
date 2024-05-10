package com.example.franchise.Entitiy;

import com.example.franchise.Enums.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
//@Table(name = "Menu_Item")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    private String itemName;
    private double amount;

    @Enumerated(EnumType.STRING)
    private Category category;


    public MenuItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MenuItem(Long id, Long quantity, String itemName, Long amount, Category category) {
        this.id = id;
        this.quantity = quantity;
        this.itemName = itemName;
        this.amount = amount;
        this.category = category;
    }


}
