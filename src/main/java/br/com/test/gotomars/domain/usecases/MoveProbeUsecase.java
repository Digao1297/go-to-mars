package br.com.test.gotomars.domain.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.usecases.params.MoveProbeUsecaseParams;

public interface MoveProbeUsecase {
    ProbeEntity execute(MoveProbeUsecaseParams params);
}