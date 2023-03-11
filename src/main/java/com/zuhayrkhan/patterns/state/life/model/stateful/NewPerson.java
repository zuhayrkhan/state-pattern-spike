package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.support.state.Context;
import com.zuhayrkhan.patterns.state.support.state.ContextWrapper;

public class NewPerson implements ContextWrapper<LifeState, LifeState.Label> {

    private Context<LifeState, LifeState.Label> context;
    private final String name;

    public NewPerson(Context<LifeState, LifeState.Label> context, String name) {
        this.context = context;
        this.name = name;
    }

    @Override
    public Context<LifeState, LifeState.Label> getContext() {
        return context;
    }

    public void goToSleep() {
        context.getState().goToSleep(this);
    }

    public void wakeUp() {
        context.getState().wakeUp(this);
    }

    public void becomeHungry() {
        context.getState().becomeHungry(this);
    }

    public void becomeTired() {
        context.getState().becomeTired(this);
    }

    public String getName() {
        return name;
    }

}
