package memgrp.memorize.repository;

import memgrp.memorize.entity.Matrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatrixRepository extends JpaRepository<Matrix, Integer> {

}
