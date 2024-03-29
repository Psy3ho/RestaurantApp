package com.example.RestaurantApp.model;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    //generating id's , very helpful for future addons
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
