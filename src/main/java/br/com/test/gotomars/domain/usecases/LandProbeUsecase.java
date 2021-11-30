package br.com.test.gotomars.domain.usecases;

import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.usecases.params.LandProbeUsecaseParams;

public interface LandProbeUsecase {
    QuadrantEntity execute(LandProbeUsecaseParams params);
}
