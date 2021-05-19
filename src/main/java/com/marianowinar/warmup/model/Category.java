package com.marianowinar.warmup.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    public static final int MIN_CATEGORY_SIZE = 5;
    public static final int MAX_CATEGORY_SIZE = 25;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false, length = MAX_CATEGORY_SIZE)
    private String category;

    public Category(){}

    public Category(String category) {
        this.category = category;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
