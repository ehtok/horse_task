package com.example.horse.Repository;

import com.example.horse.Entity.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorseRepository extends JpaRepository<Horse, Integer> {
    @Query("select horse from Horse horse where " +
            "concat(horse.name,horse.type,horse.age,horse.price) like %?1%")
    List<Horse> getByKeyword(String keyword);

}
