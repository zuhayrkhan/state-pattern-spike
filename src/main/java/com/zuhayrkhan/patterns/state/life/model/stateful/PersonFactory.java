package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.LifeStateRegistry;

public class PersonFactory {

    private final LifeStateRegistry lifeStateRegistry;

    public PersonFactory(LifeStateRegistry lifeStateRegistry) {
        this.lifeStateRegistry = lifeStateRegistry;
    }

    public Person createPerson(String name) {
        return new Person(lifeStateRegistry, name);
    }

}
