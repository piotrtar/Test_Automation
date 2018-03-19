package com.sii;

import com.sii.Controller.AppController;
import com.sii.Dao.Dao;
import com.sii.View.View;

public class App {

    public static void main(String[] args) {

        Dao dao = new Dao();
        View view = new View();
        AppController appController = new AppController(dao, view);

        dao.loadObjectsFromJsonFile();
        appController.handleMenu();
    }
}