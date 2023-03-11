package com.zuhayrkhan.patterns.state.life.state;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

public class LifeStateRegistry {

    private final ConcurrentMap<LifeState.State, LifeState> states
            = new ConcurrentHashMap<>();

    private final LifeStateFactory lifeStateFactory;

    public LifeStateRegistry(LifeStateFactory lifeStateFactory) {
        this.lifeStateFactory = lifeStateFactory;
    }

    public LifeState getLifeState(LifeState.State state) {
        return switch (state) {
            case ASLEEP -> createIfNecessary(state, lifeStateFactory::createAsleep);
            case AWAKE -> createIfNecessary(state, lifeStateFactory::createAwake);
            case HUNGRY -> createIfNecessary(state, lifeStateFactory::createHungry);
            case TIRED -> createIfNecessary(state, lifeStateFactory::createTired);
        };
    }

    private LifeState createIfNecessary(final LifeState.State state,
                                        final Supplier<LifeState> stateCreator) {
        if (states.get(state) == null) {
            LifeState lifeState = stateCreator.get();
            LifeState existing = states.putIfAbsent(state, lifeState);
            if (existing != null) {
                return existing;
            }
            return lifeState;
        }
        return states.get(state);
    }

}
