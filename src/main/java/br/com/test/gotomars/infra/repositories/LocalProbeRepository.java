package br.com.test.gotomars.infra.repositories;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.repositories.ProbeRepository;

import java.util.ArrayList;

public class LocalProbeRepository implements ProbeRepository {

    private final ArrayList<ProbeEntity> probeEntityList = new ArrayList<>();

    @Override
    public ProbeEntity create(ProbeEntity entity) {
        probeEntityList.add(entity);
        return entity;
    }
}
