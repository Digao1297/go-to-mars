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
    public QuadrantEntity addProbe(ProbeEntity entity) {

        quadrantEntities[entity.getX()][entity.getY()].setProbe(entity);
        return quadrantEntities[entity.getX()][entity.getY()];
    }

    @Override
    public QuadrantEntity updateProbeInQuadrant(ProbeEntity entity) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (quadrantEntities[i][j].getProbe() != null) {

                }
            }
        }
        quadrantEntities[entity.getX()][entity.getY()].setProbe(entity);
        return quadrantEntities[entity.getX()][entity.getY()];
    }
}
