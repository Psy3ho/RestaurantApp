package com.example.RestaurantApp.entity;

import com.example.RestaurantApp.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review extends BaseEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-nn-yyyy")
    private Date dateOfPosting;
    @Column(name = "hiddden")
    private boolean hidden;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @JsonIgnore
    private RestaurantUser user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_user_id", referencedColumnName = "id")
    @JsonIgnore
    private Restaurant restaurant;

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateOfPosting() {
        return dateOfPosting;
    }

    public void setDateOfPosting(Date dateOfPosting) {
        this.dateOfPosting = dateOfPosting;
    }

    public RestaurantUser getUser() {
        return user;
    }

    public void setUser(RestaurantUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                ", dateOfPosting=" + dateOfPosting +
                //", user=" + user +
                '}';
    }
}
