package com.example.RestaurantApp.repository;

import com.example.RestaurantApp.entity.RestaurantUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<RestaurantUser, Long> {
}
