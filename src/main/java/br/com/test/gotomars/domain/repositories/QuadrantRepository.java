package br.com.test.gotomars.domain.repositories;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;

public interface QuadrantRepository {
    QuadrantEntity create(QuadrantEntity entity);

    QuadrantEntity addProbe(ProbeEntity entity);

    QuadrantEntity updateProbeInQuadrant(ProbeEntity entity);
}
