package com.example.TwitchBudgetTool.Users;

import com.example.TwitchBudgetTool.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepo extends JpaRepository<Users, Long>{
    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    public Users findByEmail(String email);

    @Query("SELECT b FROM Users b Where b.id = ?1")
    public Users showBalance(Long id);
}
