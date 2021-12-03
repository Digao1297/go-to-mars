package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.repositories.ProbeRepository;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.LandProbeUsecase;

public class LandProbeUsecaseImpl implements LandProbeUsecase {

    private QuadrantRepository quadrantRepository;
    private ProbeRepository probeRepository;

    public LandProbeUsecaseImpl(QuadrantRepository quadrantRepository, ProbeRepository probeRepository) {
        this.quadrantRepository = quadrantRepository;
        this.probeRepository = probeRepository;
    }

    @Override
    public QuadrantEntity execute(ProbeEntity entity) throws Exception {

        ProbeEntity probe = probeRepository.create(entity);
        QuadrantEntity quadrant = quadrantRepository.landProbeInQuadrant(probe);
        return quadrant;

    }
}
