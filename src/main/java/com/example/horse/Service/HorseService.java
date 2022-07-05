package com.example.horse.Service;


import com.example.horse.Entity.Horse;
import org.springframework.data.domain.Page;

import java.util.List;


public interface HorseService {

    Horse saveHorse(Horse horse);

    Page<Horse> getAllHorse(int pageNumber);

    Horse getHorseById(Integer id);

    void deleteHorseById(Integer id);

    Page<Horse> findAllWithSort(String field, String direction, int pageNumber);

   List<Horse> findByKeyword(String keyword);

    List<Horse> findAll();

}
