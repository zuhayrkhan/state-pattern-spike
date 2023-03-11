package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.life.state.LifeStateRegistry;

import java.util.concurrent.atomic.AtomicReference;

public class Person {

    private final AtomicReference<LifeState.Label> lifeStateRef =
            new AtomicReference<>(LifeState.Label.ASLEEP);

    private final LifeStateRegistry lifeStateRegistry;

    private final String name;

    public Person(LifeStateRegistry lifeStateRegistry, String name) {
        this.lifeStateRegistry = lifeStateRegistry;
        this.name = name;
    }

    private LifeState getLifeState() {
        return lifeStateRegistry.getState(lifeStateRef.get());
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

    public void setStatus(LifeState.Label label) {
        lifeStateRef.set(label);
    }

    public LifeState.Label getState() {
        return lifeStateRef.get();
    }
}
