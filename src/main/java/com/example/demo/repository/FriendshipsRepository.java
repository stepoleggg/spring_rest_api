package com.example.demo.repository;

import com.example.demo.Friendships;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipsRepository extends JpaRepository<Friendships, Long> {
}
