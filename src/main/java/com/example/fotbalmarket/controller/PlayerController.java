package com.example.fotbalmarket.controller;


import com.example.fotbalmarket.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;


    @GetMapping()
    public String products(@RequestParam(name = "title", required = false) String title, Model model){
        model.addAttribute("players", playerService.findAll());

        return "/products";
    }
}
