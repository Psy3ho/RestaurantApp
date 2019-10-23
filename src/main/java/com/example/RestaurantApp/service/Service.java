package com.example.RestaurantApp.service;


import com.example.RestaurantApp.entity.Restaurant;
import com.example.RestaurantApp.entity.RestaurantUser;
import com.example.RestaurantApp.entity.Review;
import com.example.RestaurantApp.model.TypeOfUser;
import com.example.RestaurantApp.repository.RestaurantRepository;
import com.example.RestaurantApp.repository.ReviewRepository;
import com.example.RestaurantApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class Service implements IService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(String FirstName, String lastName, String adress, String city, String mail) {
        RestaurantUser restaurantUser = new RestaurantUser();

        restaurantUser.setFirstName(FirstName);
        restaurantUser.setLastName(lastName);
        restaurantUser.setAddress(adress);
        restaurantUser.setCity(city);
        restaurantUser.setMail(mail);
        userRepository.save(restaurantUser);
    }

    @Override
    public Optional<RestaurantUser> findUserById(Long id) {

        return userRepository.findById(id);

    }

    @Override
    public List<RestaurantUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<RestaurantUser> deleteUser(Long id) {
        Optional<RestaurantUser> toBeDeleted = findUserById(id);
        if (toBeDeleted.isPresent()) {
            userRepository.delete(toBeDeleted.get());

        }
        return toBeDeleted;
    }

    @Override
    public void updateUser(Long id, String firstName, String lastName, String adress, String city, TypeOfUser userType, String mail) {
        Optional<RestaurantUser> tobeUpdated = findUserById(id);
        if (tobeUpdated.isPresent()) {
            RestaurantUser present = tobeUpdated.get();
            if (firstName != null) {
                present.setFirstName(firstName);
            }
            if (lastName != null) {
                present.setLastName(lastName);
            }
            if (adress != null) {
                present.setAddress(adress);
            }
            if (city != null) {
                present.setCity(city);
            }
            if (userType != null) {
                present.setTypeOfUser(userType);
            }
            if (mail != null) {
                present.setMail(mail);
            }
        }

    }

    @Override
    public void setUserType(Long id, TypeOfUser userType) {
        Optional<RestaurantUser> restaurantUser = findUserById(id);
        if (restaurantUser.isPresent()) {
            restaurantUser.get().setTypeOfUser(userType);
        }
    }

    @Override
    public void addReview(Long userId, Long restaurantId, String text) {
        Optional<RestaurantUser> user = findUserById(userId);
        Optional<Restaurant> restaurant = findrestaurantById(restaurantId);
        if (user.isPresent() && restaurant.isPresent()) {
            Review review = new Review();
            review.setText(text);
            user.get().addReview(review);
            restaurant.get().addReview(review);
            reviewRepository.save(review);
            restaurantRepository.save(restaurant.get());
            userRepository.save(user.get());

        }

    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Review> getReviewsForUser(Long userId) {
        return null;
    }

    @Override
    public List<Review> getReviewsForRestaurant(Long restaurantId) {
        return null;
    }

    @Override
    public List<Review> getAllReviews() {
        System.out.println(reviewRepository.count());
        List<Review> reviews = reviewRepository.findAll();
        return reviews;

    }

    @Override
    public void setReviewHidden(Long reviewId) {

    }

    @Override
    public void setReviewShow(Long reviewId) {

    }

    @Override
    public void addRestaurant(String name, String mail, String adress, String city) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setAddress(adress);
        restaurant.setCity(city);
        restaurant.setMail(mail);
        restaurantRepository.save(restaurant);


    }

    @Override
    public Optional<Restaurant> findrestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
