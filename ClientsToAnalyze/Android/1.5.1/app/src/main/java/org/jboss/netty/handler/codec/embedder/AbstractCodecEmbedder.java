package org.jboss.netty.handler.codec.embedder;

import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Queue;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineException;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DefaultChannelPipeline;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class AbstractCodecEmbedder implements CodecEmbedder {
    private final Channel channel;
    private final ChannelPipeline pipeline;
    final Queue productQueue;
    private final EmbeddedChannelSink sink;

    final class EmbeddedChannelPipeline extends DefaultChannelPipeline {
        EmbeddedChannelPipeline() {
        }

        @Override // org.jboss.netty.channel.DefaultChannelPipeline
        protected void notifyHandlerException(ChannelEvent channelEvent, Throwable th) {
            Throwable cause = th;
            while ((cause instanceof ChannelPipelineException) && cause.getCause() != null) {
                cause = cause.getCause();
            }
            if (!(cause instanceof CodecEmbedderException)) {
                throw new CodecEmbedderException(cause);
            }
            throw ((CodecEmbedderException) cause);
        }
    }

    final class EmbeddedChannelSink implements ChannelSink, ChannelUpstreamHandler {
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !AbstractCodecEmbedder.class.desiredAssertionStatus();
        }

        EmbeddedChannelSink() {
        }

        private void handleEvent(ChannelEvent channelEvent) {
            if (!(channelEvent instanceof MessageEvent)) {
                if (channelEvent instanceof ExceptionEvent) {
                    throw new CodecEmbedderException(((ExceptionEvent) channelEvent).getCause());
                }
            } else {
                boolean zOffer = AbstractCodecEmbedder.this.productQueue.offer(((MessageEvent) channelEvent).getMessage());
                if (!$assertionsDisabled && !zOffer) {
                    throw new AssertionError();
                }
            }
        }

        @Override // org.jboss.netty.channel.ChannelSink
        public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
            handleEvent(channelEvent);
        }

        @Override // org.jboss.netty.channel.ChannelSink
        public void exceptionCaught(ChannelPipeline channelPipeline, ChannelEvent channelEvent, ChannelPipelineException channelPipelineException) {
            Throwable cause = channelPipelineException.getCause();
            if (cause == null) {
                cause = channelPipelineException;
            }
            throw new CodecEmbedderException(cause);
        }

        @Override // org.jboss.netty.channel.ChannelUpstreamHandler
        public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
            handleEvent(channelEvent);
        }
    }

    protected AbstractCodecEmbedder(ChannelBufferFactory channelBufferFactory, ChannelHandler... channelHandlerArr) {
        this(channelHandlerArr);
        getChannel().getConfig().setBufferFactory(channelBufferFactory);
    }

    protected AbstractCodecEmbedder(ChannelHandler... channelHandlerArr) {
        this.sink = new EmbeddedChannelSink();
        this.productQueue = new LinkedList();
        this.pipeline = new EmbeddedChannelPipeline();
        configurePipeline(channelHandlerArr);
        this.channel = new EmbeddedChannel(this.pipeline, this.sink);
        fireInitialEvents();
    }

    private void configurePipeline(ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr == null) {
            throw new NullPointerException("handlers");
        }
        if (channelHandlerArr.length == 0) {
            throw new IllegalArgumentException("handlers should contain at least one " + ChannelHandler.class.getSimpleName() + '.');
        }
        for (int i = 0; i < channelHandlerArr.length; i++) {
            if (channelHandlerArr[i] == null) {
                throw new NullPointerException("handlers[" + i + "]");
            }
            this.pipeline.addLast(String.valueOf(i), channelHandlerArr[i]);
        }
        this.pipeline.addLast("SINK", this.sink);
    }

    private void fireInitialEvents() {
        Channels.fireChannelOpen(this.channel);
        Channels.fireChannelBound(this.channel, this.channel.getLocalAddress());
        Channels.fireChannelConnected(this.channel, this.channel.getRemoteAddress());
    }

    @Override // org.jboss.netty.handler.codec.embedder.CodecEmbedder
    public boolean finish() {
        Channels.close(this.channel);
        Channels.fireChannelDisconnected(this.channel);
        Channels.fireChannelUnbound(this.channel);
        Channels.fireChannelClosed(this.channel);
        return !this.productQueue.isEmpty();
    }

    protected final Channel getChannel() {
        return this.channel;
    }

    protected final boolean isEmpty() {
        return this.productQueue.isEmpty();
    }

    @Override // org.jboss.netty.handler.codec.embedder.CodecEmbedder
    public final Object peek() {
        return this.productQueue.peek();
    }

    @Override // org.jboss.netty.handler.codec.embedder.CodecEmbedder
    public final Object poll() {
        return this.productQueue.poll();
    }

    @Override // org.jboss.netty.handler.codec.embedder.CodecEmbedder
    public final Object[] pollAll() {
        int size = size();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            Object objPoll = poll();
            if (objPoll == null) {
                throw new ConcurrentModificationException();
            }
            objArr[i] = objPoll;
        }
        return objArr;
    }

    @Override // org.jboss.netty.handler.codec.embedder.CodecEmbedder
    public final Object[] pollAll(Object[] objArr) {
        if (objArr == null) {
            throw new NullPointerException("a");
        }
        int size = size();
        Object[] objArr2 = objArr.length < size ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size) : objArr;
        int i = 0;
        while (true) {
            Object objPoll = poll();
            if (objPoll == null) {
                break;
            }
            objArr2[i] = objPoll;
            i++;
        }
        if (objArr2.length > size) {
            objArr2[size] = null;
        }
        return objArr2;
    }

    @Override // org.jboss.netty.handler.codec.embedder.CodecEmbedder
    public final int size() {
        return this.productQueue.size();
    }
}
