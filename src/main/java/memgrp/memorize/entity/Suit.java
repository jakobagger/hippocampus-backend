package memgrp.memorize.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Suit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suit_id")
    int suitId;
    @Column(name = "suit_description", length = 200)
    String suitDescription;

    @Column(name = "suit_name")
    String suitName;


    @ManyToOne()
    @JoinColumn(name = "matrix_id")
    Matrix matrix;

 @OneToMany(orphanRemoval = true, mappedBy = "suit")
   List<Card> cards;

   public void addCard(Card card){
    if(cards == null){
      cards = new ArrayList<>();
       }
    cards.add(card);
   }
}

