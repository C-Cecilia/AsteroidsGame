package com.asteroids.gameObjects;

import com.asteroids.gameController.AsteroidApplication;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import java.util.Random;

public class GameObject extends Polygon {

    public Polygon getGamePolygon;
    public Point2D movement;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    private boolean alive;
    public static double speed;


//


    public Point2D calculatePosition(){
        double max_x;
        double max_y;
        double x;
        double y;
        Random random = new Random();
        max_x = AsteroidApplication.WIDTH;
        max_y = AsteroidApplication.HEIGHT;
        x = random.nextDouble(max_x)*Math.PI * 2;
        y = random.nextDouble(max_y)*Math.PI * 2;
        return new Point2D(x, y);
    }


    public GameObject(Polygon polygon){
        this.getGamePolygon = polygon;
        Point2D pos = calculatePosition();
        this.getGamePolygon.setTranslateX(pos.getX());
        this.getGamePolygon.setTranslateY(pos.getY());
        while(hasPlayerCollide(this.getGamePolygon)){
            pos = calculatePosition();
            this.getGamePolygon.setTranslateX(pos.getX());
            this.getGamePolygon.setTranslateY(pos.getY());
        }
        //for positioning of the object on the screen
        this.setAlive(true);
        //movement of an object first initialized to 0
        this.movement = new Point2D(0,0);
        this.speed = 1;
    }

    public GameObject(Polygon polygon, double x, double y){
        this.getGamePolygon = polygon;
        //for positioning of the object on the screen
        this.setAlive(true);
        this.getGamePolygon.setTranslateX(x);
        this.getGamePolygon.setTranslateY(y);
        //movement of an object first initialized to 0
        this.movement = new Point2D(0,0);
        this.speed = 1;
    }

    public Polygon getGamePolygon() {
        return getGamePolygon;
    }



    public void turnLeft() {
        this.getGamePolygon.setRotate(this.getGamePolygon.getRotate() - 5);
    }

    public void turnRight() {
        this.getGamePolygon.setRotate(this.getGamePolygon.getRotate() + 5);
    }

    public void rotate() {
        Random rnd = new Random();
        double rotation = this.getGamePolygon().getRotate() + rnd.nextInt(360);
        this.getGamePolygon().setRotate(rotation);
    }


    public boolean move() {
        this.getGamePolygon.setTranslateX(this.getGamePolygon.getTranslateX() + this.movement.getX());
        this.getGamePolygon.setTranslateY(this.getGamePolygon.getTranslateY() + this.movement.getY());

        if (this.getGamePolygon.getTranslateX() < 0) {
            this.getGamePolygon.setTranslateX(this.getGamePolygon.getTranslateX() + AsteroidApplication.WIDTH);
        }

        if (this.getGamePolygon.getTranslateX() > AsteroidApplication.WIDTH) {
            this.getGamePolygon.setTranslateX(this.getGamePolygon.getTranslateX() % AsteroidApplication.WIDTH);
        }

        if (this.getGamePolygon.getTranslateY() < 0) {
            this.getGamePolygon.setTranslateY(this.getGamePolygon.getTranslateY() + AsteroidApplication.HEIGHT);
        }

        if (this.getGamePolygon.getTranslateY() > AsteroidApplication.HEIGHT) {
            this.getGamePolygon.setTranslateY(this.getGamePolygon.getTranslateY() % AsteroidApplication.HEIGHT);
        }
        return false;
    }

    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.getGamePolygon.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.getGamePolygon.getRotate()));

        changeX *= 0.02;
        changeY *= 0.02;

        this.movement = this.movement.add(changeY, -changeX);
    }
    public void movePath(){
        this.getGamePolygon.setTranslateY(this.getGamePolygon.getTranslateY()+this.movement.getY());
        this.getGamePolygon.setTranslateX(this.getGamePolygon.getTranslateX()+this.movement.getX());
    }
    public void accelerateAsteroid() {


        // Rotate the asteroid randomly
        rotate();
        Random rnd = new Random();

        // Calculate the change in x and y velocity based on the current direction
        double direction = this.getGamePolygon().getRotate();
        double delta_x = Math.cos(Math.toRadians(direction));
        double delta_y = Math.sin(Math.toRadians(direction));

        this.movement = this.movement.add(delta_x, delta_y);
    }

    public boolean hasCollide(GameObject other) {
        Shape collisionArea = Shape.intersect(this.getGamePolygon, other.getGamePolygon());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

    public static boolean hasPlayerCollide(Polygon polygon) {
        Shape collisionArea = Shape.intersect(Player.getInstance().getGamePolygon(), polygon);
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

    public Point2D getObjectPosition() {
        double objectPointX = movement.getX() + this.getGamePolygon().getTranslateX();
        double objectPointY = movement.getY() + this.getGamePolygon().getTranslateY();
        Point2D objectPos = new Point2D(objectPointX, objectPointY);
        return objectPos;
    }




    public Point2D getMovement() {
        return movement;
    }

    public static double getSpeed(){
        return speed;
    }
    public static double setSpeed(double speed){
        return speed;
    }

    public void setMovement(Point2D movement) {
        this.movement = movement;
    }

}
