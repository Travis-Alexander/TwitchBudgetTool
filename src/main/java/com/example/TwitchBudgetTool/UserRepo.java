package com.example.TwitchBudgetTool;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<Users, Long>{
}
