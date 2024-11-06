package com.asteroids.gameController;


import com.asteroids.gameObjects.*;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GameLevels {

    public static Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
    public static Player player;
    public static Point2D playerMovement = new Point2D(0, 0);



    public static int getLevelThreshold(int level){
        int levelUpScore = 0;
        switch(level){
            case 1:
                levelUpScore = 10;
                break;
            case 2:
                levelUpScore = 50;
                break;
            case 3:
                levelUpScore = 150;
                break;
            case 4:
                levelUpScore = 200;
                break;
        }
        return levelUpScore;
    }



    public static void levelOneGame(Stage stage) {
        int level = 1;
        BorderPane gamePane = new BorderPane();
        gamePane.setPrefSize(AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);
        gamePane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        List<GameObject> gameObjects = new ArrayList<>();
        List<Bullet> playerBulletBarell = new ArrayList<>();



        //create player

        Player singlePlayerInstance = Player.getInstance();
        player = singlePlayerInstance;
        //creates and enemy ship, rotates and accelerates it and returns the object to be added to the gamePane.
        LargeAsteroid.setSpeed(2);
        LargeAsteroid lg1 = new LargeAsteroid();
        LargeAsteroid lg2 = new LargeAsteroid();


        accelerateGameObject(lg1);
        accelerateGameObject(lg2);

        gamePane.getChildren().add(player.getGamePolygon());
        gamePane.getChildren().add(lg1.getGamePolygon());
        gamePane.getChildren().add(lg2.getGamePolygon());


        gameObjects.add(lg1);
        gameObjects.add(lg2);
        createGameScene(player, gamePane, gameObjects,playerBulletBarell, stage, level);

    }


    public static void levelTwoGame(Stage stage) {
        int level = 2;
        BorderPane gamePane = new BorderPane();
        gamePane.setPrefSize(AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);
        gamePane.setPrefSize(AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);
        gamePane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        List<GameObject> gameObjects = new ArrayList<>();
        List<Bullet> playerBulletBarell = new ArrayList<>();


        //create player

        Player singlePlayerInstance = Player.getInstance();
        player = singlePlayerInstance;
        //creates and enemy ship, rotates and accelerates it and returns the object to be added to the gamePane.
        LargeAsteroid.setSpeed(2);
        LargeAsteroid lg1 = new LargeAsteroid();
        LargeAsteroid lg2 = new LargeAsteroid();
        LargeAsteroid lg3 = new LargeAsteroid();


        accelerateGameObject(lg1);
        accelerateGameObject(lg2);
        accelerateGameObject(lg3);

        gamePane.getChildren().add(player.getGamePolygon());
        gamePane.getChildren().add(lg1.getGamePolygon());
        gamePane.getChildren().add(lg2.getGamePolygon());
        gamePane.getChildren().add(lg3.getGamePolygon());


        gameObjects.add(lg1);
        gameObjects.add(lg2);
        gameObjects.add(lg3);
        createGameScene(player, gamePane, gameObjects,playerBulletBarell, stage, level);
    }


    public static void levelThreeGame(Stage stage) {
        int level = 3;
        BorderPane gamePane = new BorderPane();
        gamePane.setPrefSize(AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);
        gamePane.setPrefSize(AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);
        gamePane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        List<GameObject> gameObjects = new ArrayList<>();
        List<Bullet> playerBulletBarell = new ArrayList<>();


        //create player

        Player singlePlayerInstance = Player.getInstance();
        player = singlePlayerInstance;
        //creates and enemy ship, rotates and accelerates it and returns the object to be added to the gamePane.
        LargeAsteroid.setSpeed(2);
        LargeAsteroid lg1 = new LargeAsteroid();
        LargeAsteroid lg2 = new LargeAsteroid();
        LargeAsteroid lg3 = new LargeAsteroid();
        LargeAsteroid lg4 = new LargeAsteroid();


        accelerateGameObject(lg1);
        accelerateGameObject(lg2);
        accelerateGameObject(lg3);
        accelerateGameObject(lg4);

        gamePane.getChildren().add(player.getGamePolygon());
        gamePane.getChildren().add(lg1.getGamePolygon());
        gamePane.getChildren().add(lg2.getGamePolygon());
        gamePane.getChildren().add(lg3.getGamePolygon());
        gamePane.getChildren().add(lg4.getGamePolygon());


        gameObjects.add(lg1);
        gameObjects.add(lg2);
        gameObjects.add(lg3);
        gameObjects.add(lg4);

        createGameScene(player, gamePane, gameObjects,playerBulletBarell, stage, level);

    }


    public static void levelFourgame(Stage stage) {
        int level = 4;
        BorderPane gamePane = new BorderPane();
        gamePane.setPrefSize(AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);
        gamePane.setPrefSize(AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);
        gamePane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        List<GameObject> gameObjects = new ArrayList<>();
        List<Bullet> playerBulletBarell = new ArrayList<>();


        //create player

        Player singlePlayerInstance = Player.getInstance();
        player = singlePlayerInstance;
        //creates and enemy ship, rotates and accelerates it and returns the object to be added to the gamePane.
        LargeAsteroid.setSpeed(2);
        LargeAsteroid lg1 = new LargeAsteroid();
        LargeAsteroid lg2 = new LargeAsteroid();
        LargeAsteroid lg3 = new LargeAsteroid();
        LargeAsteroid lg4 = new LargeAsteroid();


        accelerateGameObject(lg1);
        accelerateGameObject(lg2);
        accelerateGameObject(lg3);
        accelerateGameObject(lg4);

        gamePane.getChildren().add(player.getGamePolygon());
        gamePane.getChildren().add(lg1.getGamePolygon());
        gamePane.getChildren().add(lg2.getGamePolygon());
        gamePane.getChildren().add(lg3.getGamePolygon());
        gamePane.getChildren().add(lg4.getGamePolygon());


        gameObjects.add(lg1);
        gameObjects.add(lg2);
        gameObjects.add(lg3);
        gameObjects.add(lg4);

        createGameScene(player, gamePane, gameObjects,playerBulletBarell, stage, level);

    }



    public static void accelerateGameObject(GameObject anyGameObj){
        Random random = new Random();
        int choose = random.nextInt(2);
        if(choose == 0){
            anyGameObj.turnRight();
        }
        else{
            anyGameObj.turnLeft();
        }
        anyGameObj.accelerate();
    }


    public static GameObject[] largeAsteroidHit(Pane gamePane, LargeAsteroid largeAsteroid){
        Point2D largeAsteroidPoint = largeAsteroid.getObjectPosition();
        double posx = (double) largeAsteroidPoint.getX() + 50;
        double posy = (double) largeAsteroidPoint.getY() + 50;
        Random rnd = new Random();
        MediumAsteroid.setSpeed(LargeAsteroid.getSpeed()+rnd.nextDouble(0.01,0.05));
        MediumAsteroid mediumAsteroid1 = new MediumAsteroid(posx, posy);
        MediumAsteroid mediumAsteroid2 = new MediumAsteroid(posx - 50, posy  - 50);
        mediumAsteroid1.rotate();
        mediumAsteroid2.rotate();
        mediumAsteroid1.accelerateAsteroid();
        mediumAsteroid2.accelerateAsteroid();
        gamePane.getChildren().add(mediumAsteroid1.getGamePolygon());
        gamePane.getChildren().add(mediumAsteroid2.getGamePolygon());
        MediumAsteroid[] mediumAsteroids = new MediumAsteroid[2];
        mediumAsteroids[0] = mediumAsteroid1;
        mediumAsteroids[1] = mediumAsteroid2;
        return mediumAsteroids;
    }

    public static GameObject[] mediumAsteroidHit(Pane gamePane, MediumAsteroid mediumAsteroid){
        Point2D mediumAstreoidPoint = mediumAsteroid.getObjectPosition();
        double posx = (double) mediumAstreoidPoint.getX() + 20;
        double posy = (double) mediumAstreoidPoint.getY() + 20;
        Random rnd = new Random();
        SmallAsteroid.setSpeed(MediumAsteroid.getSpeed()+rnd.nextDouble(0.01,0.05));
        SmallAsteroid smallAsteroid1 = new SmallAsteroid(posx, posy);
        SmallAsteroid smallAsteroid2 = new SmallAsteroid(posx - 20, posy  - 20);
        SmallAsteroid smallAsteroid3 = new SmallAsteroid(posx + 50, posy+50);
        SmallAsteroid smallAsteroid4 = new SmallAsteroid(posx - 100, posy  - 100);
        smallAsteroid1.rotate();
        smallAsteroid2.rotate();
        smallAsteroid3.rotate();
        smallAsteroid4.rotate();
        smallAsteroid1.accelerateAsteroid();
        smallAsteroid2.accelerateAsteroid();
        smallAsteroid3.accelerateAsteroid();
        smallAsteroid4.accelerateAsteroid();
        SmallAsteroid[] smallasteroids = {smallAsteroid1,smallAsteroid2,smallAsteroid3,smallAsteroid4};
        for (SmallAsteroid smAs: smallasteroids){
            gamePane.getChildren().add(smAs.getGamePolygon());
        }
        return smallasteroids;
    }






    public static void createGameScene(Player player, Pane gamePane, List<GameObject> gameObjects,List<Bullet> playerBulletBarell,Stage stage, int level) {
        Scene gameScene = new Scene(gamePane);
        String scoreString = "Score: " + AsteroidApplication.CurrentScore;
        Text text = new Text(10, 20, scoreString);
        text.setFill(Color.WHITE);
        String levelStr = "Level " + level;
        Text levelText = new Text(100, 20, levelStr);
        levelText.setFill(Color.WHITE);
        String userNameStr = "Username: " + AsteroidApplication.userName;
        Text userName = new Text(400,20,userNameStr);
        userName.setFill(Color.WHITE);
        String lifeStr = "Life: " + player.life;
        Text lifeText = new Text(600,20,lifeStr);
        lifeText.setFill(Color.WHITE);
        String endGame = "Press ESC to end the game.";
        Text gameEnd = new Text(400,380,endGame);
        gameEnd.setFill(Color.WHITE);



        gamePane.getChildren().add(text);
        gamePane.getChildren().add(levelText);
        gamePane.getChildren().add(userName);
        gamePane.getChildren().add(lifeText);
        gamePane.getChildren().add(gameEnd);
        AtomicInteger score = new AtomicInteger(AsteroidApplication.CurrentScore);

        gameScene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        gameScene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        EnemyShip enemyShip = new EnemyShip();
        enemyShip.setAlive(false);
        KeyFrame kf = new KeyFrame(Duration.seconds(10), event -> {

                if (enemyShip.isAlive()) {
                    System.out.println("test");
                }

            if(!enemyShip.isAlive()) {
                gamePane.getChildren().add(enemyShip.getGamePolygon());
                gameObjects.add(enemyShip);
                enemyShip.setAlive(true);
                accelerateGameObject(enemyShip);
            }

        });

        // Create a Timeline object and add the KeyFrame event to it
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        AnimationTimer animationTimer = new AnimationTimer() {
            long lastCallTime = System.currentTimeMillis();

//            private long lastUpdateTime = 0;
//            private final long intervalNanoSeconds = 30_000_000_000L; // 30 seconds in nanoseconds




            @Override
            public void handle(long now) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastCallTime >= 2000) {
                    // 10 seconds have passed
                    lastCallTime = currentTime;
                    Random random = new Random();
                    if (random.nextDouble() < 0.3 & enemyShip.isAlive()) {
                        // call your method
                        Bullet bullet = enemyShip.createBullet();
                        gameObjects.add(bullet);
                        enemyShip.facePlayerandShoot(player, bullet, gamePane);
                        System.out.print("Yes");

                    } else {
                        enemyShip.randomRotate();
                    }
                }
                boolean gameOver = false;
                boolean nextLevel = false;

                List<GameObject> dynamicObjects = new ArrayList<>();
                List<GameObject> dynamicRemoveObjects = new ArrayList<>();

                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    player.turnLeft();
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    player.turnRight();
                }

                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    player.accelerate();

                }

                if (pressedKeys.getOrDefault(KeyCode.ESCAPE, false)) {
                    gameOver = true;
                    pressedKeys.remove(KeyCode.ESCAPE);
                }

                if (pressedKeys.getOrDefault(KeyCode.SHIFT, false)) {
                    player.HyperJump();
                    for (int i = 0; i < gameObjects.size(); i++) {
                        GameObject gameObject = gameObjects.get(i);
                        while (player.hasCollide(gameObject)) {
                            player.HyperJump();
                        }
                    }
                    pressedKeys.put(KeyCode.SHIFT, Boolean.FALSE);
                }


                if (pressedKeys.getOrDefault(KeyCode.SPACE, false)) {
                    Bullet bullet = player.createBullet();
                    bullet.setSpeed(player.getSpeed() + 0.5);
                    pressedKeys.put(KeyCode.SPACE, Boolean.FALSE);
                    gamePane.getChildren().add(bullet.getGamePolygon());
                    if (bullet.isNew()) {
                        playerBulletBarell.add(bullet);
                    }
                    bullet.accelerate();
                    bullet.setMovement(bullet.getMovement().normalize().multiply(3 + player.getSpeed()));

                }

                player.move();

                for (Bullet bullet : playerBulletBarell) {
                    boolean bulletGone = false;
                    if (bullet.getGamePolygon().isVisible()) {
                        bulletGone = bullet.move();
                        for (GameObject gameObject : gameObjects) {

                            if (bullet.hasCollide(gameObject) && gameObject.isAlive() && bullet.isAlive()) {
                                bullet.setAlive(false);
                                gamePane.getChildren().remove(bullet.getGamePolygon());
                                bullet.returnToBarell(player.getGunTip());
                                dynamicRemoveObjects.add(bullet);

                                if (gameObject instanceof LargeAsteroid) {
                                    AsteroidApplication.CurrentScore += 2;
                                    text.setText("Score: " + score.addAndGet(2));
                                    gameObject.setAlive(false);
                                    gamePane.getChildren().remove(gameObject.getGamePolygon());
                                    dynamicRemoveObjects.add(gameObject);
                                    GameObject[] mediumAstroids = largeAsteroidHit(gamePane, (LargeAsteroid) gameObject);
                                    for (GameObject medAstroid : mediumAstroids) {
                                        accelerateGameObject(medAstroid);
                                        dynamicObjects.add(medAstroid);
                                    }
                                }

                                if (gameObject instanceof MediumAsteroid) {
                                    AsteroidApplication.CurrentScore += 7;
                                    text.setText("Score: " + score.addAndGet(7));
                                    gameObject.setAlive(false);
                                    gamePane.getChildren().remove(gameObject.getGamePolygon());
                                    dynamicRemoveObjects.remove(gameObject);
                                    GameObject[] smallAsteroids = mediumAsteroidHit(gamePane, (MediumAsteroid) gameObject);
                                    for (GameObject smallAstroid : smallAsteroids) {
                                        accelerateGameObject(smallAstroid);
                                        dynamicObjects.add(smallAstroid);
                                    }
                                }

                                if (gameObject instanceof SmallAsteroid) {
                                    AsteroidApplication.CurrentScore += 12;
                                    text.setText("Score: " + score.addAndGet(12));
                                    gameObject.setAlive(false);
                                    dynamicRemoveObjects.remove(gameObject);
                                    gamePane.getChildren().remove(gameObject.getGamePolygon());
                                }

                                if (gameObject instanceof EnemyShip) {
                                    AsteroidApplication.CurrentScore += 20;
                                    text.setText("Score: " + score.addAndGet(20));
                                    enemyShip.setAlive(false);
                                    dynamicRemoveObjects.remove(enemyShip);
                                    gamePane.getChildren().remove(enemyShip.getGamePolygon());

                                    System.out.println(enemyShip.isAlive());
                                }

                            }
                        }
                        gameObjects.addAll(dynamicObjects);
                        gameObjects.removeAll(dynamicRemoveObjects);
                        dynamicObjects.clear();
                        dynamicRemoveObjects.clear();
                    }

                    if (bulletGone) {
                        gamePane.getChildren().remove(bullet.getGamePolygon());
                        bullet.returnToBarell(player.getGunTip());
                    }


                }


                for (GameObject gameObject : gameObjects) {
                    gameObject.move();
                    gameObject.movePath();
                    if (player.hasCollide(gameObject) && gameObject.isAlive()) {
                        player.subtractLife();
                        if(player.life == 0){

                            gameOver = true;
                            break;
                            }
                        else{
                            String lifeStr = "Life: " + player.life;
                            lifeText.setText(lifeStr);
                            player.HyperJump();
                        }

                    }
                    else if (AsteroidApplication.CurrentScore > getLevelThreshold(level)) {

                        nextLevel = true;
                        break;

                    }
                }


                if(gameOver){
                    stop();
                    player.resetPlayerMovement();
                    gameObjects.clear();
                    AsteroidScenes.gameOverScene(gameOver, stage);
                }
                else if(nextLevel){
                    player.resetPlayerMovement();
                    stop();
                    AsteroidScenes.nextLevelScene(nextLevel, level, stage);
                }
            }
        };

        animationTimer.start();
        stage.setScene(gameScene);
        stage.show();
    }





}



