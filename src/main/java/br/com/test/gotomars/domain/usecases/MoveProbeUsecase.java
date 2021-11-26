package br.com.test.gotomars.domain.usecases;

import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.usecases.params.MoveProbeUsecaseParams;

public interface MoveProbeUsecase {
    QuadrantEntity execute(MoveProbeUsecaseParams params);
}