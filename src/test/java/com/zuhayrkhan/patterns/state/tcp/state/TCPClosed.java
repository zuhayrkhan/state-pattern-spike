package com.zuhayrkhan.patterns.state.tcp.state;

import com.zuhayrkhan.patterns.state.tcp.model.stateful.TCPConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TCPClosed implements TCPState {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCPClosed.class);

    @Override
    public void activeOpen(TCPConnection tcpConnection) {
        LOGGER.info("activeOpen()");
        tcpConnection.setState(TCPEstablished.class);
    }

    @Override
    public void passiveOpen(TCPConnection tcpConnection) {
        LOGGER.info("passiveOpen()");
        tcpConnection.setState(TCPListen.class);
    }
}
