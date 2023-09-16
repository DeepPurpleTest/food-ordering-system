package com.example.foodorderingsystem.repository;

import com.example.foodorderingsystem.entity.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunchRepository extends JpaRepository<Lunch, Long> {
}
