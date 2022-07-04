package com.example.blondiebytes.tutorial.Repo;

import com.example.blondiebytes.tutorial.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User,Long> {
}
