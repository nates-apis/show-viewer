package com.nate.nateapp.api;

import com.nate.nateapp.model.Program;
import com.nate.nateapp.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/programs")
public class ProgramController {

    private final InfoService infoService;

    @Autowired
    public ProgramController(InfoService infoService){
        this.infoService = infoService;
    }

    @PostMapping
    public void addProgram(@RequestBody Program program){
        infoService.addProgram(program);
    }

    @GetMapping(path = "{id}")
    public Program getProgramById(@PathVariable UUID id){
        return infoService.getProgramById(id).orElse(null);
    }

    @GetMapping
    public List<Program> getPrograms(){
        return infoService.getPrograms();
    }

}
