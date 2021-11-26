package br.com.test.gotomars.api;

import br.com.test.gotomars.data.usecases.MoveProbeUsecaseImpl;
import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.enums.Directions;
import br.com.test.gotomars.domain.usecases.MoveProbeUsecase;
import br.com.test.gotomars.domain.usecases.params.MoveProbeUsecaseParams;
import br.com.test.gotomars.infra.repositories.LocalQuadrantRepository;

public class Test {
    public static void main(String[] args) {
        MoveProbeUsecase moveProbeUsecase = new MoveProbeUsecaseImpl(new LocalQuadrantRepository());

        moveProbeUsecase.execute(new MoveProbeUsecaseParams("LRM", new ProbeEntity("Sonda", 0, 0, Directions.N)));

    }


}
