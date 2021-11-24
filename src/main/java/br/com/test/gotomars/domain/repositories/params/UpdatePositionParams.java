package br.com.test.gotomars.domain.repositories.params;

import br.com.test.gotomars.domain.enums.Directions;

public class UpdatePositionParams {
    private int x;
    private int y;
    private Directions direction;

    public UpdatePositionParams(int x, int y, Directions direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }
}
