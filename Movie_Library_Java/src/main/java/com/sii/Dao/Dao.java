package com.sii.Dao;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sii.Models.Actor;
import com.sii.Models.Movie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Dao {

    List<Movie> movies;

    public Dao() {
        this.movies = null;
    }

    public void loadObjectsFromJsonFile() {

        String jsonData = readFileToString("src/main/resources/movies-filtered.json");

        movies = getMoviesFromJson(jsonData, movies);

        loadActors();
    }

    public void loadActors() {

        for (Movie movie: movies) {
            if(movie.getCast() != null){
                if (movie.getCast().contains(",")) {
                    String[] actors = movie.getCast().split(",");
                    for (String actorString : actors) {
                        Actor actor = parseToActor(actorString);
                        movie.getActors().add(actor);
                    }

                }else{
                    Actor actor1 = parseToActor(movie.getCast());
                    movie.getActors().add(actor1);
                }
            }
        }
    }


    public static String readFileToString(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static List<Movie> getMoviesFromJson(String jsonData, List<Movie> movies){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            movies = objectMapper.readValue(jsonData, new TypeReference<List<Movie>>() {});
        }catch(IOException e){
            e.printStackTrace();
        }
        return movies;
    }

    private static Actor parseToActor(String actorString){

        String name = null;
        String surname = null;

        try {
            String[] nameSurname = actorString.trim().split(" ");

            name = nameSurname[0];
            surname = nameSurname[1];
        }catch(IndexOutOfBoundsException e){
        }

        Actor actor = new Actor(name, surname);
        return actor;
    }

    public List<Movie> getMovies() {
        return this.movies;
    }
}