package com.gccm.creditcard.service;

import com.gccm.creditcard.strategy.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Emulates a strategy factory class by grouping all the strategy instances created by the
 * IoC container into a HashMap and make them accessible for consumption.
 */
@Service
public class StrategyFactoryService {

    @Autowired
    private List<Strategy> strategies;

    private final Map<String, Strategy> strategyCache = new HashMap<>();

    /**
     * Loads strategy instances into a map.
     */
    @PostConstruct
    public void initializeStrategyCache() {
        for (Strategy strategy : strategies) {
            strategyCache.put(strategy.getName(), strategy);
        }
    }

    /**
     * Returns all validation strategies available as a collection.
     * @return Collection<Strategy>
     */
    public Collection<Strategy> getStrategies() {
        return strategyCache.values();
    }
}
