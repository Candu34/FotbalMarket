package com.example.fotbalmarket.controller;


import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.models.StaticImage;
import com.example.fotbalmarket.service.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;
    private final RatingService ratingService;
    private final ImageService imageService;
    private final StaticImageService staticImageService;

    @GetMapping()
    public String main(Model model){
        model.addAttribute("players", playerService.findAll());
        model.addAttribute("images", imageService.getPreviewImages());
        model.addAttribute("unknownImage", staticImageService.findById(1L));
        return "main";
    }

    @GetMapping("add")
    public String addPlayer(){

        return "players";
    }


    @GetMapping("/{id}")
    public String player(@PathVariable Long id, Model model) {
        Player player = playerService.findById(id);
        model.addAttribute("player", player);
        model.addAttribute("images", player.getImages());
        model.addAttribute("rating", ratingService.getRatingByPlayer(player));
        if(player.getCurrentTeam() != null){
            model.addAttribute("team", player.getCurrentTeam());
        }
        model.addAttribute("teams", teamService.findAll(null));
        return "/player";
    }

    @PostMapping("/create")
    public String addPlayer(@RequestParam("files") List<MultipartFile> files, Player player) throws IOException {

        playerService.savePlayer(player, files);
        return "redirect:/players";
    }

    @Transactional
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        ratingService.deleteByPlayerID(id);
        playerService.deleteById(id);
        return "redirect:/players";
    }

    @Transactional
    @PostMapping("/changeTeam/{playerId}")
    public String changeTeam(@RequestParam Map<String, String> formParams, @PathVariable Long playerId){
        Long teamId = Long.parseLong(formParams.get("teamId"));
        Player player = playerService.findById(playerId);
        player.setCurrentTeam(teamService.findById(teamId));

        return "redirect:/players/"+playerId;
    }


}
