package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.Person;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;

public class Hungry implements LifeState {

    private final LifeStateReporter lifeStateReporter;

    Hungry(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public void becomeTired(Person person) {
        person.setStatus(State.TIRED);
        lifeStateReporter.reportLifeStatus(person);
    }
}
