package com.zuhayrkhan.patterns.state.tcp.state;

import com.zuhayrkhan.patterns.state.support.state.StateFactory;

public class TCPStateFactory implements StateFactory<TCPState> {

    @Override
    public TCPState createState(Class<? extends TCPState> state) {

        if (state == TCPClosed.class) {
            return new TCPClosed();
        }
        if (state == TCPEstablished.class) {
            return new TCPEstablished();
        }
        if (state == TCPListen.class) {
            return new TCPListen();
        }

        throw new IllegalArgumentException("Don't know how to create state for state:" + state);

    }

}
