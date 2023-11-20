package com.example.fotbalmarket.controller;


import com.example.fotbalmarket.mapper.RatingMapper;
import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.service.PlayerService;
import com.example.fotbalmarket.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    private final RatingService ratingService;


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
        Player player = playerService.findById(id);
        model.addAttribute("player", player);
        model.addAttribute("images", player.getImages());
        model.addAttribute("rating", ratingService.getRatingByPlayer(player));
        return "/player";
    }

    @PostMapping("/create")
    public String addPlayer(@RequestParam("files") List<MultipartFile> files, Player player) throws IOException {

        playerService.saveProduct(player, files);
        return "redirect:/players";
    }
}
