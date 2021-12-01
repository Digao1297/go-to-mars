package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.FindAllQuadrantsUsecase;

public class FindAllQuadrantsUsecaseImpl implements FindAllQuadrantsUsecase {

    private QuadrantRepository repository;

    public FindAllQuadrantsUsecaseImpl(QuadrantRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuadrantEntity[][] execute() {
        return repository.findAll();
    }
}
