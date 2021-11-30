package br.com.test.gotomars.api;

import br.com.test.gotomars.data.usecases.GenerateQuadrantsUsecaseImpl;
import br.com.test.gotomars.data.usecases.LandProbeUsecaseImpl;
import br.com.test.gotomars.data.usecases.MoveProbeUsecaseImpl;
import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.enums.Directions;
import br.com.test.gotomars.domain.repositories.ProbeRepository;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.GenerateQuadrantsUsecase;
import br.com.test.gotomars.domain.usecases.LandProbeUsecase;
import br.com.test.gotomars.domain.usecases.MoveProbeUsecase;
import br.com.test.gotomars.infra.repositories.LocalProbeRepository;
import br.com.test.gotomars.infra.repositories.LocalQuadrantRepository;

public class Test {
    public static void main(String[] args) throws Exception {
        QuadrantRepository localQuadrantRepository = new LocalQuadrantRepository();
        ProbeRepository localProbeRepository = new LocalProbeRepository();

        GenerateQuadrantsUsecase generateQuadrantsUsecase = new GenerateQuadrantsUsecaseImpl(localQuadrantRepository);

        MoveProbeUsecase moveProbeUsecase = new MoveProbeUsecaseImpl(localQuadrantRepository);

        LandProbeUsecase landProbeUsecase = new LandProbeUsecaseImpl(localQuadrantRepository, localProbeRepository);

        generateQuadrantsUsecase.execute();

        QuadrantEntity quadrant = landProbeUsecase.execute(new ProbeEntity("Sonda", 3, 3, Directions.E));

        System.out.println("X: " + quadrant.getX() + "\n" +
                "Y: " + quadrant.getY() + "\n" +
                "Probe: " + quadrant.getProbe().getName());

        //moveProbeUsecase.execute(new MoveProbeUsecaseParams("MMRMMRMRRM", new ProbeEntity("Sonda", 3, 3, Directions.E)));

    }


}
