package br.com.test.gotomars.api.controllers;

import br.com.test.gotomars.api.exceptions.LandingException;
import br.com.test.gotomars.api.models.ProbeModel;
import br.com.test.gotomars.api.services.ProbeService;
import br.com.test.gotomars.domain.entities.ProbeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProbeController {

    private final ProbeService probeService;

    @Autowired
    public ProbeController(ProbeService probeService) {
        this.probeService = probeService;
    }

    @PostMapping
    public ResponseEntity<ProbeEntity> land(@Valid @RequestBody ProbeModel model) throws Exception {

        try {
            ProbeEntity result = probeService.landing(model);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new LandingException(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
