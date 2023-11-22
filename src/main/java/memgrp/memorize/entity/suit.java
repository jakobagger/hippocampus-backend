package memgrp.memorize.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class suit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suit_id")
    String suitId;
    @Column(name = "suit_description", length = 200)
    String suitDescription;


//    @ManyToOne(orphanRemoval = true, mappedBy = Matrix)
//    List<Matrix> matrix;

//    One to One relation to Cards??
}
