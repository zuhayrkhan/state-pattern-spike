package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.stateful.NewPerson;

public interface LifeState {

    default void goToSleep(NewPerson person) {
        throw new IllegalStateException("goToSleep not appropriate in current state");
    }

    default void wakeUp(NewPerson person) {
        throw new IllegalStateException("wakeUp not appropriate in current state");
    }

    default void becomeHungry(NewPerson person) {
        throw new IllegalStateException("becomeHungry not appropriate in current state");
    }

    default void becomeTired(NewPerson person) {
        throw new IllegalStateException("becomeTired not appropriate in current state");
    }

}
