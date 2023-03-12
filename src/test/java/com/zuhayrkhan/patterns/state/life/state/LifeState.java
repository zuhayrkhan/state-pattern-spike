package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.stateful.Person;

public interface LifeState {

    default void goToSleep(Person person) {
        throw new IllegalStateException("goToSleep not appropriate in current state");
    }

    default void wakeUp(Person person) {
        throw new IllegalStateException("wakeUp not appropriate in current state");
    }

    default void becomeHungry(Person person) {
        throw new IllegalStateException("becomeHungry not appropriate in current state");
    }

    default void becomeTired(Person person) {
        throw new IllegalStateException("becomeTired not appropriate in current state");
    }

}
