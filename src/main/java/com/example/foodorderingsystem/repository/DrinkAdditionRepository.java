package com.example.foodorderingsystem.repository;

import com.example.foodorderingsystem.entity.DrinkWithAddition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkAdditionRepository extends JpaRepository<DrinkWithAddition, Long> {
}
