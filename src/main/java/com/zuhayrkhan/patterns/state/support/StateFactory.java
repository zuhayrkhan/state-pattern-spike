package com.zuhayrkhan.patterns.state.support;

public interface StateFactory<STATE, LABEL> {

    STATE createState(LABEL label);

}
