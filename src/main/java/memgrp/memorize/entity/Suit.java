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
public class Suit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suit_id")
    String suitId;
    @Column(name = "suit_description", length = 200)
    String suitDescription;


    @ManyToOne()
    @JoinColumn(name = "XXXXXX", nullable = false)
    Matrix matrix;

//    @OneToMany(orphanRemoval = true, mappedBy = "suit")
//    List<Card> cards;
//
//    public void addCard(Card card){
//        if(cards == null){
//            cards = new ArrayList<>();
//        }
//        cards.add(card);
//    }
}

