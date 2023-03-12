package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.Asleep;
import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.life.state.LifeStateFactory;
import com.zuhayrkhan.patterns.state.support.state.ContextWrapperFactory;

public class NewPersonFactory extends
        ContextWrapperFactory<LifeState, NewPerson> {

    public NewPersonFactory(LifeStateFactory lifeStateFactory) {
        super(lifeStateFactory,
                Asleep.class,
                NewPerson.class);
    }

    public NewPerson createNewPerson(String name) {
        return createContextWrapper(name);
    }

}
