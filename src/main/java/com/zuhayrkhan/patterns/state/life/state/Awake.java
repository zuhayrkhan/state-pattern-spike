package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.stateful.Person;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;

public class Awake implements LifeState {

    private final LifeStateReporter lifeStateReporter;

    Awake(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public void becomeHungry(Person person) {
        person.setStatus(Label.HUNGRY);
        lifeStateReporter.reportLifeStatus(person);
    }

    @Override
    public void becomeTired(Person person) {
        person.setStatus(Label.TIRED);
        lifeStateReporter.reportLifeStatus(person);
    }

}
