package com.example.foodorderingsystem.repository;

import com.example.foodorderingsystem.entity.DrinkAddition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkAdditionRepository extends JpaRepository<DrinkAddition, Long> {
}
