package com.example.demo.service;

import com.example.demo.Friendships;
import com.example.demo.repository.FriendshipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipsService {
    @Autowired
    private final FriendshipsRepository friendshipsRepository;

    public FriendshipsService(FriendshipsRepository friendshipsRepository){
        this.friendshipsRepository = friendshipsRepository;
    }

    public void createFriendships(Friendships friendships){
        this.friendshipsRepository.save(friendships);
    }

    public List<Friendships> getAllFriendships(){
        return this.friendshipsRepository.findAll();
    }
}
