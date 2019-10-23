package com.example.RestaurantApp.entity;

import com.example.RestaurantApp.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant extends NamedEntity {


    @OneToMany(mappedBy = "restaurant")
    private Set<Review> reviews;

    // public Restaurant() {
    //    this.reviews = new HashSet<>();
    // }

    public Set<Review> getReviews() {

        return this.reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name =" + getName() +
                '}';
    }


    //dorobit menu item


}
