package com.example.foodorderingsystem.repository;

import com.example.foodorderingsystem.entity.Addition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionRepository extends JpaRepository<Addition, Long> {
}
