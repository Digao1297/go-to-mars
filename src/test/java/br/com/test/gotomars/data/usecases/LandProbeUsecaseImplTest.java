package br.com.test.gotomars.data.usecases;


import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.enums.Directions;
import br.com.test.gotomars.domain.repositories.ProbeRepository;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.GenerateQuadrantsUsecase;
import br.com.test.gotomars.domain.usecases.LandProbeUsecase;
import br.com.test.gotomars.infra.repositories.LocalProbeRepository;
import br.com.test.gotomars.infra.repositories.LocalQuadrantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = LandProbeUsecaseImplTest.class)
public class LandProbeUsecaseImplTest {

    private GenerateQuadrantsUsecase generateQuadrantsUsecase;
    private LandProbeUsecase landProbeUsecase;

    @BeforeEach
    void setup() {

        QuadrantRepository quadrantRepository = new LocalQuadrantRepository();
        ProbeRepository probeRepository = new LocalProbeRepository();

        landProbeUsecase = new LandProbeUsecaseImpl(quadrantRepository, probeRepository);
        generateQuadrantsUsecase = new GenerateQuadrantsUsecaseImpl(quadrantRepository);

        generateQuadrantsUsecase.execute();
    }

    @Test()
    void landProbe() throws Exception {
        QuadrantEntity entity = landProbeUsecase.execute(new ProbeEntity("sonda", 3, 3, Directions.E));

        Assertions.assertEquals(3, entity.getProbe().getX());
        Assertions.assertEquals(3, entity.getProbe().getY());
        Assertions.assertEquals(Directions.E, entity.getProbe().getDirection());
    }


}
