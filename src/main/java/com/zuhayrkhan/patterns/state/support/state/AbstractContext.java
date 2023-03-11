package com.zuhayrkhan.patterns.state.support.state;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractContext<STATE, LABEL> {

    private final AtomicReference<LABEL> labelRef;

    private final StateRegistry<STATE, LABEL> stateRegistry;

    protected AbstractContext(final StateRegistry<STATE, LABEL> stateRegistry,
                              final LABEL initialLabel) {
        labelRef = new AtomicReference<>(initialLabel);
        this.stateRegistry = stateRegistry;
    }

    protected STATE getState() {
        return stateRegistry.getState(labelRef.get());
    }

    public void setLabel(LABEL label) {
        labelRef.set(label);
    }

    public LABEL getLabel() {
        return labelRef.get();
    }

}
