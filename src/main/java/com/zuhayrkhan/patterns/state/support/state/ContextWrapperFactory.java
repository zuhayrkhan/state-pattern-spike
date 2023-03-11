package com.zuhayrkhan.patterns.state.support.state;

import java.util.function.Function;
import java.util.function.Supplier;

public interface ContextWrapperFactory<STATE, LABEL,
        CONTEXT_WRAPPER extends ContextWrapper<STATE, LABEL>> {

    Supplier<StateFactory<STATE, LABEL>> stateFactoryCreator();

    LABEL initialLabel();

    Function<Context<STATE, LABEL>, CONTEXT_WRAPPER> contextWrapperCreator(Object... initargs);

    default CONTEXT_WRAPPER createContextWrapper(Object... initargs) {
        Context<STATE, LABEL> context = new Context<>(new StateRegistry<>(stateFactoryCreator().get()),
                initialLabel()
        );
        CONTEXT_WRAPPER contextWrapper = contextWrapperCreator(initargs).apply(
                context
        );
        return contextWrapper;
    }

}
