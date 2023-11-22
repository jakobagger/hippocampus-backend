package memgrp.memorize.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suitId")
    String suitId;
    @Column(name = "suitDescription", length = 200)
    String suitDescription;

//Lav en one to many relation til matrix
//    @ManyToOne(orphanRemoval = true, mappedBy = Matrix)
//    List<Matrix> matrix;


}
