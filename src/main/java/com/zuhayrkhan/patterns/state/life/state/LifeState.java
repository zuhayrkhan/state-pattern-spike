package com.zuhayrkhan.patterns.state.life;

public interface LifeState {

    enum State {
        ASLEEP,
        AWAKE,
        HUNGRY,
        TIRED,
    }

    default void goToSleep() {
        throw new IllegalStateException("goToSleep not appropriate in current state");
    }

    default void wakeUp() {
        throw new IllegalStateException("wakeUp not appropriate in current state");
    }

    default void becomeHungry() {
        throw new IllegalStateException("becomeHungry not appropriate in current state");
    }

    default void becomeTired() {
        throw new IllegalStateException("becomeTired not appropriate in current state");
    }

}
