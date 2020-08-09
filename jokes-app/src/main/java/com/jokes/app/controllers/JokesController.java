package com.jokes.app.controllers;

import com.jokes.app.services.Jokes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private Jokes jokesService;

    @Autowired
    public JokesController(Jokes jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {

        model.addAttribute("joke", jokesService.getRandomJoke());

        return "chucknorris";

    }
}
