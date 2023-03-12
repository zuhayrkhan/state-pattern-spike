package com.zuhayrkhan.patterns.state.support.state;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class ContextWrapperFactory<STATE,
        CONTEXT_WRAPPER extends ContextWrapper<STATE>> {

    private final StateFactory<STATE> stateFactory;

    private final Class<? extends STATE> initialState;

    private final Class<CONTEXT_WRAPPER> contextWrapperClass;

    protected ContextWrapperFactory(StateFactory<STATE> stateFactory,
                                    Class<? extends STATE> initialState,
                                    Class<CONTEXT_WRAPPER> contextWrapperClass) {
        this.stateFactory = stateFactory;
        this.initialState = initialState;
        this.contextWrapperClass = contextWrapperClass;
    }

    protected CONTEXT_WRAPPER createContextWrapper(Object... initargs) {

        Context<STATE> context = new Context<>(new StateRegistry<>(stateFactory),
                initialState);

        try {
            Class<?>[] initClasses = Stream.concat(Stream.of(context), Arrays.stream(initargs))
                    .map((Function<Object, Class<?>>) Object::getClass)
                    .toArray(Class[]::new);

            Object[] actualInitArgs = new Object[1 + initargs.length];
            actualInitArgs[0] = context;
            System.arraycopy(initargs, 0, actualInitArgs, 1, initargs.length);
            return contextWrapperClass.getConstructor(initClasses)
                    .newInstance(actualInitArgs);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
