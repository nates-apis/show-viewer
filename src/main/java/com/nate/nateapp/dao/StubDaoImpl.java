package com.nate.nateapp.dao;

import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("stubDao")
public class StubDaoImpl implements ProgramDao {

    private static List<Program> programList = new ArrayList<>();
    private static List<Actor> actorList = new ArrayList<>();

    @Override
    public Optional<Program> getProgramById(UUID id) {
        return programList.stream()
                .filter(program -> program.getId()
                        .equals(id)
                )
                .findFirst();
    }

    @Override
    public Optional<Actor> getActorById(UUID id) {
        return actorList.stream()
                .filter(actor -> actor.getId()
                        .equals(id)
                ).findFirst();
    }

    @Override
    public boolean addActor(Actor actor) {
        actor.setId(UUID.randomUUID());
        return actorList.add(actor);
    }

    @Override
    public boolean addProgram(Program program) {
        program.setId(UUID.randomUUID());
        return programList.add(program);
    }

    @Override
    public List<Program> getPrograms() {
        return programList;
    }

    @Override
    public List<Actor> getActors() {
        return actorList;
    }




}
