package com.example.fotbalmarket.controller;


import com.example.fotbalmarket.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamsController {

    private final TeamService teamService;


    @GetMapping()
    public String teams(@RequestParam(name = "title", required = false) String name,
                        Model model){
     model.addAttribute("teams", teamService.findAll(name));

        return "/teams";
    }
}
