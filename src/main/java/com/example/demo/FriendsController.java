package com.example.demo;

import com.example.demo.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class FriendsController {

    @Autowired
    private FriendsService friendsService;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public Friends join(@RequestParam(value="name", required = false, defaultValue = "Unknown") String name) {
        Friends friend = new Friends();
        friend.setName(name);
        friend.setId(counter.incrementAndGet());
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
}
