package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.enums.Directions;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.GenerateQuadrantsUsecase;
import br.com.test.gotomars.domain.usecases.MoveProbeUsecase;
import br.com.test.gotomars.domain.usecases.params.MoveProbeUsecaseParams;
import br.com.test.gotomars.infra.repositories.LocalQuadrantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MoveProbeUsecaseImplTest.class)
public class MoveProbeUsecaseImplTest {

    private GenerateQuadrantsUsecase generateQuadrantsUsecase;
    private MoveProbeUsecase moveProbeUsecase;


    @BeforeEach
    void setup() {
        QuadrantRepository quadrantRepository = new LocalQuadrantRepository();

        moveProbeUsecase = new MoveProbeUsecaseImpl(quadrantRepository);

        generateQuadrantsUsecase = new GenerateQuadrantsUsecaseImpl(quadrantRepository);
        generateQuadrantsUsecase.execute();


    }

    @Test
    void moveProbe() throws Exception {
        ProbeEntity probeEntity = new ProbeEntity("sonda", 3, 3, Directions.E);
        QuadrantEntity quadrantEntity = new QuadrantEntity(3, 3);
        quadrantEntity.setProbe(probeEntity);

        ProbeEntity result = moveProbeUsecase.execute(new MoveProbeUsecaseParams("MMRMMRMRRM", quadrantEntity));

        Assertions.assertEquals(5, result.getX());
        Assertions.assertEquals(1, result.getY());
        Assertions.assertEquals(Directions.E, result.getDirection());
    }
}
