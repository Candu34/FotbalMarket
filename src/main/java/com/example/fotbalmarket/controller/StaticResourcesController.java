package com.example.fotbalmarket.controller;


import com.example.fotbalmarket.service.StaticImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/static")
public class StaticResourcesController {

    private final StaticImageService staticImageService;

    @GetMapping()
    public String StaticResourcesPage(){

        return "static";
    }

    @PostMapping("/loadImage")
    public String loadImage(@RequestParam("file") MultipartFile file) throws IOException {
        staticImageService.save(file);

        return "redirect:/static";
    }
}
