package asteroids;

import javafx.scene.shape.Polygon;

public class Ship extends Character{
    //shape == character

    public Ship(int x, int y){
        super(new Polygon(-5, -5, 10, 0, -5, 5), x, y);
    }

}
