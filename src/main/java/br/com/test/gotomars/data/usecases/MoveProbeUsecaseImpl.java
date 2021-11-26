package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.enums.Directions;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.MoveProbeUsecase;
import br.com.test.gotomars.domain.usecases.params.MoveProbeUsecaseParams;
import br.com.test.gotomars.domain.windRose.WindRose;

public class MoveProbeUsecaseImpl implements MoveProbeUsecase {

    private QuadrantRepository repository;
    private WindRose[] windRoses;


    public MoveProbeUsecaseImpl(QuadrantRepository repository) {
        this.repository = repository;
        this.windRoses = new WindRose[]{
                new WindRose(Directions.E, Directions.W, Directions.N),
                new WindRose(Directions.S, Directions.N, Directions.E),
                new WindRose(Directions.W, Directions.E, Directions.S),
                new WindRose(Directions.N, Directions.S, Directions.W),
        };
    }

    @Override
    public QuadrantEntity execute(MoveProbeUsecaseParams params) {
        for (int i = 0; i < params.getMoviments().length(); i++) {
            char c = params.getMoviments().charAt(i);

            switch (c) {
                case 'R':
                    Directions nextDirection = nextOrPreviousDirection(params.getEntity().getDirection(), true);
                    params.getEntity().setDirection(nextDirection);
                    break;
                case 'L':
                    Directions previousDirection = nextOrPreviousDirection(params.getEntity().getDirection(), false);
                    params.getEntity().setDirection(previousDirection);
                    break;
                case 'M':
                    ProbeEntity probeEntity = params.getEntity();
                    switch (params.getEntity().getDirection()) {
                        case N:
                            probeEntity.setY(params.getEntity().getY() + 1);
                            break;
                        case W:
                            probeEntity.setX(params.getEntity().getX() - 1);
                            break;
                        case E:
                            probeEntity.setX(params.getEntity().getX() + 1);
                            break;
                        case S:
                            probeEntity.setY(params.getEntity().getY() - 1);
                            break;
                    }
                    System.out.println(repository.updateProbeInQuadrant(probeEntity).toString());
                    break;
            }
        }
        return null;
    }

    private Directions nextOrPreviousDirection(Directions direction, boolean isNext) {
        Directions dir = null;
        for (int i = 0; i < this.windRoses.length; i++) {
            if (this.windRoses[i].getCurrentNode() == direction) {
                dir = isNext ? this.windRoses[i].getNextNode() : this.windRoses[i].getPreviousNode();
                break;
            }
        }
        return dir;
    }


}