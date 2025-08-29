package com.zuhayrkhan.patterns.state.support.state;

import java.util.Objects;

public abstract class ContextHolderFactory<STATE,
        CONTEXT_WRAPPER extends ContextHolder<STATE>> {

    private final StateFactory<STATE> stateFactory;

    private final Class<? extends STATE> initialState;

    protected ContextHolderFactory(StateFactory<STATE> stateFactory,
                                   Class<? extends STATE> initialState) {
        this.stateFactory = Objects.requireNonNull(stateFactory, "stateFactory must not be null");
        this.initialState = Objects.requireNonNull(initialState, "initialState must not be null");
    }

    protected Context<STATE> createContext() {
        return new Context<>(new StateRegistry<>(stateFactory),
                initialState);
    }

}
