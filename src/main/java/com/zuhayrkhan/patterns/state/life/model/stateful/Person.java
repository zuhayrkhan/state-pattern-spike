package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.support.state.StateRegistry;
import com.zuhayrkhan.patterns.state.support.state.StatefulModel;

public class Person extends StatefulModel<LifeState, LifeState.Label> {

    private final String name;

    public Person(StateRegistry<LifeState, LifeState.Label> lifeStateRegistry, String name) {
        super(lifeStateRegistry, LifeState.Label.ASLEEP);
        this.name = name;
    }

    public void goToSleep() {
        getState().goToSleep(this);
    }

    public void wakeUp() {
        getState().wakeUp(this);
    }

    public void becomeHungry() {
        getState().becomeHungry(this);
    }

    public void becomeTired() {
        getState().becomeTired(this);
    }

    public String getName() {
        return name;
    }

}
