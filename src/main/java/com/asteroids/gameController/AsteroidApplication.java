package com.asteroids.gameController;

import com.asteroids.gameObjects.GameObject;
import javafx.application.Application;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.util.*;


public class AsteroidApplication extends Application {


    public static final int WIDTH = 900;
    public static final int HEIGHT = 400;
    public static String userName = "Unnamed";
    public static Map<String, Integer> scoreMap = new HashMap<String, Integer>();


    public static int CurrentScore = 0;
    public static boolean scoresSaved;


    @Override
    public void start(Stage stage) throws IOException {
        startAsteroidsApp(stage);
    }
 

    public static void startAsteroidsApp(Stage stage) {
        AsteroidScenes.showMenu(stage);
    }


    public static void main(String[] args) {
        launch();
    }
}