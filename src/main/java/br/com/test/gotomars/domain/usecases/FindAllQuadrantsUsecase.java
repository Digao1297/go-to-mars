package br.com.test.gotomars.domain.usecases;

import br.com.test.gotomars.domain.entities.QuadrantEntity;

public interface FindAllQuadrantsUsecase {
    QuadrantEntity[][] execute();
}
