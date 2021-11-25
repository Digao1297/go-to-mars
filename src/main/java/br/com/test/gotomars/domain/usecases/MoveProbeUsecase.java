package br.com.test.gotomars.domain.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;

public interface MoveProbeUsecase {
    QuadrantEntity execute(ProbeEntity entity);
}
