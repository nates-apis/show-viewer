package com.nate.nateapp.service;

import com.nate.nateapp.dao.ProgramDao;
import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InfoService {

    @Autowired
    private ProgramDao programDao;

    public void addActor(Actor actor){
        programDao.addActor(actor);
    }

    public void addProgram(Program program){
        programDao.addProgram(program);
    }

    public boolean overwriteCast(UUID programId, List<Actor> actors){
        return programDao.overwriteCast(programId, actors);
    }

    public List<Actor> getActors(){
        return programDao.getActors();
    }

    public List<Program> getPrograms(){
        return programDao.getPrograms();
    }

    public Actor getActorById(UUID id){
        return programDao.getActorById(id);
    }

    public Program getProgramById(UUID id){
        return programDao.getProgramById(id);
    }

}
