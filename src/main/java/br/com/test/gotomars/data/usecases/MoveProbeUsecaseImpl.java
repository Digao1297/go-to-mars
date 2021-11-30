package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.enums.Directions;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.repositories.params.UpdateProbeInQuadrantParams;
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
    public ProbeEntity execute(MoveProbeUsecaseParams params) {
        ProbeEntity probeEntity = params.getEntity().getProbe();
        QuadrantEntity quadrant;


        for (int i = 0; i < params.getMoviments().length(); i++) {
            char c = params.getMoviments().charAt(i);
            switch (c) {
                case 'R':
                    Directions nextDirection = nextOrPreviousDirection(probeEntity.getDirection(), true);
                    probeEntity.setDirection(nextDirection);
                    break;
                case 'L':
                    Directions previousDirection = nextOrPreviousDirection(probeEntity.getDirection(), false);
                    probeEntity.setDirection(previousDirection);
                    break;
                case 'M':
                    switch (probeEntity.getDirection()) {
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
            }
        }
        try {
            return repository.updateProbeInQuadrant(new UpdateProbeInQuadrantParams(probeEntity, params.getEntity()));
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
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
