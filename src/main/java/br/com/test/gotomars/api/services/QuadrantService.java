package br.com.test.gotomars.api.services;

import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.usecases.FindAllQuadrantsUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuadrantService {

    private final FindAllQuadrantsUsecase findAllQuadrantsUsecase;

    @Autowired
    public QuadrantService(FindAllQuadrantsUsecase findAllQuadrantsUsecase) {
        this.findAllQuadrantsUsecase = findAllQuadrantsUsecase;
    }

    public QuadrantEntity[][] findAll() {
        return findAllQuadrantsUsecase.execute();
    }
}
