package com.marianowinar.warmup.repository;

import com.marianowinar.warmup.model.Category;
import com.marianowinar.warmup.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("FROM Post p WHERE p.title = :title")
    Post findByTitle(@PathParam("title") String title);

    @Query("FROM Post p ORDER BY p.date DESC")
    List<Post> getOrderedByDate();

    @Query("FROM Post p WHERE p.category = :category")
    List<Post> getOrderedByCategoryId(@PathParam("category") Category category);

    @Query("FROM Post p WHERE p.title = :title ORDER BY p.date")
    List<Post> getOrderedByTitle(@PathParam("title") String title);

    @Query("FROM Post p WHERE p.title = :title and p.category = :category ORDER BY p.title, p.category")
    List<Post> getOrderedByTitleCategoryId(@PathParam("title") String title, @PathParam("category") Category category);

}
