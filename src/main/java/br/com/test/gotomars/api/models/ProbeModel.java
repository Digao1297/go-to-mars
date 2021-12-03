package br.com.test.gotomars.api.models;

import br.com.test.gotomars.domain.enums.Directions;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProbeModel {

    @NotNull(message = "Este campo é obrigatório")
    private String name;

    @Min(value = Integer.MIN_VALUE, message = "Este campo é obrigatório e deve ser Inteiro")
    @Max(value = Integer.MAX_VALUE, message = "Este campo é obrigatório e deve ser Inteiro")
    private int x;

    @Min(value = Integer.MIN_VALUE, message = "Este campo é obrigatório e deve ser Inteiro")
    @Max(value = Integer.MAX_VALUE, message = "Este campo é obrigatório e deve ser Inteiro")
    private int y;

    @NotNull(message = "Este campo é obrigatório")
    private Directions direction;

    @NotNull(message = "Este campo é obrigatório")
    private String movements;


    public ProbeModel(String name, int x, int y, Directions direction, String movements) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.movements = movements;
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

    public String getMovements() {
        return movements;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }
}
