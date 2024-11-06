package com.asteroids.gameObjects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.Random;

public class SmallAsteroid extends GameObject{

    public SmallAsteroid(double posx, double posy) {
        super(SmallAsteroid.createPolygon(),posx, posy);
        Random rnd = new Random();
        super.getGamePolygon().setRotate(rnd.nextInt(360));
    }
    public SmallAsteroid() {
        super(SmallAsteroid.createPolygon());
        Random rnd = new Random();
//        SmallAsteroid.setSpeed(MediumAsteroid.getSpeed()+rnd.nextDouble(0.1,1.0));
    }


    public static Polygon createPolygon() {

        Random rnd = new Random();

        double size = 10 + rnd.nextInt(3);

        Polygon polygon = new Polygon();
        double c1 = Math.cos(Math.PI * 2 / 5);
        double c2 = Math.cos(Math.PI / 5);
        double s1 = Math.sin(Math.PI * 2 / 5);
        double s2 = Math.sin(Math.PI * 4 / 5);

        polygon.getPoints().addAll(
                size, 0.0,
                size * c1, -1 * size * s1,
                -1 * size * c2, -1 * size * s2,
                -1 * size * c2, size * s2,
                size * c1, size * s1);

        polygon.setFill(Color.BLACK);
        polygon.setStroke(Color.WHITE);

        return polygon;
    }
    public void movePath(){
        super.movePath();
        super.getGamePolygon().setRotate(super.getGamePolygon.getRotate() + 0.5);
    }
}
