package com.nate.nateapp.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void getName() {
        Program program = new Program("Star Trek", null, null);
        Assert.assertEquals("Star Trek", program.getName());
    }

    @Test
    void setName() {
        Program program = new Program("Star Trek", null, null);
        program.setName("Battlestar Galactica");
        Assert.assertEquals("Battlestar Galactica", program.getName());
    }

    @Test
    void getId() {
        UUID id = UUID.randomUUID();
        Program program = new Program("Star Trek", id, null);
        Assert.assertEquals(id, program.getId());
    }

    @Test
    void setId() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Program program = new Program("Star Trek", id1, null);

        program.setId(id2);
        Assert.assertEquals(id2, program.getId());


    }

    @Test
    void getCast() {
        Actor actor1 = new Actor("Christian", "Bale", null);
        Actor actor2 = new Actor("Anne", "Hathaway", null);
        List<Actor> castList = new ArrayList<>();
        Program program = new Program("Star Trek", null, castList);

        Assert.assertEquals(program.getCast(), castList);
    }

    @Test
    void setCast() {
        Actor actor1 = new Actor("Christian", "Bale", null);
        Actor actor2 = new Actor("Anne", "Hathaway", null);
        Actor actor3 = new Actor("Kurt", "Russell", null);
        Actor actor4 = new Actor("Chevy", "Chase", null);

        List<Actor> castList1 = new ArrayList<>();
        List<Actor> castList2 = new ArrayList<>();

        castList1.add(actor1);
        castList1.add(actor2);

        castList2.add(actor3);
        castList2.add(actor4);

        Program program = new Program("Star Trek", null, castList1);
        program.setCast(castList2);

        Assert.assertEquals(castList2, program.getCast());

    }
}