package com.zuhayrkhan.patterns.state.support.state;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Context<STATE> {

    final StateRegistry<STATE> stateRegistry;

    final AtomicReference<Class<? extends STATE>> stateRef;

    public Context(StateRegistry<STATE> stateRegistry,
                   Class<? extends STATE> initialState) {
        this.stateRegistry = Objects.requireNonNull(stateRegistry, "stateRegistry must not be null");
        this.stateRef = new AtomicReference<>(Objects.requireNonNull(initialState, "initialState must not be null"));
    }

    public STATE getState() {
        return stateRegistry.getState(stateRef.get());
    }

    public void setState(Class<? extends STATE> newState) {
        stateRef.getAndSet(Objects.requireNonNull(newState, "newState must not be null"));
    }
}
