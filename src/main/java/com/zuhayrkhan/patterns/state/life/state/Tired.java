package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.stateful.NewPerson;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;

public class Tired implements LifeState {

    private final LifeStateReporter lifeStateReporter;

    Tired(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public void goToSleep(NewPerson person) {
        person.setState(Asleep.class);
        lifeStateReporter.reportLifeStatus(person);
    }
}
