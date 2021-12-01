package br.com.test.gotomars.api.controllers;

import br.com.test.gotomars.api.models.ProbeModel;
import br.com.test.gotomars.api.services.ProbeService;
import br.com.test.gotomars.domain.entities.ProbeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbeController {

    private final ProbeService probeService;

    @Autowired
    public ProbeController(ProbeService probeService) {
        this.probeService = probeService;
    }

    @PostMapping
    public ProbeEntity land(@RequestBody ProbeModel model) throws Exception {
        return probeService.landing(model);
    }
}
