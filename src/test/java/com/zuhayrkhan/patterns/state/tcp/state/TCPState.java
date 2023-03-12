package com.zuhayrkhan.patterns.state.tcp.state;

import com.zuhayrkhan.patterns.state.tcp.model.stateful.TCPConnection;
import com.zuhayrkhan.patterns.state.tcp.model.stateless.TCPOctetStream;

public interface TCPState {

    default void transmit(TCPConnection tcpConnection, TCPOctetStream tcpOctetStream) {
        throw new IllegalStateException("transmit not appropriate in current state");
    }

    default void activeOpen(TCPConnection tcpConnection) {
        throw new IllegalStateException("activeOpen not appropriate in current state");
    }

    default void passiveOpen(TCPConnection tcpConnection) {
        throw new IllegalStateException("passiveOpen not appropriate in current state");
    }

    default void close(TCPConnection tcpConnection) {
        throw new IllegalStateException("close not appropriate in current state");
    }

    default void synchronise(TCPConnection tcpConnection) {
        throw new IllegalStateException("synchronise not appropriate in current state");
    }

    default void acknowledge(TCPConnection tcpConnection) {
        throw new IllegalStateException("acknowledge not appropriate in current state");
    }

    default void send(TCPConnection tcpConnection) {
        throw new IllegalStateException("send not appropriate in current state");
    }

}
