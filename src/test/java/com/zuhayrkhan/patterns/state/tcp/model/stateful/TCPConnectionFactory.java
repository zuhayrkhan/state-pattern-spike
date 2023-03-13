package com.zuhayrkhan.patterns.state.tcp.model.stateful;

import com.zuhayrkhan.patterns.state.support.state.ContextHolderFactory;
import com.zuhayrkhan.patterns.state.support.state.StateFactory;
import com.zuhayrkhan.patterns.state.tcp.state.TCPClosed;
import com.zuhayrkhan.patterns.state.tcp.state.TCPState;

public class TCPConnectionFactory extends ContextHolderFactory<TCPState, TCPConnection> {

    protected TCPConnectionFactory(StateFactory<TCPState> stateFactory) {
        super(stateFactory,
                TCPClosed.class,
                TCPConnection.class);
    }

    public TCPConnection createTCPConnection() {
        return new TCPConnection(createContext());
    }

}
