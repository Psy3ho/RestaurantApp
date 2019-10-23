package com.example.RestaurantApp.service;

import com.example.RestaurantApp.entity.Restaurant;
import com.example.RestaurantApp.entity.RestaurantUser;
import com.example.RestaurantApp.entity.Review;
import com.example.RestaurantApp.model.TypeOfUser;

import java.util.List;
import java.util.Optional;

public interface IService {
    //USER
    /////CREATE
    void addUser(String FirstName, String lastName, String adress, String city, String mail);

    ////GET
    Optional<RestaurantUser> findUserById(Long id);

    List<RestaurantUser> getAllUsers();

    ////DELETE
    Optional<RestaurantUser> deleteUser(Long id);

    ////UPDATE
    void updateUser(Long id, String firstName, String lastName, String adress, String city, TypeOfUser userType, String mail);

    void setUserType(Long id, TypeOfUser userType);
    //USER

    //REVIEW
    void addReview(Long userId, Long restaurantId, String text); //hidden=false

    ////GET
    Optional<Review> findReviewById(Long id);

    List<Review> getReviewsForUser(Long userId);

    List<Review> getReviewsForRestaurant(Long restaurantId);

    List<Review> getAllReviews();

    ////HIDE
    void setReviewHidden(Long reviewId);

    ////SHOW
    void setReviewShow(Long reviewId);

    //RESTAURANT
    void addRestaurant(String name, String mail, String adress, String city);

    ////GET
    Optional<Restaurant> findrestaurantById(Long id);

    List<Restaurant> getAllRestaurants();


}
