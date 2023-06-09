package com.zuhayrkhan.patterns.state.support.state;

public interface ContextHolder<STATE> {

    Context<STATE> getContext();

    default STATE getState() {
        return getContext().getState();
    }

    default void setState(Class<? extends STATE> newState) {
        getContext().setState(newState);
    }

    default String getStateName() {
        return getContext().getState().getClass().getSimpleName();
    }

    default Class<STATE> getStateClass() {
        return (Class<STATE>) getContext().getState().getClass();
    }

}
