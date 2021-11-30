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
    public QuadrantEntity landProbeInQuadrant(ProbeEntity entity) {
        if (quadrantIsEmpty(entity)) {
            System.out.println("Quadrante ocupado");
            return null;
        } else {
            quadrantEntities[entity.getX()][entity.getY()].setProbe(entity);
            return quadrantEntities[entity.getX()][entity.getY()];
        }
    }

    @Override
    public QuadrantEntity updateProbeInQuadrant(ProbeEntity entity) {
        if (searchProbe(entity)) {

        } else {

        }

        quadrantEntities[entity.getX()][entity.getY()].setProbe(entity);
        return quadrantEntities[entity.getX()][entity.getY()];
    }


    private boolean searchProbe(ProbeEntity entity) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (quadrantEntities[i][j].getProbe() != null && quadrantEntities[i][j].getProbe().equals(entity)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private boolean quadrantIsEmpty(ProbeEntity entity) {
        if (quadrantEntities[entity.getX()][entity.getY()].getProbe() == null) {
            return true;
        } else {
            return false;
        }

    }
}
