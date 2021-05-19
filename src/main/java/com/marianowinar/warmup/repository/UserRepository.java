package com.marianowinar.warmup.repository;

import com.marianowinar.warmup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User u ORDER BY u.username")
    List<User> getOrderedByUsername();

    @Query("FROM User u WHERE u.username = :username")
    User findByUsername(@PathParam("username") String username);

}
