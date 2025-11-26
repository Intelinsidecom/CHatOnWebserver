package org.jboss.netty.channel.socket;

import java.net.Socket;
import java.net.SocketException;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.DefaultChannelConfig;
import org.jboss.netty.util.internal.ConversionUtil;

/* loaded from: classes.dex */
public class DefaultSocketChannelConfig extends DefaultChannelConfig implements SocketChannelConfig {
    private final Socket socket;

    public DefaultSocketChannelConfig(Socket socket) {
        if (socket == null) {
            throw new NullPointerException("socket");
        }
        this.socket = socket;
    }

    @Override // org.jboss.netty.channel.DefaultChannelConfig
    public boolean setOption(String str, Object obj) throws SocketException {
        if (super.setOption(str, obj)) {
            return true;
        }
        if (str.equals("receiveBufferSize")) {
            setReceiveBufferSize(ConversionUtil.toInt(obj));
            return true;
        }
        if (str.equals("sendBufferSize")) {
            setSendBufferSize(ConversionUtil.toInt(obj));
            return true;
        }
        if (str.equals("tcpNoDelay")) {
            setTcpNoDelay(ConversionUtil.toBoolean(obj));
            return true;
        }
        if (str.equals("keepAlive")) {
            setKeepAlive(ConversionUtil.toBoolean(obj));
            return true;
        }
        if (str.equals("reuseAddress")) {
            setReuseAddress(ConversionUtil.toBoolean(obj));
            return true;
        }
        if (str.equals("soLinger")) {
            setSoLinger(ConversionUtil.toInt(obj));
            return true;
        }
        if (str.equals("trafficClass")) {
            setTrafficClass(ConversionUtil.toInt(obj));
            return true;
        }
        return false;
    }

    public void setKeepAlive(boolean z) throws SocketException {
        try {
            this.socket.setKeepAlive(z);
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public void setReceiveBufferSize(int i) throws SocketException {
        try {
            this.socket.setReceiveBufferSize(i);
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public void setReuseAddress(boolean z) throws SocketException {
        try {
            this.socket.setReuseAddress(z);
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public void setSendBufferSize(int i) throws SocketException {
        try {
            this.socket.setSendBufferSize(i);
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public void setSoLinger(int i) throws SocketException {
        try {
            if (i < 0) {
                this.socket.setSoLinger(false, 0);
            } else {
                this.socket.setSoLinger(true, i);
            }
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public void setTcpNoDelay(boolean z) throws SocketException {
        try {
            this.socket.setTcpNoDelay(z);
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }

    public void setTrafficClass(int i) throws SocketException {
        try {
            this.socket.setTrafficClass(i);
        } catch (SocketException e) {
            throw new ChannelException(e);
        }
    }
}
