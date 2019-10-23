package com.example.RestaurantApp.controller;

import com.example.RestaurantApp.entity.Restaurant;
import com.example.RestaurantApp.entity.RestaurantUser;
import com.example.RestaurantApp.entity.Review;
import com.example.RestaurantApp.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class Controller {
    @Autowired
    Service service;

    ////USERS
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> adduser(@RequestParam String FirstName, @RequestParam String lastName, @RequestParam String adress, @RequestParam String city, @RequestParam String mail) {
        System.out.println("Paramerers : " + FirstName + " " + lastName + " " + adress + " " + city + " " + mail);
        service.addUser(FirstName, lastName, adress, city, mail);
        return new ResponseEntity<String>("Account created successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantUser>> getAllUsers() {
        return new ResponseEntity<List<RestaurantUser>>(service.getAllUsers(), HttpStatus.OK);
    }

    ////RESTAURANT
    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    public ResponseEntity<String> addRestaurant(@RequestParam String name, @RequestParam String mail, @RequestParam String adress, @RequestParam String city) {
        service.addRestaurant(name, mail, adress, city);
        return new ResponseEntity<String>("Restaurant created successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return new ResponseEntity<List<Restaurant>>(service.getAllRestaurants(), HttpStatus.OK);
    }

    ////REVIEW
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public ResponseEntity<String> addReview(@RequestParam Long userId, @RequestParam Long restaurantId, @RequestParam String text) {
        service.addReview(userId, restaurantId, text);
        return new ResponseEntity<String>("Review created successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getAllreviews() {
        return new ResponseEntity<List<Review>>(service.getAllReviews(), HttpStatus.OK);
    }


}
