package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.enums.Directions;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.MoveProbeUsecase;

public class MoveProbeUsecaseImpl implements MoveProbeUsecase {

    private QuadrantRepository repository;

    public MoveProbeUsecaseImpl(QuadrantRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuadrantEntity execute(ProbeEntity entity) {

        for (int i = 0; i < entity.getMoviments().length(); i++) {
            char c = entity.getMoviments().charAt(i);

            switch (c) {
                case 'R':
                    break;
                case 'L':
                    break;
                case 'M':
                    break;
            }
        }
        return null;
    }

    public Directions nextDirection(Directions direction) {
        Directions[] directions = Directions.values();
        Directions result = null;

        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == direction) {
                if (i < directions.length) {
                    result = directions[i + 1];
                } else {
                    result = directions[0];
                }
            }
        }
        return result;
    }

    public Directions backDirection(Directions direction) {
        Directions[] directions = Directions.values();
        Directions result = null;

        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == direction) {
                if (i > 0) {
                    result = directions[i - 1];
                } else {
                    result = directions[directions.length];
                }
            }
        }
        return result;
    }


}
