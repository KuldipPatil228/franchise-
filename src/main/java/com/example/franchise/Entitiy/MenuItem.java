package com.example.franchise.Entitiy;

import com.example.franchise.Enums.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Entity
@Data
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Item> items;

    public MenuItem() {
    }

    public MenuItem(Long id, List<Item> items) {
        this.id = id;
        this.items = items;
    }
}
