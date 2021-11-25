package br.com.test.gotomars.domain.usecase;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;

public interface MoveProbe {
    QuadrantEntity execute(ProbeEntity entity);
}
