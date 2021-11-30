package br.com.test.gotomars.domain.usecases.params;

import br.com.test.gotomars.domain.entities.QuadrantEntity;

public class MoveProbeUsecaseParams {
    private String moviments;
    private QuadrantEntity entity;

    public MoveProbeUsecaseParams(String moviments, QuadrantEntity entity) {
        this.moviments = moviments;
        this.entity = entity;
    }

    public String getMoviments() {
        return moviments;
    }

    public void setMoviments(String moviments) {
        this.moviments = moviments;
    }

    public QuadrantEntity getEntity() {
        return entity;
    }

    public void setEntity(QuadrantEntity entity) {
        this.entity = entity;
    }
}
