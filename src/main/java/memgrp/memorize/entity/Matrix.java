package memgrp.memorize.entity;

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
public class Matrix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matrix_id")
    int matrixId;


    @ManyToOne
    @JoinColumn(name = "XXXXXX")
    Member member;

    @OneToMany(orphanRemoval = true, mappedBy = "matrix")
    List<Category> categories;

    public void addCategories(Category category){
        if(categories == null){
            categories = new ArrayList<>();
        }
        categories.add(category);
    }

    @OneToMany(orphanRemoval = true, mappedBy = "matrix")
    List<Suit> suits;

    public void addSuits(Suit suit){
        if(suits == null){
            suits = new ArrayList<>();
        }
        suits.add(suit);
    }

//    @OneToMany(orphanRemoval = true, mappedBy = "matrix")
//    List<Card> cards;
//
//    public void addCard(Card card){
//        if(cards == null){
//            cards = new ArrayList<>();
//        }
//        cards.add(card);
//    }

}
