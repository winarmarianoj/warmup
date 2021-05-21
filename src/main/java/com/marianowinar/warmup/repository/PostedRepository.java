package com.marianowinar.warmup.repository;

import com.marianowinar.warmup.model.Posted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostedRepository extends JpaRepository<Posted, Long> {

    @Query("FROM Posted p ORDER BY p.deleted")
    List<Posted> getOrderedByDate();
}
