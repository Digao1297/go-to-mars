package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.LandProbeUsecase;

public class LandProbeUsecaseImpl implements LandProbeUsecase {

    private QuadrantRepository repository;

    public LandProbeUsecaseImpl(QuadrantRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuadrantEntity execute(ProbeEntity entity) {
        return repository.updateProbeInQuadrant(entity);
    }
}
