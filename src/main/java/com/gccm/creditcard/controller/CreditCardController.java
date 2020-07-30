package com.gccm.creditcard.controller;

import com.gccm.creditcard.model.ValidationRequest;
import com.gccm.creditcard.model.ValidationResult;
import com.gccm.creditcard.service.StrategyFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/credit-card")
public class CreditCardController {

    /** Factory of validation strategies. */
    private final StrategyFactoryService strategyFactoryService;

    @Autowired
    public CreditCardController(StrategyFactoryService strategyFactoryService) {
        this.strategyFactoryService = strategyFactoryService;
    }

    /**
     * Validates credit card numbers.
     * @param validationRequest contains the cardNumber to be validated.
     * @return ValidationResult
     */
    @PostMapping(path="/validate")
    public ValidationResult validate(@Valid @RequestBody ValidationRequest validationRequest) {

        // Sanitize cardNumber
        String cardNumber = validationRequest.getCardNumber().replaceAll("\\s","");

        // Strategy validation names that cardNumber passed.
        List<String> passedStrategies = this.strategyFactoryService.getStrategies()
                .stream()
                .filter(strategy -> strategy.validate(cardNumber))
                .map(strategy -> strategy.getName())
                .collect(Collectors.toList());

        String vendor = "Unknown";
        String status = "invalid";
        if (passedStrategies.size() > 0) {

            List<String> passedVendorStrategies =
                    passedStrategies
                            .stream()
                            .filter(s -> s != "Luhn")
                            .collect(Collectors.toList());

            List<String> passedLuhnStrategy =
                    passedStrategies
                            .stream()
                            .filter(s -> s == "Luhn")
                            .collect(Collectors.toList());

            // Should contain 1 element if cardNumber passed a vendor validation.
            if (passedVendorStrategies.size() > 0) {
                vendor = passedVendorStrategies.get(0);
            }

            // For card to be valid, it should have passed vendor and Luhn validation.
            if (passedVendorStrategies.size() > 0 && passedLuhnStrategy.size() > 0) {
                status = "valid";
            }
        }

        return new ValidationResult(validationRequest.getCardNumber(), vendor, status);
    }
}
