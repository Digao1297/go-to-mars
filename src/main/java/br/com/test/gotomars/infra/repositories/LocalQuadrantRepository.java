package br.com.test.gotomars.infra.repositories;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.repositories.params.UpdateProbeInQuadrantParams;

public class LocalQuadrantRepository implements QuadrantRepository {
    private final int size = 16;
    private final QuadrantEntity[][] quadrantEntities = new QuadrantEntity[size][size];

    @Override
    public QuadrantEntity create(QuadrantEntity entity) {
        return quadrantEntities[entity.getX()][entity.getY()] = entity;
    }

    @Override
    public QuadrantEntity landProbeInQuadrant(ProbeEntity entity) throws Exception {
        if (quadrantIsEmpty(entity)) {
            quadrantEntities[entity.getX()][entity.getY()].setProbe(entity);
            return quadrantEntities[entity.getX()][entity.getY()];
        } else {
            throw new Exception("Quadrante ocupado!");
        }
    }

    @Override
    public ProbeEntity updateProbeInQuadrant(UpdateProbeInQuadrantParams params) throws Exception {
        QuadrantEntity quadrantEntity = params.getQuadrantEntity();
        ProbeEntity newPositionEntity = params.getProbeEntity();

        if (quadrantIsEmpty(newPositionEntity)) {
            quadrantEntities[quadrantEntity.getX()][quadrantEntity.getY()].setProbe(null);
            quadrantEntities[newPositionEntity.getX()][newPositionEntity.getY()].setProbe(newPositionEntity);
            return quadrantEntities[newPositionEntity.getX()][newPositionEntity.getY()].getProbe();
        } else {
            throw new Exception("Quadrante ocupado!");
        }
    }

    @Override
    public QuadrantEntity[][] findAll() {
        return quadrantEntities;
    }

    private boolean quadrantIsEmpty(ProbeEntity entity) {
        return quadrantEntities[entity.getX()][entity.getY()].getProbe() == null;

    }
}
