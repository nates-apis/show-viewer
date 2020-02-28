package com.nate.nateapp.dao;

import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class StubDaoImpl implements ProgramDao {

    private static List<Program> programList = new ArrayList<>();
    private static List<Actor> actorList = new ArrayList<>();

    @Override
    public Program getProgramById(UUID id) {
        return programList.stream()
                .filter(program -> program.getId()
                        .equals(id)
                )
                .findFirst()
                .orElse(null);
    }

    @Override
    public Actor getActorById(UUID id) {
        return actorList.stream()
                .filter(actor -> actor.getId()
                        .equals(id)
                ).findFirst()
                .orElse(null);
    }

    @Override
    public void addActor(Actor actor) {
        actor.setId(UUID.randomUUID());
        actorList.add(actor);
    }

    @Override
    public void addProgram(Program program) {
        program.setId(UUID.randomUUID());
        programList.add(program);
    }

    @Override
    public List<Program> getPrograms() {
        return programList;
    }

    @Override
    public List<Actor> getActors() {
        return actorList;
    }

    @Override
    public boolean overwriteCast(UUID programId, List<Actor> actors) {
        Program targetProgram = programList.stream()
                .filter(programInStream -> programInStream.getId()
                        .equals(programId)
                )
                .findFirst()
                .orElse(null);
        if(targetProgram != null) {
            targetProgram.setCast(actors);
            return true;
        } else {
            return false;
        }
    }

    static void deleteAllInfo(){
        programList.clear();
        actorList.clear();
    }
}
