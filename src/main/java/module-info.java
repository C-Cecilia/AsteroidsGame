module com.example.group17_asteroidsgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.asteroids.gameController to javafx.fxml;
    exports com.asteroids.gameController;
}