package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

@Entity
@Table(name = "friendships")
public class Friendships implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private HashSet<Friends> friends;

    public HashSet<Friends> getFriends(){
        return this.friends;
    }

    public void setFriends(HashSet<Friends> friends){
        this.friends = friends;
    }
}
