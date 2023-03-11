package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.Person;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;

public class Awake implements LifeState {

    private final LifeStateReporter lifeStateReporter;

    Awake(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public void becomeHungry(Person person) {
        person.setStatus(State.HUNGRY);
        lifeStateReporter.reportLifeStatus(person);
    }

    @Override
    public void becomeTired(Person person) {
        person.setStatus(State.TIRED);
        lifeStateReporter.reportLifeStatus(person);
    }

}