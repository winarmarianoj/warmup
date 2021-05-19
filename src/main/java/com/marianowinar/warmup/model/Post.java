package com.marianowinar.warmup.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {

    public static final int MIN_TITLE_SIZE = 5;
    public static final int MAX_TITLE_SIZE = 50;
    public static final int MIN_CONTENT_SIZE = 5;
    public static final int MAX_CONTENT_SIZE = 200;

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
    private LocalDateTime date;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoryId")
    private Category category;

}
