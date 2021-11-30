package br.com.test.gotomars.api;

import br.com.test.gotomars.data.usecases.GenerateQuadrantsUsecaseImpl;
import br.com.test.gotomars.data.usecases.LandProbeUsecaseImpl;
import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.enums.Directions;
import br.com.test.gotomars.domain.repositories.ProbeRepository;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.GenerateQuadrantsUsecase;
import br.com.test.gotomars.domain.usecases.LandProbeUsecase;
import br.com.test.gotomars.domain.usecases.params.LandProbeUsecaseParams;
import br.com.test.gotomars.infra.repositories.LocalProbeRepository;
import br.com.test.gotomars.infra.repositories.LocalQuadrantRepository;

public class Test {
    public static void main(String[] args) {
        QuadrantRepository localQuadrantRepository = new LocalQuadrantRepository();
        ProbeRepository localProbeRepository = new LocalProbeRepository();

        GenerateQuadrantsUsecase generateQuadrantsUsecase = new GenerateQuadrantsUsecaseImpl(localQuadrantRepository);

        LandProbeUsecase landProbeUsecase = new LandProbeUsecaseImpl(localQuadrantRepository, localProbeRepository);

        generateQuadrantsUsecase.execute();

        landProbeUsecase.execute(new LandProbeUsecaseParams("MMRMMRMRRM", new ProbeEntity("Sonda", 3, 3, Directions.E)));

    }


}
