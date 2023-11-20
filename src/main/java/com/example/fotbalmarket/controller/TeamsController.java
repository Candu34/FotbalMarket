package com.example.fotbalmarket.controller;


import com.example.fotbalmarket.models.Player;
import com.example.fotbalmarket.models.Team;
import com.example.fotbalmarket.service.PlayerService;
import com.example.fotbalmarket.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamsController {

    private final TeamService teamService;
    private final PlayerService playerService;


    @GetMapping()
    public String teams(@RequestParam(name = "title", required = false) String name,
                        Model model) {
        model.addAttribute("teams", teamService.findAll(name));

        return "/teams";
    }

    @GetMapping("/{id}")
    public String team(@PathVariable Long id, Model model) {
        Team team = teamService.findById(id);
        model.addAttribute("team", team);
        model.addAttribute("images", team.getImages());
        model.addAttribute("players", playerService.findPlayersByTeam(team));

        return "team";
    }


    @PostMapping("/create")
    public String createTeam(@RequestParam("files") List<MultipartFile> files, Team team) throws IOException {

        teamService.saveTeam(team, files);
        return "redirect:/teams";
    }
}
