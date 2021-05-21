package com.marianowinar.warmup.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "posted")
public class Posted {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postedId;

    @Column(nullable = false)
    private LocalDate deleted;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "postId")
    private Post post;

    public Posted(){}

    public Posted(LocalDate deleted, Post post) {
        this.deleted = deleted;
        this.post = post;
    }

    public Long getPostedId() {
        return postedId;
    }

    public LocalDate getDeleted() {
        return deleted;
    }

    public void setDeleted(LocalDate deleted) {
        this.deleted = deleted;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
