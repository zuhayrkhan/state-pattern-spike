package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;
import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.life.state.LifeStateFactory;
import com.zuhayrkhan.patterns.state.support.state.Context;
import com.zuhayrkhan.patterns.state.support.state.ContextWrapperFactory;
import com.zuhayrkhan.patterns.state.support.state.StateFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;
import java.util.function.Supplier;

public class NewPersonWrapperFactory implements
        ContextWrapperFactory<LifeState, LifeState.Label, NewPerson> {

    private final LifeStateReporter lifeStateReporter;

    public NewPersonWrapperFactory(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    public NewPerson createNewPerson(String name) {
        return createContextWrapper(name);
    }

    @Override
    public Supplier<StateFactory<LifeState, LifeState.Label>> stateFactoryCreator() {
        return () -> new LifeStateFactory(lifeStateReporter);
    }

    @Override
    public LifeState.Label initialLabel() {
        return LifeState.Label.ASLEEP;
    }

    @Override
    public Function<Context<LifeState, LifeState.Label>, NewPerson> contextWrapperCreator(Object... initargs) {
        return lifeStateLabelContext -> {
            try {
                Object[] actualInitArgs = new Object[1 + initargs.length];
                actualInitArgs[0] = lifeStateLabelContext;
                System.arraycopy(initargs, 0, actualInitArgs, 1, initargs.length);
                return NewPerson.class.getConstructor(Context.class, String.class).newInstance(actualInitArgs);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        };
    }

}
