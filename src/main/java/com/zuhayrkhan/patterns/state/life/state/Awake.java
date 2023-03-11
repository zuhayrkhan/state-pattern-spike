package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.model.stateful.NewPerson;
import com.zuhayrkhan.patterns.state.life.model.stateful.Person;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;

public class Awake implements LifeState {

    private final LifeStateReporter lifeStateReporter;

    Awake(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public void becomeHungry(Person person) {
        person.setLabel(Label.HUNGRY);
        lifeStateReporter.reportLifeStatus(person);
    }

    @Override
    public void becomeTired(Person person) {
        person.setLabel(Label.TIRED);
        lifeStateReporter.reportLifeStatus(person);
    }

    @Override
    public void becomeHungry(NewPerson person) {
        person.getContext().setLabel(Label.HUNGRY);
        lifeStateReporter.reportLifeStatus(person);
    }

    @Override
    public void becomeTired(NewPerson person) {
        person.getContext().setLabel(Label.TIRED);
        lifeStateReporter.reportLifeStatus(person);
    }
}
