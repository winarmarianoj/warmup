package com.marianowinar.warmup.repository;

import com.marianowinar.warmup.model.Category;
import com.marianowinar.warmup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("FROM Category c WHERE c.category = :category")
    Category findByCategory(@PathParam("category") String category);

    @Query("FROM Category c ORDER BY c.category")
    List<Category> getOrderedByCategory();
}
