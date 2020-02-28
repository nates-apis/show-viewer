package com.nate.nateapp.dao;

import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class StubDaoImplTest {

    @Autowired
    private StubDaoImpl stubDao = new StubDaoImpl();

    @BeforeEach
    void init(){
        StubDaoImpl.deleteAllInfo();
    }

    @Test
    void getProgramById() {
        Program program = new Program("Curb Your Enthusiasm", null, null);
        stubDao.addProgram(program);
        Assert.assertEquals(stubDao.getProgramById(program.getId()),program);
        Assert.assertNotNull(program.getId());
    }

    @Test
    void getActorById() {
        Actor actor = new Actor("Will", "Ferrell", null);
        stubDao.addActor(actor);
        Assert.assertEquals(stubDao.getActorById(actor.getId()),actor);
        Assert.assertNotNull(actor.getId());
    }

    @Test
    void addActor() {
        Actor actor = new Actor("Will", "Ferrell", null);
        stubDao.addActor(actor);
        Assert.assertEquals(stubDao.getActorById(actor.getId()),actor);
        Assert.assertNotNull(actor.getId());
    }

    @Test
    void addProgram() {
        Program program = new Program("Curb Your Enthusiasm", null, null);
        stubDao.addProgram(program);
        Assert.assertEquals(stubDao.getProgramById(program.getId()),program);
        Assert.assertNotNull(program.getId());
    }

    @Test
    void getPrograms() {
        Program program1 = new Program("Curb Your Enthusiasm", UUID.randomUUID(), null);
        Program program2 = new Program("Saturday Night Live", UUID.randomUUID(), null);

        stubDao.addProgram(program1);
        stubDao.addProgram(program2);
        Assert.assertEquals(2, stubDao.getPrograms().size());
    }

    @Test
    void getActors() {
        Actor actor1 = new Actor("Peter", "Dinklage", UUID.randomUUID());
        Actor actor2 = new Actor("Kit", "Harrington", UUID.randomUUID());

        stubDao.addActor(actor1);
        stubDao.addActor(actor2);
        Assert.assertEquals(2, stubDao.getActors().size());
    }

    @Test
    void overwriteCastHappyPath() {
        List<Actor> oldCast = new ArrayList<>();
        List<Actor> newCast = new ArrayList<>();

        Actor old1 = new Actor("Jim", "Beam", UUID.randomUUID());
        Actor old2 = new Actor("Bob", "Semple", UUID.randomUUID());
        Actor old3 = new Actor("Jerry", "Jones", UUID.randomUUID());

        Actor new1 = new Actor("Adam", "Dunn", UUID.randomUUID());

        oldCast.add(old1);
        oldCast.add(old2);
        oldCast.add(old3);

        newCast.add(new1);

        Program program = new Program("Game of Thrones", UUID.randomUUID(), oldCast);

        stubDao.addProgram(program);
        boolean overwritten = stubDao.overwriteCast(program.getId(), newCast);

        Assert.assertTrue(overwritten);
        Assert.assertEquals(1,program.getCast().size());
    }

    @Test
    void overwriteCastUnhappyPath() {
        List<Actor> oldCast = new ArrayList<>();
        List<Actor> newCast = new ArrayList<>();

        Actor old1 = new Actor("Jim", "Beam", UUID.randomUUID());
        Actor old2 = new Actor("Bob", "Semple", UUID.randomUUID());
        Actor old3 = new Actor("Jerry", "Jones", UUID.randomUUID());

        Actor new1 = new Actor("Adam", "Dunn", UUID.randomUUID());

        oldCast.add(old1);
        oldCast.add(old2);
        oldCast.add(old3);

        newCast.add(new1);

        Program program = new Program("Game of Thrones", UUID.randomUUID(), oldCast);

        stubDao.addProgram(program);
        boolean overwritten = stubDao.overwriteCast(UUID.randomUUID(), newCast);

        Assert.assertFalse(overwritten);
        Assert.assertEquals(3,program.getCast().size());
    }

}