package com.gccm.creditcard.controller;

import com.gccm.creditcard.model.ValidationRequest;
import com.gccm.creditcard.model.ValidationResult;
import com.gccm.creditcard.strategy.StrategyFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CreditCardController {

    /** Factory of validation strategies. */
    private final StrategyFactory strategyFactory;

    public CreditCardController(StrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    @PostMapping(path="/validate", consumes="application/json")
    public ValidationResult validate(@Valid @RequestBody ValidationRequest validationRequest) {

        return new ValidationResult("4408 0412 3456 7893", "VISA", "valid");
    }
}
