package br.com.test.gotomars.domain.repositories;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;

public interface QuadrantRepository {
    QuadrantEntity create(QuadrantEntity entity);

    QuadrantEntity landProbeInQuadrant(ProbeEntity entity);
    
    QuadrantEntity updateProbeInQuadrant(ProbeEntity entity);
}
