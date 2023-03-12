package com.zuhayrkhan.patterns.state.tcp.state;

import com.zuhayrkhan.patterns.state.tcp.model.stateful.TCPConnection;
import com.zuhayrkhan.patterns.state.tcp.model.stateless.TCPOctetStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TCPEstablished implements TCPState {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCPEstablished.class);

    @Override
    public void transmit(TCPConnection tcpConnection, TCPOctetStream tcpOctetStream) {
        LOGGER.info("transmit()");
        tcpConnection.processOctetStream(tcpOctetStream);
    }

    @Override
    public void close(TCPConnection tcpConnection) {
        LOGGER.info("close()");
        tcpConnection.setState(TCPClosed.class);
    }

}
