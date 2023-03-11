package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.life.state.LifeStateFactory;
import com.zuhayrkhan.patterns.state.support.state.ContextWrapperFactory;

public class NewPersonFactory extends
        ContextWrapperFactory<LifeState, LifeState.Label, NewPerson> {

    public NewPersonFactory(LifeStateFactory lifeStateFactory) {
        super(lifeStateFactory,
                LifeState.Label.ASLEEP,
                NewPerson.class);
    }

    public NewPerson createNewPerson(String name) {
        return createContextWrapper(name);
    }

}
