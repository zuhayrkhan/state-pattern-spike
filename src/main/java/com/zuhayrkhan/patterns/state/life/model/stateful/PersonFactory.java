package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.support.state.StateRegistry;

public class PersonFactory {

    private final StateRegistry<LifeState, LifeState.Label> lifeStateRegistry;

    public PersonFactory(StateRegistry<LifeState, LifeState.Label> lifeStateRegistry) {
        this.lifeStateRegistry = lifeStateRegistry;
    }

    public Person createPerson(String name) {
        return new Person(lifeStateRegistry, name);
    }

}
