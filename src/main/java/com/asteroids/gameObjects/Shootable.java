package com.asteroids.gameObjects;

import javafx.geometry.Point2D;

public interface Shootable {
    public Point2D getGunTip();
    public Bullet createBullet();
}
