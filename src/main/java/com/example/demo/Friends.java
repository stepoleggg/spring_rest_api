package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friends")
public class Friends implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Long getId(){
        return this.id;
    }

    public String toString(){
        return this.name;
    }
}
