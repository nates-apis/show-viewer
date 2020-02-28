package com.nate.nateapp.api;

import com.nate.nateapp.model.Actor;
import com.nate.nateapp.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/actors")
public class ActorController {

    private final InfoService infoService;

    @Autowired
    public ActorController(InfoService infoService){
        this.infoService = infoService;
    }

    @PostMapping
    public void addActor(@RequestBody Actor actor){
        infoService.addActor(actor);
    }

    @GetMapping(path = "{id}")
    public Actor getActorById(@PathVariable("id") UUID id){
       return infoService.getActorById(id);
    }

    @GetMapping
    public List<Actor> getActors(){
        return infoService.getActors();
    }
}
