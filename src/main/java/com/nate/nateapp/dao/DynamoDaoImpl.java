package com.nate.nateapp.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class DynamoDaoImpl implements ProgramDao {

    @Autowired
    private AmazonDynamoDB client;


    @Override
    public List<Program> getPrograms() {
        return null;
    }

    @Override
    public List<Actor> getActors() {
        return null;
    }

    @Override
    public Program getProgramById(UUID id) {
        return null;
    }

    @Override
    public Actor getActorById(UUID id) {
        return null;
    }

    @Override
    public void addActor(Actor actor) {

    }

    @Override
    public void addProgram(Program program) {

    }

    @Override
    public boolean overwriteCast(UUID programId, List<Actor> actors) {
        return false;
    }
}
