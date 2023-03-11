package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.stateful.Person;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;

public class Tired implements LifeState {

    private final LifeStateReporter lifeStateReporter;

    Tired(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public void goToSleep(Person person) {
        person.setStatus(Label.ASLEEP);
        lifeStateReporter.reportLifeStatus(person);
    }
}
