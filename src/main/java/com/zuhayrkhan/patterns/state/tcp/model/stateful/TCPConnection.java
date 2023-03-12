package com.zuhayrkhan.patterns.state.tcp.model.stateful;

import com.zuhayrkhan.patterns.state.support.state.Context;
import com.zuhayrkhan.patterns.state.support.state.ContextHolder;
import com.zuhayrkhan.patterns.state.tcp.model.stateless.TCPOctetStream;
import com.zuhayrkhan.patterns.state.tcp.state.TCPState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TCPConnection implements ContextHolder<TCPState> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCPConnection.class);

    private final Context<TCPState> context;

    public TCPConnection(Context<TCPState> context) {
        this.context = context;
    }

    @Override
    public Context<TCPState> getContext() {
        return context;
    }

    public void activeOpen() {
        getState().activeOpen(this);
    }

    public void passiveOpen() {
        getState().passiveOpen(this);
    }

    public void send() {
        getState().send(this);
    }

    public void close() {
        getState().close(this);
    }

    public void acknowledge() {
        getState().acknowledge(this);
    }

    public void synchronise() {
        getState().synchronise(this);
    }

    public void processOctetStream(TCPOctetStream tcpOctetStream) {
        LOGGER.info("processOctetStream({})", tcpOctetStream);
    }
}
