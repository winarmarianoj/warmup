package com.marianowinar.warmup.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "post")
public class Post {

    public static final int MIN_TITLE_SIZE = 3;
    public static final int MAX_TITLE_SIZE = 100;
    public static final int MIN_CONTENT_SIZE = 3;
    public static final int MAX_CONTENT_SIZE = 300;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false, length = MAX_TITLE_SIZE)
    private String title;

    @Column(nullable = false, length = MAX_CONTENT_SIZE)
    private String content;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private LocalDate date;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoryId")
    private Category category;

    public Post() {}

    public Post(String title, String content, String image, LocalDate date, User user, Category category) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.date = date;
        this.user = user;
        this.category = category;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
