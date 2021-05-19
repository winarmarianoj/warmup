package com.marianowinar.warmup.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "credentials")
public class User {

    public static final int MIN_USERNAME_SIZE = 5;
    public static final int MAX_USERNAME_SIZE = 50;
    public static final int MIN_PASSWORD_SIZE = 8;
    public static final int MAX_PASSWORD_SIZE = 64;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = MAX_USERNAME_SIZE)
    private String username;

    @Column(nullable = false, length = MAX_PASSWORD_SIZE)
    private String password;

    @Column
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="users_roles",
            joinColumns=@JoinColumn(name="usuario_id"),
            inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_posts", 	joinColumns = { @JoinColumn(name = "userId", nullable = false, updatable = false) },	inverseJoinColumns = { @JoinColumn(name = "postId", nullable = false, updatable = false) })
    private List<Post> posts;

    public User(){}

    public User(String username, String password, boolean enabled, Set<Role> roles, List<Post> posts) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
