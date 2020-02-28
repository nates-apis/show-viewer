package com.nate.nateapp.api;

import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;
import com.nate.nateapp.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/programs")
public class ProgramController {

    private final InfoService infoService;

    @Autowired
    public ProgramController(InfoService infoService){
        this.infoService = infoService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable UUID id){
        Program targetProgram = infoService.getProgramById(id);

        if (targetProgram != null){
            return new ResponseEntity<>(targetProgram, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Program> getPrograms(){
        return infoService.getPrograms();
    }

    @PostMapping
    public void addProgram(@RequestBody Program program){
        infoService.addProgram(program);
    }

    @PatchMapping(path = "{programId}")
    public ResponseEntity<Program> overwriteCast(@PathVariable UUID programId, @RequestBody List<Actor> actors){
        if(infoService.overwriteCast(programId, actors)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
