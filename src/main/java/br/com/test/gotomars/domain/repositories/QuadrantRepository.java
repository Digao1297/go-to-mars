package br.com.test.gotomars.domain.repositories;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.repositories.params.UpdateProbeInQuadrantParams;

public interface QuadrantRepository {
    QuadrantEntity create(QuadrantEntity entity);

    QuadrantEntity landProbeInQuadrant(ProbeEntity entity) throws Exception;

    ProbeEntity updateProbeInQuadrant(UpdateProbeInQuadrantParams params) throws Exception;

    QuadrantEntity[][] findAll();
}
