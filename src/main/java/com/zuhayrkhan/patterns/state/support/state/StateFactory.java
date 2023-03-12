package com.zuhayrkhan.patterns.state.support.state;

public interface StateFactory<STATE> {

    STATE createState(Class<? extends STATE> state);

}
