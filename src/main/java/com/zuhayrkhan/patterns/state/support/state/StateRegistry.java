package com.zuhayrkhan.patterns.state.support.state;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StateRegistry<STATE> {

    protected final StateFactory<STATE> stateFactory;

    private final ConcurrentMap<Class<? extends STATE>, STATE> states
            = new ConcurrentHashMap<>();

    public StateRegistry(StateFactory<STATE> stateFactory) {
        this.stateFactory = Objects.requireNonNull(stateFactory, "stateFactory must not be null");
    }

    public STATE getState(Class<? extends STATE> state) {
        Objects.requireNonNull(state, "state class must not be null");
        return states.computeIfAbsent(state, stateFactory::createState);
    }
}
