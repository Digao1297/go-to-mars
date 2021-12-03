package br.com.test.gotomars.api.services;

import br.com.test.gotomars.api.models.ProbeModel;
import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.usecases.GenerateQuadrantsUsecase;
import br.com.test.gotomars.domain.usecases.LandProbeUsecase;
import br.com.test.gotomars.domain.usecases.MoveProbeUsecase;
import br.com.test.gotomars.domain.usecases.params.MoveProbeUsecaseParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProbeService {

    private final LandProbeUsecase landProbeUsecase;
    private final MoveProbeUsecase moveProbeUsecase;
    private final GenerateQuadrantsUsecase generateQuadrantsUsecase;

    @Autowired
    public ProbeService(LandProbeUsecase landProbeUsecase, MoveProbeUsecase moveProbeUsecase, GenerateQuadrantsUsecase generateQuadrantsUsecase) {
        this.landProbeUsecase = landProbeUsecase;
        this.moveProbeUsecase = moveProbeUsecase;
        this.generateQuadrantsUsecase = generateQuadrantsUsecase;
        this.generateQuadrantsUsecase.execute();
    }


    public ProbeEntity landing(ProbeModel model) throws Exception {
        final QuadrantEntity quadrantEntity = landProbeUsecase
                .execute(new ProbeEntity(model.getName(), model.getX(), model.getY(), model.getDirection()));
        return moveProbeUsecase.execute(new MoveProbeUsecaseParams(model.getMovements(), quadrantEntity));
    }
}
