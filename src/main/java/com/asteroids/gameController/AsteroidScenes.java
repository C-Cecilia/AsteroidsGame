package com.asteroids.gameController;


import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AsteroidScenes {


    public static void createScene(Parent node, Stage stage) {
        Scene scene = new Scene(node);
        stage.setTitle("Asteroid Application!");
        stage.setScene(scene);
        stage.show();
    }


    public static void showMenu(Stage gameStage) {

        FlowPane fileMenu = new FlowPane();
        fileMenu.setPrefSize(AsteroidApplication.WIDTH,AsteroidApplication.HEIGHT);
        fileMenu.setOrientation(Orientation.VERTICAL);
        fileMenu.setCenterShape(true);
        fileMenu.setVgap(10);
        fileMenu.setAlignment(Pos.CENTER);
        fileMenu.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        //Creating menu Items
        Button gamePlayBtn = new Button("Play the Game");
        gamePlayBtn.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        gamePlayBtn.setStyle("-fx-text-fill: white;-fx-border-color: white;-fx-border-width: 1px;" +
                "fx-background-radius: 5px; -fx-border-radius: 5px;");
        Button leaderBoardBtn = new Button("Leader Board");
        leaderBoardBtn.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        leaderBoardBtn.setStyle("-fx-text-fill: white;-fx-border-color: white;-fx-border-width: 1px;" +
                "fx-background-radius: 5px; -fx-border-radius: 5px;");
        Button gameRulesBtn = new Button("Game Rules");
        gameRulesBtn.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        gameRulesBtn.setStyle("-fx-text-fill: white;-fx-border-color: white;-fx-border-width: 1px;" +
                "fx-background-radius: 5px; -fx-border-radius: 5px;");
        gamePlayBtn.setMaxWidth(200);
        leaderBoardBtn.setMaxWidth(200);
        gameRulesBtn.setMaxWidth(200);

        //Adding functions to call on click of buttons:
        gamePlayBtn.setOnAction(clicked -> {
            //return game window
            showGameScene(gameStage);
        });


        leaderBoardBtn.setOnAction(clicked -> {
            //return game window
            showLeaderBoardScene(gameStage);
        });


        gameRulesBtn.setOnAction(clicked -> {
            //show Rule window
            showGameRules(gameStage);
        });

        //Adding all the menu items to the menu
        fileMenu.getChildren().addAll(gamePlayBtn, leaderBoardBtn, gameRulesBtn);
        createScene(fileMenu, gameStage);
    }


    public static void getUserName(Stage stage){
        VBox vbox = new VBox();
        vbox.setSpacing(10); // Set spacing between elements

        // Create a text field
        vbox.setPrefSize(AsteroidApplication.WIDTH,AsteroidApplication.HEIGHT);
        vbox.setSpacing(10);
        vbox.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        HBox nameBox = new HBox(); // Create an HBox for the nameField
        nameBox.setAlignment(Pos.CENTER); // Set alignment to center
        nameBox.setMaxWidth(250);

        TextField nameField = new TextField();
        nameBox.getChildren().add(nameField);
        vbox.getChildren().add(nameBox); // Add text field to VBox



        // Create a scene with the VBox as the root element

        // Create a button
        Button playButton = new Button("Play the game!");
        Button addUserName = new Button("Add the username!");
        playButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        playButton.setStyle("-fx-text-fill: white;-fx-border-color: white;-fx-border-width: 1px;" +
                "fx-background-radius: 5px; -fx-border-radius: 5px;");
        addUserName.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        addUserName.setStyle("-fx-text-fill: white;-fx-border-color: white;-fx-border-width: 1px;" +
                "fx-background-radius: 5px; -fx-border-radius: 5px;");
        playButton.setMaxWidth(200);
        addUserName.setMaxWidth(200);

        playButton.setDisable(true);
        vbox.getChildren().add(addUserName);
        vbox.getChildren().add(playButton); // Add button to VBox
        vbox.setAlignment(Pos.CENTER);

        addUserName.setOnAction(clicked -> {
            String nameInput = nameField.getText();
            if(!nameInput.isEmpty()){
                playButton.setDisable(false);
                AsteroidApplication.userName = nameInput;
            }
        });
        playButton.setOnAction(clicked -> {
            GameLevels.levelOneGame(stage);
        });

        // Create a button to return to the main menu
        Button backButton = new Button("Return");
        backButton.setOnAction(event -> AsteroidScenes.showMenu(stage));
        backButton.setStyle("-fx-text-fill: white;-fx-border-color: white;-fx-border-width: 1px;" +
                "fx-background-radius: 5px; -fx-border-radius: 5px;");
        backButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        backButton.setMaxWidth(200);
        // Add the back button to the VBox
        vbox.getChildren().add(backButton);


        

        // Create a scene with the VBox as the root element
        Scene scene = new Scene(vbox, AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);

        // Set the scene on the primary stage
        stage.setScene(scene);
        stage.show();

    }

    public static void showGameScene(Stage stage) {
        getUserName(stage);
    }



    public static void showLeaderBoardScene(Stage stage) {
        try {
            File file = new File("highscores.txt");

            // Check if the file does not exist, and create it if necessary
            if (!file.exists()) {
                file.createNewFile();
            }

            // Create a new FileReader object to read from the file
            FileReader reader = new FileReader(file);
            // Create a new BufferedReader object to wrap the FileReader object
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            // Create a new VBox to hold the high scores
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);
            vbox.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

            // Create a new Label for the title and add it to the VBox
            Label titleLabel = new Label("High Scores");
            titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-underline: true;");
            titleLabel.setPrefHeight(50);
            titleLabel.setTextFill(Color.WHITE);
            vbox.getChildren().add(titleLabel);

            // Read each line from the file and add a Label to the VBox for each high score
            boolean hasScores = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");
                String formattedLine = String.join(" : ", tokens);
                Label label = new Label(formattedLine);
                label.setPrefHeight(25);
                label.setTextFill(Color.WHITE);
                vbox.getChildren().add(label);
                hasScores = true;
            }

            // Check if the VBox is still empty, which means the file is empty or doesn't contain any high scores
            if (!hasScores) {
                Label emptyLabel = new Label("No high scores yet.");
                emptyLabel.setTextFill(Color.WHITE);
                vbox.getChildren().add(emptyLabel);
            }

            Button returnButton = new Button("Return"); // Create return button
            returnButton.setOnAction(e -> showMenu(stage)); // Set button action
            returnButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
            returnButton.setStyle("-fx-text-fill: white;-fx-border-color: white;-fx-border-width: 1px;" +
                    "fx-background-radius: 5px; -fx-border-radius: 5px;");

            vbox.getChildren().add(returnButton);

            // Create a new Scene and set the root node to be the VBox containing the high scores
            Scene scene = new Scene(vbox, AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);

            stage.setScene(scene);
            stage.show();

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }


    public static void showGameRules(Stage stage) {
        Stage gameRuleStage = new Stage();
        gameRuleStage.setTitle("Game Rules");

        // Create VBox to hold rule content
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        vbox.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        String rolesText = "Player: \n"
                + "You manipulate a space shuttle in space.\n\n"
                + "Enemy:\n"
                + "There are two kinds of enemies:\n"
                + "(1) The moving meteorite that crash you.\n"
                + "(2) The flying alien spacecraft ttat can shoot you and crash you.\n"
                + "Each time the alien spacecraft appears in a bigger shape and will be broken into three small ones when shot by your bullets \n"
                + "The smaller alien spacecraft will explode when shot by your bullets.\n\n"
                +"Weapon:\n The space shuttle can shoot bullets to meteorites and enemies.\n";

        // Add game rule content as Text objects
        Text roleText = new Text(rolesText);
        roleText.setFill(Color.WHITE);
        vbox.getChildren().addAll(roleText);

        // Create a button to return to the main menu
        Button backButton = new Button("Return");
        backButton.setOnAction(event -> AsteroidScenes.showMenu(stage));
        backButton.setStyle("-fx-text-fill: white;-fx-border-color: white;-fx-border-width: 1px;" +
                "fx-background-radius: 5px; -fx-border-radius: 5px;");
        backButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        backButton.setMaxWidth(200);
        // Add the back button to the VBox
        vbox.getChildren().add(backButton);

        Scene scene = new Scene(vbox, AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }



    public static void gameOverScene(boolean sceneStop, Stage stage) {
        if (sceneStop && !AsteroidApplication.scoresSaved) {
            AsteroidApplication.scoreMap.put(AsteroidApplication.userName, AsteroidApplication.CurrentScore);

            try {
                // Read the existing scores from the file and store them in a list
                List<String> scores = Files.readAllLines(Paths.get("highscores.txt"));

                // Add the new score to the list
                scores.add(AsteroidApplication.userName + " " + AsteroidApplication.CurrentScore);

                // Sort the list in descending order by score
                scores.sort((s1, s2) -> {
                    int score1 = Integer.parseInt(s1.split(" ")[1]);
                    int score2 = Integer.parseInt(s2.split(" ")[1]);
                    return score2 - score1;
                });

                // Truncate the list to contain only the top 5 scores
                if (scores.size() > 3) {
                    scores = scores.subList(0, 3);
                }

                // Write the top 5 scores back to the file
                FileWriter writer = new FileWriter("highscores.txt");
                for (String score : scores) {
                    writer.write(score);
                    writer.write(System.lineSeparator());
                }
                writer.close();

                AsteroidApplication.scoresSaved = true;

            } catch (IOException e) {
                System.out.println("An error occurred while reading/writing the file: " + e.getMessage());
            }


        }
        createGameOverScene(stage);
    }


    public static void gameEndScene(boolean sceneStop, Stage stage) {
        if (sceneStop && !AsteroidApplication.scoresSaved) {
            AsteroidApplication.scoreMap.put(AsteroidApplication.userName, AsteroidApplication.CurrentScore);

            try {
                // Read the existing scores from the file and store them in a list
                List<String> scores = Files.readAllLines(Paths.get("highscores.txt"));

                // Add the new score to the list
                scores.add(AsteroidApplication.userName + " " + AsteroidApplication.CurrentScore);

                // Sort the list in descending order by score
                scores.sort((s1, s2) -> {
                    int score1 = Integer.parseInt(s1.split(" ")[1]);
                    int score2 = Integer.parseInt(s2.split(" ")[1]);
                    return score2 - score1;
                });

                // Truncate the list to contain only the top 5 scores
                if (scores.size() > 3) {
                    scores = scores.subList(0, 3);
                }

                // Write the top 5 scores back to the file
                FileWriter writer = new FileWriter("highscores.txt");
                for (String score : scores) {
                    writer.write(score);
                    writer.write(System.lineSeparator());
                }
                writer.close();

                AsteroidApplication.scoresSaved = true;

            } catch (IOException e) {
                System.out.println("An error occurred while reading/writing the file: " + e.getMessage());
            }


        }
        showMenu(stage);
    }

    public static void createGameOverScene(Stage stage){
        AsteroidApplication.scoreMap.put(AsteroidApplication.userName, AsteroidApplication.CurrentScore);
        Text gameOverText = new Text("Game Over !");
        gameOverText.setFill(Color.WHITE);
        gameOverText.setFont(Font.font("Arial", FontWeight.BOLD, 36)); // Set font and size
        Text playerScore = new Text(AsteroidApplication.userName + "'s Score: " + AsteroidApplication.CurrentScore);
        gameOverText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        playerScore.setFill(Color.WHITE);

        Button returnButton = new Button("Return"); // Create return button
        returnButton.setOnAction(e -> showMenu(stage)); // Set button action
        returnButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        returnButton.setStyle("-fx-text-fill: white;-fx-border-color: white;-fx-border-width: 1px;" +
                "fx-background-radius: 5px; -fx-border-radius: 5px;");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER); // Set alignment to center
        vbox.setSpacing(10); // Set spacing between elements
        vbox.setPrefSize(AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);
        vbox.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        vbox.getChildren().addAll(gameOverText, playerScore, returnButton);
        // Add Text objects and return button to VBox

        Pane gameOverPane = new Pane();
        gameOverPane.setPrefSize(AsteroidApplication.WIDTH,AsteroidApplication.HEIGHT);
        AsteroidApplication.CurrentScore = 0;
        gameOverPane.getChildren().add(vbox);

        Scene scene = new Scene(gameOverPane);
        stage.setScene(scene);
        stage.show();
    }

//    public static void addToHighScore(int currentScore){
//        if(AsteroidApplication.highScores)
//
//    }


    public static void nextLevelScene(boolean nextLevel, int level, Stage stage){
        if(nextLevel){
            switch(level){
                case 1:
                    GameLevels.levelTwoGame(stage);
                    break;
                case 2:
                    GameLevels.levelThreeGame(stage);
                    break;
                case 3:
                    GameLevels.levelFourgame(stage);
                    break;
                case 4:
                    gameEndScene(nextLevel,stage);
            }
        }
    }




}
