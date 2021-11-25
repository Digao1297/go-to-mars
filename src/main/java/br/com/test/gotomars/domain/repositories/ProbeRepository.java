package br.com.test.gotomars.domain.repositories;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.repositories.params.UpdatePositionParams;

public interface ProbeRepository {
    ProbeEntity create(ProbeEntity entity);

    Object updatePosition(UpdatePositionParams params);
}


