package com.example.horse.service.implement;

import com.example.horse.repository.DAO.HorseRepository;
import com.example.horse.repository.Entity.Horse;
import com.example.horse.service.HorseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HorseServiceImpl implements HorseService {

    private final HorseRepository repository;


    @Override
    public Horse saveHorse(Horse horse) {

        return repository.save(horse);
    }


    @Override
    public List<Horse> getAllHorse() {
        return (List<Horse>) repository.findAll();
    }

    @Override
    public Horse getHorseById(Integer id) {
        Optional<Horse> opt = repository.findById(id);
        return opt.isPresent() ? opt.get() : null;
    }

    @Override
    public void deleteHorseById(Integer id) {
        repository.deleteById(id);
    }

}
