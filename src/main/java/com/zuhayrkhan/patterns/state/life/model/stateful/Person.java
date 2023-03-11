package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.life.state.LifeStateRegistry;

import java.util.concurrent.atomic.AtomicReference;

public class Person {

    private final AtomicReference<LifeState.State> lifeStateRef =
            new AtomicReference<>(LifeState.State.ASLEEP);

    private final LifeStateRegistry lifeStateRegistry;

    private final String name;

    public Person(LifeStateRegistry lifeStateRegistry, String name) {
        this.lifeStateRegistry = lifeStateRegistry;
        this.name = name;
    }

    private LifeState getLifeState() {
        return lifeStateRegistry.getLifeState(lifeStateRef.get());
    }

    public void goToSleep() {
        getLifeState().goToSleep(this);
    }

    public void wakeUp() {
        getLifeState().wakeUp(this);
    }

    public void becomeHungry() {
        getLifeState().becomeHungry(this);
    }

    public void becomeTired() {
        getLifeState().becomeTired(this);
    }

    public String getName() {
        return name;
    }

    public void setStatus(LifeState.State state) {
        lifeStateRef.set(state);
    }

    public LifeState.State getState() {
        return lifeStateRef.get();
    }
}
