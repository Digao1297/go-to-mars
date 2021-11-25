package br.com.test.gotomars.domain.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;

public interface LandProbeUsecase {
    QuadrantEntity execute(ProbeEntity entity);
}
