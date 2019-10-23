package com.example.RestaurantApp.repository;

import com.example.RestaurantApp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
