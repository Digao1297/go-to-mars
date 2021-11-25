package br.com.test.gotomars.domain.entities;

import br.com.test.gotomars.domain.enums.Directions;

public class ProbeEntity {

    private String name;
    private int x;
    private int y;
    private Directions direction;
    private String moviments;


    public ProbeEntity(String name, int x, int y, Directions direction, String moviments) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.moviments = moviments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMoviments() {
        return moviments;
    }

    public void setMoviments(String moviments) {
        this.moviments = moviments;
    }
}
