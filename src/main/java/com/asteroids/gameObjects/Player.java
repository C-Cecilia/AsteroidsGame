package com.asteroids.gameObjects;


import com.asteroids.gameController.AsteroidApplication;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.Random;


public class Player extends GameObject implements Shootable{

    private static Player playerInstance;
    public int life;

    ArrayList<Bullet> bulletBarell = new ArrayList<Bullet>();

    private static Point2D playerMovement = new Point2D(0, 0);
    private static int tipX = 0;
    private static int tipY = -20;

    private Player() {
        super(new Polygon(tipX, tipY, 5, 0, -5, 0),AsteroidApplication.WIDTH/2.0, AsteroidApplication.HEIGHT/2.0);
        this.life = 3;
    }

    public static Player getInstance() {
        if (playerInstance == null) {
            playerInstance = new Player();
            playerInstance.getGamePolygon().setFill(Color.DARKGRAY);
            playerInstance.getGamePolygon().setStroke(Color.BLACK);

        }
        return playerInstance;
    }


    public Point2D getGunTip() {
        double gunPointX = tipX + playerInstance.getGamePolygon().getTranslateX();
        double gunPointY = tipY + playerInstance.getGamePolygon().getTranslateY();
        Point2D gunPoint = new Point2D(gunPointX, gunPointY);
        return gunPoint;
    }



    public void HyperJump() {
        playerInstance.getGamePolygon().setVisible(false);
        Random random = new Random();
        int width = random.nextInt(AsteroidApplication.WIDTH - 12);
        int height = random.nextInt(AsteroidApplication.HEIGHT - 12);
        playerInstance.getGamePolygon().setTranslateX(width);
        playerInstance.getGamePolygon().setTranslateY(height);
        int rotation = random.nextInt(360);
        playerInstance.getGamePolygon().setRotate(rotation);
        playerInstance.getGamePolygon().setVisible(true);
    }




    public Bullet createBullet(){
        Bullet bullet = null;
        if(bulletBarell.size()<100000){
            bullet = new Bullet((double)playerInstance.getGunTip().getX(),(double)playerInstance.getGunTip().getY());
            bullet.setNew(true);
            bullet.getGamePolygon().setRotate(playerInstance.getGamePolygon().getRotate());
            bulletBarell.add(bullet);

        }
        else{
            bullet = bulletBarell.get(0);
            bullet.getGamePolygon().setVisible(true);
            Point2D currentGunTip = playerInstance.getGunTip();
            bullet.getGamePolygon().setTranslateX(currentGunTip.getX());
            bullet.getGamePolygon().setTranslateX(currentGunTip.getY());
        }
        return bullet;
    }


    @Override
    public boolean move() {

        playerInstance.getGamePolygon().setTranslateX(playerInstance.getGamePolygon().getTranslateX() + this.movement.getX());
        playerInstance.getGamePolygon().setTranslateY(playerInstance.getGamePolygon().getTranslateY() + this.movement.getY());
        if (playerInstance.getGamePolygon().getTranslateX() < 0) {
            playerInstance.getGamePolygon().setTranslateX(playerInstance.getGamePolygon().getTranslateX() + AsteroidApplication.WIDTH);
        }

        if (playerInstance.getGamePolygon().getTranslateX() > AsteroidApplication.WIDTH) {
            playerInstance.getGamePolygon().setTranslateX(playerInstance.getGamePolygon().getTranslateX() % AsteroidApplication.WIDTH);
        }

        if (playerInstance.getGamePolygon().getTranslateY() < 0) {
            playerInstance.getGamePolygon().setTranslateY(playerInstance.getGamePolygon().getTranslateY() + AsteroidApplication.HEIGHT);
        }

        if (playerInstance.getGamePolygon().getTranslateY() > AsteroidApplication.HEIGHT) {
            playerInstance.getGamePolygon().setTranslateY(playerInstance.getGamePolygon().getTranslateY() % AsteroidApplication.HEIGHT);
        }
        return true;
    }


    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.getGamePolygon.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.getGamePolygon.getRotate()));

        changeX *= 0.05;
        changeY *= 0.05;

        this.movement = this.movement.add(changeY, -changeX);
    }
    public void subtractLife(){
        this.life --;
    }

    public void resetPlayerMovement(){
        this.setMovement(new Point2D(0,0));
        this.life = 3;
    }



}
