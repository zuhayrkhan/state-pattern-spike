package com.zuhayrkhan.patterns.state.support.state;

public interface ContextWrapper<STATE> {

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
}
