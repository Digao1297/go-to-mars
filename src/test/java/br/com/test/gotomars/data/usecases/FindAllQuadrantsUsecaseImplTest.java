package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.FindAllQuadrantsUsecase;
import br.com.test.gotomars.domain.usecases.GenerateQuadrantsUsecase;
import br.com.test.gotomars.infra.repositories.LocalQuadrantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FindAllQuadrantsUsecaseImplTest.class)
public class FindAllQuadrantsUsecaseImplTest {

    private FindAllQuadrantsUsecase findAllQuadrantsUsecase;

    @BeforeEach
    void setup() {

        QuadrantRepository quadrantRepository = new LocalQuadrantRepository();

        findAllQuadrantsUsecase = new FindAllQuadrantsUsecaseImpl(quadrantRepository);
        GenerateQuadrantsUsecase generateQuadrantsUsecase = new GenerateQuadrantsUsecaseImpl(quadrantRepository);

        generateQuadrantsUsecase.execute();
    }

    @Test()
    void findAllQuadrants() {
        QuadrantEntity[][] entity = findAllQuadrantsUsecase.execute();

        Assertions.assertNotNull(entity);
    }

}
