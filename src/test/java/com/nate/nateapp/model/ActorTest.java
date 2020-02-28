package com.nate.nateapp.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class ActorTest {

    @Test
    void getFirstName() {
        Actor actor = new Actor("Christian", "Bale", null);
        Assert.assertEquals("Christian", actor.getFirstName());
    }

    @Test
    void setFirstName() {
        Actor actor = new Actor("Anne", "Hathaway", null);
        actor.setFirstName("Sally");
        Assert.assertEquals("Sally", actor.getFirstName());
    }

    @Test
    void getLastName() {
        Actor actor = new Actor("Christian", "Bale", null);
        Assert.assertEquals("Bale", actor.getLastName());
    }

    @Test
    void setLastName() {
        Actor actor = new Actor("Anne", "Hathaway", null);
        actor.setLastName("Jones");
        Assert.assertEquals("Jones", actor.getLastName());
    }

    @Test
    void getId() {
        UUID id = UUID.randomUUID();
        Actor actor = new Actor("Christian", "Bale", id);
        Assert.assertEquals(id, actor.getId());
    }

    @Test
    void setId() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Actor actor = new Actor("Christian", "Bale", id1);
        actor.setId(id2);

        Assert.assertEquals(id2, actor.getId());
    }
}