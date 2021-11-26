package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.usecases.GenerateQuadrantsUsecase;
import br.com.test.gotomars.infra.repositories.LocalQuadrantRepository;

public class GenerateQuadrantsUsecaseImpl implements GenerateQuadrantsUsecase {

    private final int size = 16;
    private LocalQuadrantRepository repository;

    public GenerateQuadrantsUsecaseImpl(LocalQuadrantRepository repository) {
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
