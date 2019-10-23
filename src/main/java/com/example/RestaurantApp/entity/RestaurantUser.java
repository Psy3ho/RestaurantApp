package com.example.RestaurantApp.entity;

import com.example.RestaurantApp.model.Person;
import com.example.RestaurantApp.model.TypeOfUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "restaurant_users")
public class RestaurantUser extends Person {
    @Column(name = "user_type")
    private TypeOfUser typeOfUser;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    public RestaurantUser() {
        this.typeOfUser = TypeOfUser.GUEST;
        this.reviews = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestaurantUser)) return false;
        RestaurantUser that = (RestaurantUser) o;
        return getTypeOfUser() == that.getTypeOfUser() &&
                getReviews().equals(that.getReviews()) &&
                getFirstName().equals(that.getFirstName()) &&
                getLastName().equals(that.getLastName()) &&
                getId().equals(that.getId()) &&
                getUser_type().equals(that.getUser_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeOfUser(), getReviews());
    }

    public Set<Review> getReviews() {

        return this.reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public void addReview(Review review) {
        review.setUser(this);
        reviews.add(review);
    }


}
