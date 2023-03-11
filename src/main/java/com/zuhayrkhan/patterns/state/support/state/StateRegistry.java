package com.zuhayrkhan.patterns.state.support.state;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StateRegistry<STATE, LABEL> {

    protected final StateFactory<STATE, LABEL> stateFactory;

    private final ConcurrentMap<LABEL, STATE> states
            = new ConcurrentHashMap<>();

    public StateRegistry(StateFactory<STATE, LABEL> stateFactory) {
        this.stateFactory = stateFactory;
    }

    public STATE getState(LABEL label) {
        return createIfNecessary(label);
    }

    private STATE createIfNecessary(final LABEL label) {
        if (states.get(label) == null) {
            STATE state = stateFactory.createState(label);
            STATE existing = states.putIfAbsent(label, state);
            if (existing != null) {
                return existing;
            }
            return state;
        }
        return states.get(label);
    }
}
