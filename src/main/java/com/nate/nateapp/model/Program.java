package com.nate.nateapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Program {

    private String name;
    private UUID id;

    public Program(@JsonProperty("name") String name,
                   @JsonProperty("id") UUID id,
                   @JsonProperty("cast") List<Actor> cast) {
        this.name = name;
        this.id = id;
        this.cast = cast;
    }

    private List<Actor> cast;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

}
