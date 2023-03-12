package com.zuhayrkhan.patterns.state.support.state;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class ContextHolderFactory<STATE,
        CONTEXT_WRAPPER extends ContextHolder<STATE>> {

    private final StateFactory<STATE> stateFactory;

    private final Class<? extends STATE> initialState;

    private final Class<CONTEXT_WRAPPER> contextWrapperClass;

    protected ContextHolderFactory(StateFactory<STATE> stateFactory,
                                   Class<? extends STATE> initialState,
                                   Class<CONTEXT_WRAPPER> contextWrapperClass) {
        this.stateFactory = stateFactory;
        this.initialState = initialState;
        this.contextWrapperClass = contextWrapperClass;
    }

    protected CONTEXT_WRAPPER createContextWrapper(Object... initArgs) {

        Context<STATE> context = new Context<>(new StateRegistry<>(stateFactory),
                initialState);

        try {
            Class<?>[] initClasses = Stream.concat(Stream.of(context), Arrays.stream(initArgs))
                    .map((Function<Object, Class<?>>) Object::getClass)
                    .toArray(Class[]::new);

            Object[] actualInitArgs = new Object[1 + initArgs.length];
            actualInitArgs[0] = context;
            System.arraycopy(initArgs, 0, actualInitArgs, 1, initArgs.length);
            return contextWrapperClass.getConstructor(initClasses)
                    .newInstance(actualInitArgs);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
