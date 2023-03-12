package com.zuhayrkhan.patterns.state.tcp.state;

import com.zuhayrkhan.patterns.state.tcp.model.stateful.TCPConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TCPListen implements TCPState {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCPListen.class);

    @Override
    public void send(TCPConnection tcpConnection) {
        LOGGER.info("send()");
        tcpConnection.setState(TCPEstablished.class);
    }

}
