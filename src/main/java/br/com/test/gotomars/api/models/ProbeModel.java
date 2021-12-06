package br.com.test.gotomars.api.models;

import br.com.test.gotomars.api.validations.EnumPattern;
import br.com.test.gotomars.domain.enums.Directions;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProbeModel {

    @NotNull(message = "Este campo é obrigatório")
    private final String name;

    @Min(value = Integer.MIN_VALUE, message = "Este campo é obrigatório e deve ser Inteiro")
    @Max(value = Integer.MAX_VALUE, message = "Este campo é obrigatório e deve ser Inteiro")
    private final int x;

    @Min(value = Integer.MIN_VALUE, message = "Este campo é obrigatório e deve ser Inteiro")
    @Max(value = Integer.MAX_VALUE, message = "Este campo é obrigatório e deve ser Inteiro")
    private final int y;

    @NotNull(message = "Este campo é obrigatório")
    @EnumPattern(regexp = "N|E|S|W", message = "Valor inválido!")
    private final Directions direction;

    @NotNull(message = "Este campo é obrigatório")
    private final String movements;


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


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public Directions getDirection() {
        return direction;
    }


    public String getMovements() {
        return movements;
    }


}
