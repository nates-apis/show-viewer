package com.nate.nateapp.service;

import com.nate.nateapp.dao.ProgramDao;
import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InfoService {

    private final ProgramDao programDao;

    @Autowired
    public InfoService(@Qualifier("stubDao") ProgramDao programDao){
        this.programDao = programDao;
    }

    public boolean addActor(Actor actor){
        return this.programDao.addActor(actor);
    }

    public boolean addProgram(Program program){
        return this.programDao.addProgram(program);
    }

    public List<Actor> getActors(){
        return this.programDao.getActors();
    }

    public List<Program> getPrograms(){
        return this.programDao.getPrograms();
    }

    public Optional<Actor> getActorById(UUID id){
        return this.programDao.getActorById(id);
    }

    public Optional<Program> getProgramById(UUID id){
        return this.programDao.getProgramById(id);
    }
}
