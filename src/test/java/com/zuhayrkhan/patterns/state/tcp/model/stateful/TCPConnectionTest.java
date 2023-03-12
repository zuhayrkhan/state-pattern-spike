package com.zuhayrkhan.patterns.state.tcp.model.stateful;

import com.zuhayrkhan.patterns.state.tcp.model.stateless.TCPOctetStream;
import com.zuhayrkhan.patterns.state.tcp.state.TCPClosed;
import com.zuhayrkhan.patterns.state.tcp.state.TCPEstablished;
import com.zuhayrkhan.patterns.state.tcp.state.TCPListen;
import com.zuhayrkhan.patterns.state.tcp.state.TCPStateFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TCPConnectionTest {

    private final TCPStateFactory tcpStateFactory =
            new TCPStateFactory();

    private final TCPConnectionFactory tcpConnectionFactory =
            new TCPConnectionFactory(tcpStateFactory);

    @Test
    void correct_operation_of_TCPConnection() {

        TCPConnection tcpConnection = tcpConnectionFactory.createTCPConnection();

        tcpConnection.passiveOpen();

        assertThat(tcpConnection.getStateClass()).isEqualTo(TCPListen.class);

        tcpConnection.send();

        assertThat(tcpConnection.getStateClass()).isEqualTo(TCPEstablished.class);

        tcpConnection.processOctetStream(new TCPOctetStream());

        assertThat(tcpConnection.getStateClass()).isEqualTo(TCPEstablished.class);

        tcpConnection.close();

        assertThat(tcpConnection.getStateClass()).isEqualTo(TCPClosed.class);

    }

}