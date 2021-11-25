package br.com.test.gotomars.api;

import br.com.test.gotomars.data.usecases.MoveProbeUsecaseImpl;
import br.com.test.gotomars.domain.usecases.MoveProbeUsecase;
import br.com.test.gotomars.infra.repositories.LocalQuadrantRepository;

public class Test {
    public static void main(String[] args) {
        MoveProbeUsecase moveProbeUsecase = new MoveProbeUsecaseImpl(new LocalQuadrantRepository());

        System.out.println(moveProbeUsecase.);
    }
}
