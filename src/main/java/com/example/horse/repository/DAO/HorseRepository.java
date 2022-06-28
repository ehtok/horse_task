package com.example.horse.repository.DAO;

import com.example.horse.repository.Entity.Horse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseRepository extends CrudRepository<Horse, Integer> {

}
