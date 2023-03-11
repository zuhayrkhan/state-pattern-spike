package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.stateful.Person;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;

public class Asleep implements LifeState {

    private final LifeStateReporter lifeStateReporter;

    Asleep(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public void wakeUp(Person person) {
        person.setStatus(State.AWAKE);
        lifeStateReporter.reportLifeStatus(person);
    }
}
