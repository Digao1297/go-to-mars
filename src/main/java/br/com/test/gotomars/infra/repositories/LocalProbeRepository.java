package br.com.test.gotomars.infra.repositories;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.repositories.ProbeRepository;
import br.com.test.gotomars.domain.repositories.params.UpdatePositionParams;

import java.util.ArrayList;
import java.util.List;

public class LocalProbeRepository implements ProbeRepository {

    private List<ProbeEntity> probeEntityList = new ArrayList<ProbeEntity>();

    @Override
    public ProbeEntity create(ProbeEntity entity) {
        probeEntityList.add(entity);
        return entity;
    }

    @Override
    public ProbeEntity updatePosition(UpdatePositionParams params) {
        return null;
    }
}
