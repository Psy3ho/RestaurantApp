package com.example.RestaurantApp.restaurantUser;

import com.example.RestaurantApp.model.Person;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "restaurant_users")
public class RestaurantUser extends Person {
    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant_user")
    private Set<Review> reviews;

    protected Set<Review> getReviews() {
        if(this.reviews != null) {
            this.reviews = new HashSet<>();
        }
        return this.reviews;
    }

    @Override
    public String toString() {
        return "RestaurantUser{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        review.setUser(this);
        reviews.add(review);
    }
}
