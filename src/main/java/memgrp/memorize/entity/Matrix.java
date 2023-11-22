package memgrp.memorize.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Matrix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matrix_id")
    int matrixId;

}
