package com.sii.View;

import com.sii.Models.Movie;

import java.util.List;
import java.util.Scanner;

public class View {

    public View() {
    }

    public void showMenu() {

        String menu = "Welcome in Movie Library!\n" +
                "Choose option:\n" +
                " 1) Find films by actor.\n" +
                " 2) Find films by genre.\n" +
                " 3) Find films between given years.\n" +
                " 0) Exit.\n";

        System.out.println(menu);
    }


    public String getChoice() {
        return getInput();
    }

    public String getActor() {
        return getInput();
    }

    public String getGenre() {
        return getInput();
    }

    public String getInput() {
        Scanner inp = new Scanner(System.in);
        String choice = inp.next();
        return choice;
    }

    public Integer getFromYear() {
        return getYear();
    }

    public Integer getToYear() {
        return getYear();
    }

    public Integer getYear() {
        Scanner inp = new Scanner(System.in);
        Integer choice = inp.nextInt();
        return choice;
    }

    public void displayMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println("-------------------");
            System.out.println(movie);
            System.out.println("-------------------");
        }
    }
}