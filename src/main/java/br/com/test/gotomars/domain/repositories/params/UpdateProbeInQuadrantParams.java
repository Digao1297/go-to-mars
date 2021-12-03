package br.com.test.gotomars.domain.repositories.params;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;

public class UpdateProbeInQuadrantParams {
    private ProbeEntity probeEntity;
    private QuadrantEntity quadrantEntity;

    public UpdateProbeInQuadrantParams(ProbeEntity probeEntity, QuadrantEntity quadrantEntity) {
        this.probeEntity = probeEntity;
        this.quadrantEntity = quadrantEntity;
    }

    public ProbeEntity getProbeEntity() {
        return probeEntity;
    }

    public void setProbeEntity(ProbeEntity probeEntity) {
        this.probeEntity = probeEntity;
    }

    public QuadrantEntity getQuadrantEntity() {
        return quadrantEntity;
    }

    public void setQuadrantEntity(QuadrantEntity quadrantEntity) {
        this.quadrantEntity = quadrantEntity;
    }
}
