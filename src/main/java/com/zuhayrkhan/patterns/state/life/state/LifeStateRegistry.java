package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.support.StateFactory;
import com.zuhayrkhan.patterns.state.support.StateRegistry;

public class LifeStateRegistry extends StateRegistry<LifeState, LifeState.Label> {

    public LifeStateRegistry(StateFactory<LifeState, LifeState.Label> lifeStateFactory) {
        super(lifeStateFactory);
    }


}
