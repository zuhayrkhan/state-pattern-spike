package com.zuhayrkhan.patterns.state.support.state;

import java.util.concurrent.atomic.AtomicReference;

public class Context<STATE, LABEL> {

    final StateRegistry<STATE, LABEL> stateRegistry;

    final AtomicReference<LABEL> labelRef;

    public Context(StateRegistry<STATE, LABEL> stateRegistry,
                   LABEL initialLabel) {
        this.stateRegistry = stateRegistry;
        labelRef = new AtomicReference<>(initialLabel);
    }

    public STATE getState() {
        return stateRegistry.getState(labelRef.get());
    }

    public void setLabel(LABEL label) {
        labelRef.set(label);
    }

    public LABEL getLabel() {
        return labelRef.get();
    }

}
