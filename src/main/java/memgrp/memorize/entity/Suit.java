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
    private int suitId;
    @Column(name = "suit_description", length = 200)
    private String suitDescription;
    @Column(name = "suit_name")
    private String suitName;

    @ManyToOne
    @JoinColumn(name = "matrix_id")
    Matrix matrix;

    @OneToMany(orphanRemoval = true, mappedBy = "suit")
    List<Card> cards;

    public Suit(String suitName){
        this.suitName = suitName;
    }

    public Suit(String suitName, String suitDescription) {
        this.suitName = suitName;
        this.suitDescription = suitDescription;
    }

    public void addCard(Card card){
    if(cards == null){
        cards = new ArrayList<>();
        }
    cards.add(card);
   }

}
