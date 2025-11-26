package org.jboss.netty.channel.socket.nio;

import java.net.DatagramSocket;
import java.util.Map;
import org.jboss.netty.channel.socket.DefaultDatagramChannelConfig;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.ConversionUtil;

/* loaded from: classes.dex */
class DefaultNioDatagramChannelConfig extends DefaultDatagramChannelConfig implements NioDatagramChannelConfig {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultNioDatagramChannelConfig.class);
    private volatile int writeBufferHighWaterMark;
    private volatile int writeBufferLowWaterMark;
    private volatile int writeSpinCount;

    DefaultNioDatagramChannelConfig(DatagramSocket datagramSocket) {
        super(datagramSocket);
        this.writeBufferHighWaterMark = 65536;
        this.writeBufferLowWaterMark = 32768;
        this.writeSpinCount = 16;
    }

    private void setWriteBufferHighWaterMark0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("writeBufferHighWaterMark: " + i);
        }
        this.writeBufferHighWaterMark = i;
    }

    private void setWriteBufferLowWaterMark0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("writeBufferLowWaterMark: " + i);
        }
        this.writeBufferLowWaterMark = i;
    }

    @Override // org.jboss.netty.channel.socket.nio.NioDatagramChannelConfig
    public int getWriteBufferHighWaterMark() {
        return this.writeBufferHighWaterMark;
    }

    @Override // org.jboss.netty.channel.socket.nio.NioDatagramChannelConfig
    public int getWriteBufferLowWaterMark() {
        return this.writeBufferLowWaterMark;
    }

    @Override // org.jboss.netty.channel.socket.nio.NioDatagramChannelConfig
    public int getWriteSpinCount() {
        return this.writeSpinCount;
    }

    @Override // org.jboss.netty.channel.socket.DefaultDatagramChannelConfig, org.jboss.netty.channel.DefaultChannelConfig, org.jboss.netty.channel.ChannelConfig
    public boolean setOption(String str, Object obj) {
        if (super.setOption(str, obj)) {
            return true;
        }
        if (str.equals("writeBufferHighWaterMark")) {
            setWriteBufferHighWaterMark0(ConversionUtil.toInt(obj));
        } else if (str.equals("writeBufferLowWaterMark")) {
            setWriteBufferLowWaterMark0(ConversionUtil.toInt(obj));
        } else {
            if (!str.equals("writeSpinCount")) {
                return false;
            }
            setWriteSpinCount(ConversionUtil.toInt(obj));
        }
        return true;
    }

    @Override // org.jboss.netty.channel.DefaultChannelConfig, org.jboss.netty.channel.ChannelConfig
    public void setOptions(Map map) {
        super.setOptions(map);
        if (getWriteBufferHighWaterMark() < getWriteBufferLowWaterMark()) {
            setWriteBufferLowWaterMark0(getWriteBufferHighWaterMark() >>> 1);
            logger.warn("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark; setting to the half of the writeBufferHighWaterMark.");
        }
    }

    @Override // org.jboss.netty.channel.socket.nio.NioDatagramChannelConfig
    public void setWriteBufferHighWaterMark(int i) {
        if (i < getWriteBufferLowWaterMark()) {
            throw new IllegalArgumentException("writeBufferHighWaterMark cannot be less than writeBufferLowWaterMark (" + getWriteBufferLowWaterMark() + "): " + i);
        }
        setWriteBufferHighWaterMark0(i);
    }

    @Override // org.jboss.netty.channel.socket.nio.NioDatagramChannelConfig
    public void setWriteBufferLowWaterMark(int i) {
        if (i > getWriteBufferHighWaterMark()) {
            throw new IllegalArgumentException("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark (" + getWriteBufferHighWaterMark() + "): " + i);
        }
        setWriteBufferLowWaterMark0(i);
    }

    @Override // org.jboss.netty.channel.socket.nio.NioDatagramChannelConfig
    public void setWriteSpinCount(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("writeSpinCount must be a positive integer.");
        }
        this.writeSpinCount = i;
    }
}
