package com.example.demo;

import com.example.demo.service.FriendsService;
import com.example.demo.service.FriendshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
public class FriendsController {

    @Autowired
    private FriendsService friendsService;

    @Autowired
    private FriendshipsService friendshipsService;

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public Friends join(@RequestParam(value="name", required = false, defaultValue = "Unknown") String name) {
        Friends friend = new Friends();
        friend.setName(name);
        friendsService.joinFriends(friend);
        return friend;
    }

    @RequestMapping(value = "/getAllFriends", method = RequestMethod.GET)
    public List<Friends> getAllFriends() {
        return friendsService.getAllFriends();
    }

    @RequestMapping(value = "/getFriendById", method = RequestMethod.GET)
    public Friends getFriendsById(@RequestParam(value="id", required = false, defaultValue = "1") Long id) {
        return friendsService.getFriendById(id);
    }

    @RequestMapping(value = "/createFriendship", method = RequestMethod.GET)
    public Friendships createFriendship(@RequestParam(value="ids", required = false, defaultValue = "1,2") HashSet<Long> ids) {
        HashSet<Friends> friends = new HashSet<Friends>();
        for (Long id : ids){
            friends.add(friendsService.getFriendById(id));
        }
        Friendships friendships = new Friendships();
        friendships.setFriends(friends);
        friendshipsService.createFriendships(friendships);
        return friendships;
    }

    @RequestMapping(value = "/getAllFriendships", method = RequestMethod.GET)
    public List<Friendships> getAllFriendships() {
        return friendshipsService.getAllFriendships();
    }
}
