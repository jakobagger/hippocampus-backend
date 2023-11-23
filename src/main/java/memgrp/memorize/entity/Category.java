package memgrp.memorize.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    int categoryId;

    @Column(name = "category_description", length = 200)
    String categoryDescription;

    @Column(name = "category_number")
    int CategoryNumber;

    @ManyToOne()
    @JoinColumn(name = "matrix_id")
    Matrix matrix;

//    @OneToMany(orphanRemoval = true, mappedBy = "category")
//    List<Card> cards;
//
//    public void addCards(Card card){
//        if(cards == null){
//            cards = new ArrayList<>();
//        }
//        cards.add(card);
//    }


}
