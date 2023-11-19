package com.example.fotbalmarket.controller;


import com.example.fotbalmarket.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;


    @GetMapping()
    public String players(@RequestParam(name = "country", required = false) String country, Model model) {

        if (country != null) {
            model.addAttribute("players", playerService.getPlayersByCountry(country));
        } else {
            model.addAttribute("players", playerService.findAll());
        }
        return "/players";
    }

    @GetMapping("/{id}")
    public String player(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.findById(id));

        return "/player";
    }
}
