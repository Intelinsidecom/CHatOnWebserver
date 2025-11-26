package org.jboss.netty.handler.codec.http;

import java.util.List;
import java.util.Map;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.frame.TooLongFrameException;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.util.CharsetUtil;

/* loaded from: classes.dex */
public class HttpChunkAggregator extends SimpleChannelUpstreamHandler {
    private static final ChannelBuffer CONTINUE = ChannelBuffers.copiedBuffer("HTTP/1.1 100 Continue\r\n\r\n", CharsetUtil.US_ASCII);
    private HttpMessage currentMessage;
    private final int maxContentLength;

    public HttpChunkAggregator(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxContentLength must be a positive integer: " + i);
        }
        this.maxContentLength = i;
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws TooLongFrameException {
        Object message = messageEvent.getMessage();
        HttpMessage httpMessage = this.currentMessage;
        if (message instanceof HttpMessage) {
            HttpMessage httpMessage2 = (HttpMessage) message;
            if (HttpHeaders.is100ContinueExpected(httpMessage2)) {
                Channels.write(channelHandlerContext, Channels.succeededFuture(channelHandlerContext.getChannel()), CONTINUE.duplicate());
            }
            if (httpMessage2.isChunked()) {
                List<String> headers = httpMessage2.getHeaders(HttpHeaders.Names.TRANSFER_ENCODING);
                headers.remove(HttpHeaders.Values.CHUNKED);
                if (headers.isEmpty()) {
                    httpMessage2.removeHeader(HttpHeaders.Names.TRANSFER_ENCODING);
                }
                httpMessage2.setChunked(false);
                httpMessage2.setContent(ChannelBuffers.dynamicBuffer(messageEvent.getChannel().getConfig().getBufferFactory()));
                this.currentMessage = httpMessage2;
                return;
            }
            this.currentMessage = null;
            channelHandlerContext.sendUpstream(messageEvent);
            return;
        }
        if (message instanceof HttpChunk) {
            if (httpMessage == null) {
                throw new IllegalStateException("received " + HttpChunk.class.getSimpleName() + " without " + HttpMessage.class.getSimpleName());
            }
            HttpChunk httpChunk = (HttpChunk) message;
            ChannelBuffer content = httpMessage.getContent();
            if (content.readableBytes() > this.maxContentLength - httpChunk.getContent().readableBytes()) {
                throw new TooLongFrameException("HTTP content length exceeded " + this.maxContentLength + " bytes.");
            }
            content.writeBytes(httpChunk.getContent());
            if (httpChunk.isLast()) {
                this.currentMessage = null;
                if (httpChunk instanceof HttpChunkTrailer) {
                    for (Map.Entry<String, String> entry : ((HttpChunkTrailer) httpChunk).getHeaders()) {
                        httpMessage.setHeader(entry.getKey(), entry.getValue());
                    }
                }
                httpMessage.setHeader("Content-Length", String.valueOf(content.readableBytes()));
                Channels.fireMessageReceived(channelHandlerContext, httpMessage, messageEvent.getRemoteAddress());
                return;
            }
            return;
        }
        channelHandlerContext.sendUpstream(messageEvent);
    }
}
