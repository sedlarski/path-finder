package com.sedlarski.pathfinder.repository;

import com.sedlarski.pathfinder.model.entity.Category;
import com.sedlarski.pathfinder.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
