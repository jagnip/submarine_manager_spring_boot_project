package com.codecool.submarinemanager.crewman;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/crewmen")
public class CrewmanController {

    private CrewmanService crewmanService;

    public CrewmanController(CrewmanService crewmanService) {
        this.crewmanService = crewmanService;
    }

    @GetMapping(path = "")
    public Iterable<Crewman> showAll() {
        return this.crewmanService.findAllCrewmen();
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Crewman crewman) {
        this.crewmanService.save(crewman);
    }

    @PostMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Crewman crewman) {
        this.crewmanService.delete(crewman);
    }

    @GetMapping(path = "/{id}")
    public Crewman show(@PathVariable Integer id) {
        return this.crewmanService.findById(id);
    }
}