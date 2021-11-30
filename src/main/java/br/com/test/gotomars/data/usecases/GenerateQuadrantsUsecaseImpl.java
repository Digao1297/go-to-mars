package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.GenerateQuadrantsUsecase;

public class GenerateQuadrantsUsecaseImpl implements GenerateQuadrantsUsecase {

    private final int size = 16;
    private QuadrantRepository repository;

    public GenerateQuadrantsUsecaseImpl(QuadrantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                repository.create(new QuadrantEntity(
                        i, j
                ));
            }
        }
    }
}
