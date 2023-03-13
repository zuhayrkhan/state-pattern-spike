package com.zuhayrkhan.patterns.state.support.state;

public abstract class ContextHolderFactory<STATE,
        CONTEXT_WRAPPER extends ContextHolder<STATE>> {

    private final StateFactory<STATE> stateFactory;

    private final Class<? extends STATE> initialState;

    private final Class<CONTEXT_WRAPPER> contextWrapperClass;

    protected ContextHolderFactory(StateFactory<STATE> stateFactory,
                                   Class<? extends STATE> initialState,
                                   Class<CONTEXT_WRAPPER> contextWrapperClass) {
        this.stateFactory = stateFactory;
        this.initialState = initialState;
        this.contextWrapperClass = contextWrapperClass;
    }

    protected Context<STATE> createContext() {
        return new Context<>(new StateRegistry<>(stateFactory),
                initialState);
    }

}
