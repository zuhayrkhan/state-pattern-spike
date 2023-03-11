package com.zuhayrkhan.patterns.state.support.state;

public interface StateFactory<STATE, LABEL> {

    STATE createState(LABEL label);

}
