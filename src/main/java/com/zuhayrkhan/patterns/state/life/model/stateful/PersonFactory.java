package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.Asleep;
import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.life.state.LifeStateFactory;
import com.zuhayrkhan.patterns.state.support.state.ContextWrapperFactory;

public class PersonFactory extends
        ContextWrapperFactory<LifeState, Person> {

    public PersonFactory(LifeStateFactory lifeStateFactory) {
        super(lifeStateFactory,
                Asleep.class,
                Person.class);
    }

    public Person createNewPerson(String name) {
        return createContextWrapper(name);
    }

}
