package com.zuhayrkhan.patterns.state.support.state;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class ContextWrapperFactory<STATE, LABEL,
        CONTEXT_WRAPPER extends ContextWrapper<STATE, LABEL>> {

    private final StateFactory<STATE, LABEL> stateFactory;

    private final LABEL initialLabel;

    private final Class<CONTEXT_WRAPPER> contextWrapperClass;

    protected ContextWrapperFactory(StateFactory<STATE, LABEL> stateFactory,
                                    LABEL initialLabel,
                                    Class<CONTEXT_WRAPPER> contextWrapperClass) {
        this.stateFactory = stateFactory;
        this.initialLabel = initialLabel;
        this.contextWrapperClass = contextWrapperClass;
    }

    protected CONTEXT_WRAPPER createContextWrapper(Object... initargs) {

        Context<STATE, LABEL> context = new Context<>(new StateRegistry<>(stateFactory),
                initialLabel
        );

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
