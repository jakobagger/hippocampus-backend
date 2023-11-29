package memgrp.memorize.repository;

import memgrp.memorize.entity.Suit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuitRepository extends JpaRepository<Suit, Integer> {

}
