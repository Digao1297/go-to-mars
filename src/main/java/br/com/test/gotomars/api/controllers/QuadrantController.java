package br.com.test.gotomars.api.controllers;

import br.com.test.gotomars.api.services.QuadrantService;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/quadrants")
public class QuadrantController {

    private final QuadrantService quadrantService;

    @Autowired
    public QuadrantController(QuadrantService quadrantService) {
        this.quadrantService = quadrantService;
    }

    @GetMapping
    public QuadrantEntity[][] findAll() {
        return quadrantService.findAll();
    }
}
