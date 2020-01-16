package ru.voskhod.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    // define constructors

    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    // define getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // define toString() method

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
