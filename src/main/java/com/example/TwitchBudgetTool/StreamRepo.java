package com.example.TwitchBudgetTool;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StreamRepo extends JpaRepository<Streams, Long>{
    @Query("SELECT s FROM Streams s WHERE s.author_id = ?1")
    public List<Streams> findAllStreams(long ID);
}