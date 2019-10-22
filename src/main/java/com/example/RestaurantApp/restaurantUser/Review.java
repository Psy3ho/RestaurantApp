package com.example.RestaurantApp.restaurantUser;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-nn-yyyy")
    private Date dateOfPosting;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private RestaurantUser user;

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
                ", user=" + user +
                '}';
    }
}
