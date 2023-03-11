package com.zuhayrkhan.patterns.state.support.state;

public interface ContextWrapper<STATE, LABEL> {

    Context<STATE, LABEL> getContext();

}
