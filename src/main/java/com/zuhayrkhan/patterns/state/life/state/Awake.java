package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.stateful.NewPerson;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;

public class Awake implements LifeState {

    private final LifeStateReporter lifeStateReporter;

    Awake(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public void becomeHungry(NewPerson person) {
        person.setState(Hungry.class);
        lifeStateReporter.reportLifeStatus(person);
    }

    @Override
    public void becomeTired(NewPerson person) {
        person.setState(Tired.class);
        lifeStateReporter.reportLifeStatus(person);
    }
}
