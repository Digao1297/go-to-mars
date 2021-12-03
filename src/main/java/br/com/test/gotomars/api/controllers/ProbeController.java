package br.com.test.gotomars.api.controllers;

import br.com.test.gotomars.api.exceptions.LandingException;
import br.com.test.gotomars.api.models.ProbeModel;
import br.com.test.gotomars.api.services.ProbeService;
import br.com.test.gotomars.domain.entities.ProbeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProbeEntity> land(@RequestBody ProbeModel model) throws Exception {

        try {
            ProbeEntity result = probeService.landing(model);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new LandingException(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
