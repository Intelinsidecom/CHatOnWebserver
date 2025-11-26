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

    static {
        $assertionsDisabled = !HttpContentEncoder.class.desiredAssertionStatus();
    }

    protected HttpContentEncoder() {
    }

    private ChannelBuffer encode(ChannelBuffer channelBuffer) {
        this.encoder.offer(channelBuffer);
        return ChannelBuffers.wrappedBuffer((ChannelBuffer[]) this.encoder.pollAll(new ChannelBuffer[this.encoder.size()]));
    }

    private ChannelBuffer finishEncode() {
        ChannelBuffer channelBufferWrappedBuffer = this.encoder.finish() ? ChannelBuffers.wrappedBuffer((ChannelBuffer[]) this.encoder.pollAll(new ChannelBuffer[this.encoder.size()])) : ChannelBuffers.EMPTY_BUFFER;
        this.encoder = null;
        return channelBufferWrappedBuffer;
    }

    protected abstract String getTargetContentEncoding(String str);

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

    protected abstract EncoderEmbedder newContentEncoder(String str);

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
            String str = (String) this.acceptEncodingQueue.poll();
            if (str == null) {
                throw new IllegalStateException("cannot send more responses than requests");
            }
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
            channelHandlerContext.sendDownstream(messageEvent);
            return;
        }
        if (!(message instanceof HttpChunk)) {
            channelHandlerContext.sendDownstream(messageEvent);
            return;
        }
        HttpChunk httpChunk = (HttpChunk) message;
        ChannelBuffer content = httpChunk.getContent();
        if (this.encoder == null) {
            channelHandlerContext.sendDownstream(messageEvent);
            return;
        }
        if (httpChunk.isLast()) {
            ChannelBuffer channelBufferFinishEncode = finishEncode();
            if (channelBufferFinishEncode.readable()) {
                Channels.write(channelHandlerContext, Channels.succeededFuture(messageEvent.getChannel()), new DefaultHttpChunk(channelBufferFinishEncode), messageEvent.getRemoteAddress());
            }
            channelHandlerContext.sendDownstream(messageEvent);
            return;
        }
        ChannelBuffer channelBufferEncode = encode(content);
        if (channelBufferEncode.readable()) {
            httpChunk.setContent(channelBufferEncode);
            channelHandlerContext.sendDownstream(messageEvent);
        }
    }
}
