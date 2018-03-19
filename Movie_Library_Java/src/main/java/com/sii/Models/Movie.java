package com.sii.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    @JsonProperty("title")
    public String title;

    @JsonProperty("year")
    public Integer year;

    @JsonProperty("director")
    public String director;

    @JsonProperty("cast")
    public String cast;

    @JsonProperty("genre")
    public String genre;

    @JsonProperty("notes")
    public String notes;

    public List<Actor> actors = new ArrayList<Actor>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Title: " + this.title + "\n");
        sb.append("Year: " + this.year + "\n");
        sb.append("Director: " + this.director + "\n");
        sb.append("Genre: " + this.genre + "\n");
        sb.append("Actors: " + "\n");
        for (Actor actor : actors) {
            sb.append("- " + actor.toString() + "\n");
        }
        return sb.toString();
    }
}