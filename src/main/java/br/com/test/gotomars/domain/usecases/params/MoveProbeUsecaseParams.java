package br.com.test.gotomars.domain.usecases.params;

import br.com.test.gotomars.domain.entities.ProbeEntity;

public class MoveProbeUsecaseParams {
    private String moviments;
    private ProbeEntity entity;

    public MoveProbeUsecaseParams(String movements, ProbeEntity entity) {
        this.moviments = movements;
        this.entity = entity;
    }

    public String getMoviments() {
        return moviments;
    }

    public void setMoviments(String moviments) {
        this.moviments = moviments;
    }

    public ProbeEntity getEntity() {
        return entity;
    }

    public void setEntity(ProbeEntity entity) {
        this.entity = entity;
    }
}
