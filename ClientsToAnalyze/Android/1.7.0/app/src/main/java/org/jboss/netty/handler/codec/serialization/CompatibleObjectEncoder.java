package org.jboss.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicReference;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* loaded from: classes.dex */
public class CompatibleObjectEncoder extends OneToOneEncoder {
    private final AtomicReference buffer;
    private volatile ObjectOutputStream oout;
    private final int resetInterval;
    private int writtenObjects;

    public CompatibleObjectEncoder() {
        this(16);
    }

    public CompatibleObjectEncoder(int i) {
        this.buffer = new AtomicReference();
        if (i < 0) {
            throw new IllegalArgumentException("resetInterval: " + i);
        }
        this.resetInterval = i;
    }

    protected ObjectOutputStream newObjectOutputStream(OutputStream outputStream) {
        return new ObjectOutputStream(outputStream);
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws IOException {
        ChannelBuffer channelBufferBuffer = buffer(channelHandlerContext);
        ObjectOutputStream objectOutputStream = this.oout;
        if (this.resetInterval != 0) {
            this.writtenObjects++;
            if (this.writtenObjects % this.resetInterval == 0) {
                objectOutputStream.reset();
                channelBufferBuffer.discardReadBytes();
            }
        }
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return channelBufferBuffer.readBytes(channelBufferBuffer.readableBytes());
    }

    private ChannelBuffer buffer(ChannelHandlerContext channelHandlerContext) {
        ChannelBuffer channelBuffer = (ChannelBuffer) this.buffer.get();
        if (channelBuffer == null) {
            ChannelBuffer channelBufferDynamicBuffer = ChannelBuffers.dynamicBuffer(channelHandlerContext.getChannel().getConfig().getBufferFactory());
            if (this.buffer.compareAndSet(null, channelBufferDynamicBuffer)) {
                try {
                    this.oout = newObjectOutputStream(new ChannelBufferOutputStream(channelBufferDynamicBuffer));
                    return channelBufferDynamicBuffer;
                } catch (Throwable th) {
                    this.oout = null;
                    throw th;
                }
            }
            return (ChannelBuffer) this.buffer.get();
        }
        return channelBuffer;
    }
}
