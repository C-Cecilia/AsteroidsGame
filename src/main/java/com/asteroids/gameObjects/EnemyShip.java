package com.asteroids.gameObjects;

import com.asteroids.gameController.AsteroidApplication;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.List;
import java.util.Random;

public class EnemyShip extends GameObject implements Shootable{


    public EnemyShip(int x, int y) {
        super(new Polygon(-12, 0, 0, -5, 12, 0, 0, -25), x, y);
        this.getGamePolygon().setFill(Color.BLACK);
        this.getGamePolygon().setStroke(Color.RED);

    }

    public EnemyShip() {
        super(new Polygon(-12, 0, 0, -5, 12, 0, 0, -25));
        Random random = new Random();
        int randomWidth = random.nextInt(0,400);
        int randomHeight = random.nextInt(0,900);
        this.getGamePolygon.setTranslateX(randomHeight);
        this.getGamePolygon.setTranslateY(randomWidth);
        this.getGamePolygon().setFill(Color.BLACK);
        this.getGamePolygon().setStroke(Color.RED);
        super.getGamePolygon().setRotate(random.nextInt(360));
    }

    public Point2D getGunTip() {
        ObservableList<Double> points = this.getGamePolygon().getPoints();
        double gunPointX = points.get(points.size()-1) + this.getGamePolygon().getTranslateX();
        double gunPointY = points.get(points.size()-2) + this.getGamePolygon().getTranslateY();

        Point2D gunPoint = new Point2D(gunPointX, gunPointY);
        return gunPoint;
    }


    public Bullet createBullet(){
            Bullet bullet = new Bullet((double)this.getGunTip().getX(),(double)this.getGunTip().getY());
            bullet.setNew(true);
            bullet.getGamePolygon().setRotate(this.getGamePolygon().getRotate());
        return bullet;
    }

    public void facePlayerandShoot(Player player, Bullet bullet, Pane pane) {
        double dx = player.getGamePolygon().getTranslateX() - this.getGamePolygon().getTranslateX();
        double dy = player.getGamePolygon().getTranslateY() - this.getGamePolygon().getTranslateY();
        double angleRadians = Math.atan2(dy, dx);
        double angleDegrees = Math.toDegrees(angleRadians);

        // Rotate the polygon
        this.getGamePolygon().setRotate(angleDegrees+100);

        // Update the movement vector
        double speed = 1.5;
        Point2D direction = new Point2D(dx, dy).normalize().multiply(speed);
        this.setMovement(direction);

        // Accelerate the enemy ship
        this.accelerate();

        bullet.getGamePolygon().setRotate(this.getGamePolygon().getRotate());
        pane.getChildren().add(bullet.getGamePolygon());
        bullet.accelerate();
        bullet.setMovement(bullet.getMovement().normalize().multiply(3));

    }

    public void randomRotate(){
        Random rnd1 = new Random();
        Random rnd2 = new Random();
        double dx = rnd1.nextDouble();
        double dy = rnd2.nextDouble();
        double angleRadians = Math.atan2(dy, dx);
        double angleDegrees = Math.toDegrees(angleRadians);

        // Rotate the polygon
        this.getGamePolygon().setRotate(angleDegrees+100);

        // Update the movement vector
        double speed = 2;
        Point2D direction = new Point2D(dx, dy).normalize().multiply(speed);
        this.setMovement(direction);

        // Accelerate the enemy ship
        this.accelerate();
    }








    public void shoot(){

    }
    public void movePath(){
        super.movePath();
        super.getGamePolygon().setRotate(super.getGamePolygon.getRotate() + 0.5);
    }




}
