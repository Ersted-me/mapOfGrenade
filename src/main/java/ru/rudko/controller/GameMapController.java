package ru.rudko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rudko.service.GameMapService;

@Controller
@RequestMapping("/gamemap")
public class GameMapController {
    private final GameMapService gameMapService;

    @Autowired
    public GameMapController(GameMapService gameMapService) {
        this.gameMapService = gameMapService;
    }

    @GetMapping()
    public String gameMapList(Model model){
        model.addAttribute("maps", gameMapService.getAll());
        return "gamemap/all";
    }

    @GetMapping("/{id}")
    public String gameMapById(@PathVariable("id") int id, Model model){
        model.addAttribute("map",gameMapService.getById(id));
        return "gamemap/id";
    }
}
