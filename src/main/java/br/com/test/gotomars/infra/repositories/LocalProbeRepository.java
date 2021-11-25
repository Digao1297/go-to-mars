package br.com.test.gotomars.infra.repositories;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.repositories.ProbeRepository;
import br.com.test.gotomars.domain.repositories.params.UpdatePositionParams;

import java.util.ArrayList;

public class LocalProbeRepository implements ProbeRepository {

    private final ArrayList<ProbeEntity> probeEntityList = new ArrayList<>();

    @Override
    public ProbeEntity create(ProbeEntity entity) {
        probeEntityList.add(entity);
        return entity;
    }

    @Override
    public ProbeEntity updatePosition(UpdatePositionParams params) {
        int index = probeEntityList.indexOf(params.getEntity());

        return probeEntityList.set(index,
                new ProbeEntity(
                        params.getEntity().getName(),
                        params.getX(),
                        params.getY(),
                        params.getDirection()
                )
        );

    }
}
