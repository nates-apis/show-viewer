package com.nate.nateapp.dao;


import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProgramDao {

    //mass GET methods
    public List<Program> getPrograms();
    public List<Actor> getActors();

    //individual GET methods
    public Optional<Program> getProgramById(UUID id);
    public Optional<Actor> getActorById(UUID id);

    //POSTs
    public boolean addActor(Actor actor);
    public boolean addProgram(Program program);

}
