package org.jboss.netty.handler.codec.http;

import java.util.Queue;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.handler.codec.embedder.EncoderEmbedder;
import org.jboss.netty.util.internal.LinkedTransferQueue;

/* loaded from: classes.dex */
public abstract class HttpContentEncoder extends SimpleChannelHandler {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Queue acceptEncodingQueue = new LinkedTransferQueue();
    private volatile EncoderEmbedder encoder;

    protected abstract String getTargetContentEncoding(String str);

    protected abstract EncoderEmbedder newContentEncoder(String str);

    static {
        $assertionsDisabled = !HttpContentEncoder.class.desiredAssertionStatus();
    }

    protected HttpContentEncoder() {
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        Object message = messageEvent.getMessage();
        if (!(message instanceof HttpMessage)) {
            channelHandlerContext.sendUpstream(messageEvent);
            return;
        }
        String header = ((HttpMessage) message).getHeader("Accept-Encoding");
        if (header == null) {
            header = "identity";
        }
        boolean zOffer = this.acceptEncodingQueue.offer(header);
        if (!$assertionsDisabled && !zOffer) {
            throw new AssertionError();
        }
        channelHandlerContext.sendUpstream(messageEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        Object message = messageEvent.getMessage();
        if ((message instanceof HttpResponse) && ((HttpResponse) message).getStatus().getCode() == 100) {
            channelHandlerContext.sendDownstream(messageEvent);
            return;
        }
        if (message instanceof HttpMessage) {
            HttpMessage httpMessage = (HttpMessage) message;
            this.encoder = null;
            String header = httpMessage.getHeader("Content-Encoding");
            if (header != null && !"identity".equalsIgnoreCase(header)) {
                channelHandlerContext.sendDownstream(messageEvent);
                return;
            }
            String str = (String) this.acceptEncodingQueue.poll();
            if (str == null) {
                throw new IllegalStateException("cannot send more responses than requests");
            }
            if (httpMessage.isChunked() || httpMessage.getContent().readable()) {
                EncoderEmbedder encoderEmbedderNewContentEncoder = newContentEncoder(str);
                this.encoder = encoderEmbedderNewContentEncoder;
                if (encoderEmbedderNewContentEncoder != null) {
                    httpMessage.setHeader("Content-Encoding", getTargetContentEncoding(str));
                    if (!httpMessage.isChunked()) {
                        ChannelBuffer channelBufferWrappedBuffer = ChannelBuffers.wrappedBuffer(encode(httpMessage.getContent()), finishEncode());
                        httpMessage.setContent(channelBufferWrappedBuffer);
                        if (httpMessage.containsHeader("Content-Length")) {
                            httpMessage.setHeader("Content-Length", Integer.toString(channelBufferWrappedBuffer.readableBytes()));
                        }
                    }
                }
            }
            channelHandlerContext.sendDownstream(messageEvent);
            return;
        }
        if (message instanceof HttpChunk) {
            HttpChunk httpChunk = (HttpChunk) message;
            ChannelBuffer content = httpChunk.getContent();
            if (this.encoder != null) {
                if (!httpChunk.isLast()) {
                    ChannelBuffer channelBufferEncode = encode(content);
                    if (channelBufferEncode.readable()) {
                        httpChunk.setContent(channelBufferEncode);
                        channelHandlerContext.sendDownstream(messageEvent);
                        return;
                    }
                    return;
                }
                ChannelBuffer channelBufferFinishEncode = finishEncode();
                if (channelBufferFinishEncode.readable()) {
                    Channels.write(channelHandlerContext, Channels.succeededFuture(messageEvent.getChannel()), new DefaultHttpChunk(channelBufferFinishEncode), messageEvent.getRemoteAddress());
                }
                channelHandlerContext.sendDownstream(messageEvent);
                return;
            }
            channelHandlerContext.sendDownstream(messageEvent);
            return;
        }
        channelHandlerContext.sendDownstream(messageEvent);
    }

    private ChannelBuffer encode(ChannelBuffer channelBuffer) {
        this.encoder.offer(channelBuffer);
        return ChannelBuffers.wrappedBuffer((ChannelBuffer[]) this.encoder.pollAll(new ChannelBuffer[this.encoder.size()]));
    }

    private ChannelBuffer finishEncode() {
        ChannelBuffer channelBufferWrappedBuffer;
        if (this.encoder.finish()) {
            channelBufferWrappedBuffer = ChannelBuffers.wrappedBuffer((ChannelBuffer[]) this.encoder.pollAll(new ChannelBuffer[this.encoder.size()]));
        } else {
            channelBufferWrappedBuffer = ChannelBuffers.EMPTY_BUFFER;
        }
        this.encoder = null;
        return channelBufferWrappedBuffer;
    }
}
