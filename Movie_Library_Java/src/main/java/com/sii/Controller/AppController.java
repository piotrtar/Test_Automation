package com.sii.Controller;

import com.sii.Dao.Dao;
import com.sii.Models.Actor;
import com.sii.Models.Movie;
import com.sii.View.View;

import java.util.ArrayList;
import java.util.List;

public class AppController {

    private Dao dao;
    private View view;

    public AppController(Dao dao, View view) {
        this.dao = dao;
        this.view = view;
    }

    public void handleMenu() {

        String userChoice = "";

        while (!userChoice.equals("0")) {
            view.showMenu();
            try {
                userChoice = view.getChoice();
                switch (userChoice) {
                    case "1":
                        view.displayMovies(getMoviesByActor());
                        break;
                    case "2":
                        view.displayMovies(getMoviesByGenre());
                        break;
                    case "3":
                        view.displayMovies(getMoviesByTimeFrame());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Movie> getMoviesByActor() {
        List<Movie> moviesByActor = new ArrayList<>();
        String actorName = view.getActor();
        for (Movie movie : dao.getMovies()) {
            for (Actor actor : movie.getActors()) {
                if (actor.toString().toLowerCase().contains(actorName.toLowerCase())) {
                    moviesByActor.add(movie);
                }
            }
        }
        return moviesByActor;
    }

    public List<Movie> getMoviesByGenre() {
        List<Movie> moviesByGenre = new ArrayList<>();
        String movieGenre = view.getGenre();
        for (Movie movie : dao.getMovies()) {
            if (movie.genre != null) {
                if (movie.genre.toLowerCase().contains(movieGenre.toLowerCase())) {
                    moviesByGenre.add(movie);
                }
            }
        }
        return moviesByGenre;
    }

    public List<Movie> getMoviesByTimeFrame() {
        List<Movie> moviesByTimeFrame = new ArrayList<>();
        Integer fromYear = view.getFromYear();
        Integer toYear = view.getToYear();

        for (Movie movie : dao.getMovies()) {
            if (movie.year != null) {
                if (movie.year >= fromYear && movie.year <= toYear) {
                    moviesByTimeFrame.add(movie);
                }
            }
        }
        return moviesByTimeFrame;
    }
}
