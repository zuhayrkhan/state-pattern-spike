package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.support.state.Context;
import com.zuhayrkhan.patterns.state.support.state.ContextHolder;

public class Person implements ContextHolder<LifeState> {

    private final Context<LifeState> context;
    private final String name;

    public Person(Context<LifeState> context, String name) {
        this.context = context;
        this.name = name;
    }

    @Override
    public Context<LifeState> getContext() {
        return context;
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
