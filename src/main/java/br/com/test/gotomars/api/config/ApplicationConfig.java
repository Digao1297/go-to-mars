package br.com.test.gotomars.api.config;

import br.com.test.gotomars.data.usecases.FindAllQuadrantsUsecaseImpl;
import br.com.test.gotomars.data.usecases.GenerateQuadrantsUsecaseImpl;
import br.com.test.gotomars.data.usecases.LandProbeUsecaseImpl;
import br.com.test.gotomars.data.usecases.MoveProbeUsecaseImpl;
import br.com.test.gotomars.domain.repositories.ProbeRepository;
import br.com.test.gotomars.domain.repositories.QuadrantRepository;
import br.com.test.gotomars.domain.usecases.FindAllQuadrantsUsecase;
import br.com.test.gotomars.domain.usecases.GenerateQuadrantsUsecase;
import br.com.test.gotomars.domain.usecases.LandProbeUsecase;
import br.com.test.gotomars.domain.usecases.MoveProbeUsecase;
import br.com.test.gotomars.infra.repositories.LocalProbeRepository;
import br.com.test.gotomars.infra.repositories.LocalQuadrantRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    private final ProbeRepository probeRepository;
    private final QuadrantRepository quadrantRepository;

    public ApplicationConfig() {
        probeRepository = new LocalProbeRepository();
        quadrantRepository = new LocalQuadrantRepository();
    }

    @Bean
    public LandProbeUsecase landProbeUsecase() {
        return new LandProbeUsecaseImpl(quadrantRepository, probeRepository);
    }

    @Bean
    public GenerateQuadrantsUsecase generateQuadrantsUsecase() {
        return new GenerateQuadrantsUsecaseImpl(quadrantRepository);
    }

    @Bean
    public MoveProbeUsecase moveProbeUsecase() {
        return new MoveProbeUsecaseImpl(quadrantRepository);
    }

    @Bean
    public FindAllQuadrantsUsecase findAllQuadrantsUsecase() {
        return new FindAllQuadrantsUsecaseImpl(quadrantRepository);
    }
}
