package br.com.test.gotomars.data.usecases;

import br.com.test.gotomars.domain.entities.ProbeEntity;
import br.com.test.gotomars.domain.entities.QuadrantEntity;
import br.com.test.gotomars.domain.enums.Directions;
import br.com.test.gotomars.domain.repositories.ProbeRepository;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.LandProbeUsecase;
import br.com.test.gotomars.domain.usecases.params.LandProbeUsecaseParams;
import br.com.test.gotomars.domain.windRose.WindRose;

public class LandProbeUsecaseImpl implements LandProbeUsecase {

    private QuadrantRepository quadrantRepository;
    private ProbeRepository probeRepository;
    private WindRose[] windRoses;

    public LandProbeUsecaseImpl(QuadrantRepository quadrantRepository, ProbeRepository probeRepository) {
        this.quadrantRepository = quadrantRepository;
        this.probeRepository = probeRepository;
        this.windRoses = new WindRose[]{
                new WindRose(Directions.E, Directions.W, Directions.N),
                new WindRose(Directions.S, Directions.N, Directions.E),
                new WindRose(Directions.W, Directions.E, Directions.S),
                new WindRose(Directions.N, Directions.S, Directions.W),
        };
    }

    @Override
    public QuadrantEntity execute(LandProbeUsecaseParams params) {
        ProbeEntity probe = probeRepository.create(params.getEntity());
        ProbeEntity probeEntity = params.getEntity();
        QuadrantEntity quadrant;

        for (int i = 0; i < params.getMoviments().length(); i++) {
            char c = params.getMoviments().charAt(i);
            switch (c) {
                case 'R':
                    Directions nextDirection = nextOrPreviousDirection(params.getEntity().getDirection(), true);
                    probeEntity.setDirection(nextDirection);

                    break;
                case 'L':
                    Directions previousDirection = nextOrPreviousDirection(params.getEntity().getDirection(), false);
                    probeEntity.setDirection(previousDirection);
                    break;
                case 'M':
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

                    break;
            }

        }
        quadrant = quadrantRepository.updateProbeInQuadrant(probeEntity);
        System.out.println("x: " + quadrant.getProbe().getX() + " Y: " + quadrant.getProbe().getY() + " " + quadrant.getProbe().getDirection());
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
