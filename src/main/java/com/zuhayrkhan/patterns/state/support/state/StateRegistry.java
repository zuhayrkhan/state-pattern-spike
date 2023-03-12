package com.zuhayrkhan.patterns.state.support.state;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StateRegistry<STATE> {

    protected final StateFactory<STATE> stateFactory;

    private final ConcurrentMap<Class<? extends STATE>, STATE> states
            = new ConcurrentHashMap<>();

    public StateRegistry(StateFactory<STATE> stateFactory) {
        this.stateFactory = stateFactory;
    }

    public STATE getState(Class<? extends STATE> state) {
        return createIfNecessary(state);
    }

    private STATE createIfNecessary(final Class<? extends STATE> stateClass) {
        if (states.get(stateClass) == null) {
            STATE state = stateFactory.createState(stateClass);
            STATE existing = states.putIfAbsent(stateClass, state);
            if (existing != null) {
                return existing;
            }
            return state;
        }
        return states.get(stateClass);
    }
}
