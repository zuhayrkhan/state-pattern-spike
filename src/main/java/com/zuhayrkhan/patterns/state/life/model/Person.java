package com.zuhayrkhan.patterns.state.life;

import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.life.state.LifeStateRegistry;

import java.util.concurrent.atomic.AtomicReference;

public class Person {

    private final AtomicReference<LifeState.State> lifeStateRef =
            new AtomicReference<>(LifeState.State.ASLEEP);

    private final LifeStateRegistry lifeStateRegistry;

    public Person(LifeStateRegistry lifeStateRegistry) {
        this.lifeStateRegistry = lifeStateRegistry;
    }

    private LifeState getLifeState() {
        return lifeStateRegistry.getLifeState(lifeStateRef.get());
    }

    public void goToSleep(Person person) {
        getLifeState().goToSleep(person);
    }

    public void wakeUp(Person person) {
        getLifeState().wakeUp(person);
    }

    public void becomeHungry(Person person) {
        getLifeState().becomeHungry(person);
    }

    public void becomeTired(Person person) {
        getLifeState().becomeTired(person);
    }

    public LifeState.State getState() {
        return lifeStateRef.get();
    }

}
