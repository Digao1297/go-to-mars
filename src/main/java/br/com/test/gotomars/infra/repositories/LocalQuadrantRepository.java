package br.com.test.gotomars.infra.repositories;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;

public class LocalQuadrantRepository implements QuadrantRepository {
    private final int size = 16;
    private final QuadrantEntity[][] quadrantEntities = new QuadrantEntity[size][size];

    @Override
    public QuadrantEntity create(QuadrantEntity entity) {
        return quadrantEntities[entity.getX()][entity.getY()] = entity;
    }

    @Override
    public QuadrantEntity updateProbeInQuadrant(ProbeEntity entity) {
        quadrantEntities[entity.getX()][entity.getY()].setProbe(entity);
        return quadrantEntities[entity.getX()][entity.getY()];
    }
}
