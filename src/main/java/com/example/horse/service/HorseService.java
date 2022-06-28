package com.example.horse.service;


import com.example.horse.repository.Entity.Horse;

import java.util.List;


public interface HorseService {

    Horse saveHorse(Horse horse);

    List<Horse> getAllHorse();

    Horse getHorseById(Integer id);

    void deleteHorseById(Integer id);

}
