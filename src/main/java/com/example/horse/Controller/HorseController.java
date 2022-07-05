package com.example.horse.Controller;

import com.example.horse.Entity.Horse;
import com.example.horse.Enum.TypeEnum;
import com.example.horse.Service.HorseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HorseController {
    private final HorseService horseService;


//    @PostMapping("/horse")
//    public String getAllHorses(Model model, String keyword) {
//        List<Horse> horses = keyword == null ? horseService.findAll() : horseService.findByKeyword(keyword);
//        model.addAttribute("horses", horses);
//        return "/horse";
//    }

    @GetMapping("/horse")
    public String getAllPages(Model model) {
        return getOnePage(model, 1);
    }

    @GetMapping("/horse/page/{pageNumber}/{field}")
    public String getAllWithSort(Model model,
                                 @PathVariable("pageNumber") int currentPage,
                                 @PathVariable("field") String field,
                                 @PathParam("sortDir") String sortDir) {
        Page<Horse> page = horseService.findAllWithSort(field, sortDir, currentPage);
        List<Horse> horses = page.getContent();
        int totalPages = page.getTotalPages();
        long totalHorses = page.getTotalElements();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage", totalPages);
        model.addAttribute("totalHorses", totalHorses);

        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("ASC") ? "DESC" : "ASC");
        model.addAttribute("horses", horses);
        return "/horse";
    }

    @GetMapping("/horse/page/{pageNumber}")
    public String getOnePage(Model model,
                             @PathVariable("pageNumber") int currentPage) {
        Page<Horse> page = horseService.getAllHorse(currentPage);
        int totalPages = page.getTotalPages();
        long totalHorses = page.getTotalElements();
        List<Horse> horses = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage", totalPages);
        model.addAttribute("totalHorses", totalHorses);
        model.addAttribute("horses", horses);
        return "horse";
    }

    @GetMapping(value = "/horse/new")
    public String showHorse(Model model) {
        Horse horse = new Horse();
        model.addAttribute("horse", horse);
        model.addAttribute("types", TypeEnum.values());
        return "new_horse";
    }

    @PostMapping("/horse")
    public String saveHorse(Horse horse) {
        horseService.saveHorse(horse);
        return "redirect:/horse";
    }

    @GetMapping("/horse/delete/{id}")
    public String deleteHorse(@PathVariable(value = "id") Integer id) {
        horseService.deleteHorseById(id);
        return "redirect:/horse";
    }

    @GetMapping("/horse/search")
    public String search(Model model) {
        model.addAttribute("horse", new Horse());
        return "/search";
    }

    @RequestMapping(value = "/horse/search", method = RequestMethod.POST)
    public String searchHorse(@RequestParam("keyword")String keyword, Model model) {
        List<Horse> horses = horseService.findByKeyword(keyword);
        model.addAttribute("horses", horses);
        return "search";
    }

    @GetMapping("/horse/update/{id}")
    public String formUpdate(@PathVariable(value = "id") Integer id, Model model) {
        Horse horse = horseService.getHorseById(id);
        model.addAttribute("horse", horse);
        model.addAttribute("types", TypeEnum.values());
        return "update_horse";
    }

}
