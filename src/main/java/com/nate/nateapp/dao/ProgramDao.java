package com.nate.nateapp.dao;


import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;

import java.util.List;
import java.util.UUID;

public interface ProgramDao {

    //mass GET methods
    List<Program> getPrograms();
    List<Actor> getActors();

    //individual GET methods
    Program getProgramById(UUID id);
    Actor getActorById(UUID id);

    //POSTs
    void addActor(Actor actor);
    void addProgram(Program program);

    //PATCHs
    boolean overwriteCast(UUID programId, List<Actor> actors);
}
