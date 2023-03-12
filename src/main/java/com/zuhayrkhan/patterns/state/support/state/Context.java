package com.zuhayrkhan.patterns.state.support.state;

import java.util.concurrent.atomic.AtomicReference;

public class Context<STATE> {

    final StateRegistry<STATE> stateRegistry;

    final AtomicReference<Class<? extends STATE>> stateRef;

    public Context(StateRegistry<STATE> stateRegistry,
                   Class<? extends STATE> initialState) {
        this.stateRegistry = stateRegistry;
        stateRef = new AtomicReference<>(initialState);
    }

    public STATE getState() {
        return stateRegistry.getState(stateRef.get());
    }

    public void setState(Class<? extends STATE> newState) {
        stateRef.set(newState);
    }
}
