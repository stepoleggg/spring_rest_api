package com.example.demo.service;

import com.example.demo.Friends;
import com.example.demo.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsService {
    @Autowired
    private final FriendsRepository friendsRepository;

    public FriendsService(FriendsRepository friendsRepository){
        this.friendsRepository = friendsRepository;
    }

    public void joinFriends(Friends friends){
        friendsRepository.save(friends);
    }

    public List<Friends> getAllFriends(){
        return friendsRepository.findAll();
    }

    public Friends getFriendById(Long id){
        return friendsRepository.findById(id).orElse(null);
    }
}
