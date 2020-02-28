package com.nate.nateapp.service;


import com.nate.nateapp.dao.ProgramDao;
import com.nate.nateapp.model.Actor;
import com.nate.nateapp.model.Program;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InfoServiceTest {

    @Mock
    ProgramDao programDao;

    @InjectMocks
    InfoService infoService = new InfoService();

    @Test
    void addActorTest() {
        Actor actor = new Actor("John", "Doe", null);
        infoService.addActor(actor);
        verify(programDao, times(1)).addActor(actor);
    }

    @Test
    void addProgramTest() {
        Program program = new Program("Breaking Bad", null, null);
        infoService.addProgram(program);
        verify(programDao, times(1)).addProgram(program);
    }

    @Test
    void overwriteCastTest() {
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

        infoService.overwriteCast(program.getId(), newCast);

        verify(programDao, times(1)).overwriteCast(program.getId(), newCast);
    }

    @Test
    void getActorsTest() {
        List<Actor> actorList = new ArrayList<>();
        Actor a1 = new Actor("Jim", "Beam", null);
        Actor a2 = new Actor("Bob", "Semple", null);
        Actor a3 = new Actor("Jerry", "Jones", null);

        actorList.add(a1);
        actorList.add(a2);
        actorList.add(a3);

        when(programDao.getActors()).thenReturn(actorList);

        Assert.assertEquals(3,infoService.getActors().size());
        verify(programDao, times(1)).getActors();
    }

    @Test
    void getProgramsTest() {
        List<Program> programList = new ArrayList<>();
        Program p1 = new Program("Game of Thrones", null, null);
        Program p2 = new Program("Chernobyl", null, null);
        Program p3 = new Program("Workin' Moms", null, null);

        programList.add(p1);
        programList.add(p2);
        programList.add(p3);

        when(programDao.getPrograms()).thenReturn(programList);

        List<Program> testList = infoService.getPrograms();

        Assert.assertEquals(3, testList.size());
        verify(programDao, times(1)).getPrograms();
    }

    @Test
    void getActorByIdTest() {
        Actor actor = new Actor("Leo", "DiCaprio", UUID.randomUUID());
        when(programDao.getActorById(actor.getId())).thenReturn(actor);

        Assert.assertEquals(infoService.getActorById(actor.getId()).getId(), actor.getId());
        verify(programDao, times(1)).getActorById(actor.getId());
    }

    @Test
    void getProgramByIdTest() {
        Program program = new Program("Bob's Burgers", UUID.randomUUID(), null);
        when(programDao.getProgramById(program.getId())).thenReturn(program);

        Assert.assertEquals(infoService.getProgramById(program.getId()).getId(), program.getId());
        verify(programDao, times(1)).getProgramById(program.getId());
    }
}