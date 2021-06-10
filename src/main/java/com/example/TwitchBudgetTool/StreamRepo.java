package com.example.TwitchBudgetTool;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StreamRepo extends JpaRepository<Streams, Long>{
}