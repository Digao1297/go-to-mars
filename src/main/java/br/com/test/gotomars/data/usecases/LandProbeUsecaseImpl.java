package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.repositories.ProbeRepository;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.LandProbeUsecase;
import br.com.test.gotomars.domain.usecases.params.MoveProbeUsecaseParams;

public class LandProbeUsecaseImpl implements LandProbeUsecase {

    private QuadrantRepository quadrantRepository;
    private ProbeRepository probeRepository;

    public LandProbeUsecaseImpl(QuadrantRepository quadrantRepository, ProbeRepository probeRepository) {
        this.quadrantRepository = quadrantRepository;
        this.probeRepository = probeRepository;
    }

    @Override
    public QuadrantEntity execute(MoveProbeUsecaseParams params) {
        return null;
    }


}
