package com.example.horse.Service.implement;

import com.example.horse.Repository.HorseRepository;
import com.example.horse.Entity.Horse;
import com.example.horse.Service.HorseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Horse> getAllHorse(int pageNumber) {
        Page<Horse> horses = repository.findAll(PageRequest.of(pageNumber - 1, 5));
        return horses;
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

    @Override
    public Page<Horse> findAllWithSort(String field, String direction, int pageNumber) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(field).ascending() : Sort.by(field).descending();

        Pageable pageable = PageRequest.of(pageNumber - 1, 5, sort);
        return repository.findAll(pageable);
    }

    @Override
    public List<Horse> findByKeyword(String keyword) {
        return repository.getByKeyword(keyword);
    }

    @Override
    public List<Horse> findAll() {
        return repository.findAll();
    }

}
