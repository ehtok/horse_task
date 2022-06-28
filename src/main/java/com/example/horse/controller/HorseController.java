package com.example.horse.controller;

import com.example.horse.repository.Entity.Horse;
import com.example.horse.service.HorseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/horse")
public class HorseController {
    private final HorseService horseService;

    @GetMapping
    public String viewHomePage(Model model) {
        List<Horse> horseList = horseService.getAllHorse();
        model.addAttribute("horses", horseList);
        return "horse";
    }

    @GetMapping(value = "/new")
    public String showHorse(Model model) {
        Horse horse = new Horse();
        model.addAttribute("horse", horse);
        return "new_horse";
    }

    @PostMapping
    public String saveHorse(Horse horse) {
        horseService.saveHorse(horse);
        return "redirect:/horse";
    }

    @GetMapping("/delete/{id}")
    public String deleteHorse(@PathVariable(value = "id") Integer id) {
        horseService.deleteHorseById(id);
        return "redirect:/horse";
    }

    @GetMapping("/update/{id}")
    public String formUpdate(@PathVariable(value = "id") Integer id, Model model) {
        Horse horse = horseService.getHorseById(id);
        model.addAttribute("horse", horse);
        return "update_horse";
    }

}
