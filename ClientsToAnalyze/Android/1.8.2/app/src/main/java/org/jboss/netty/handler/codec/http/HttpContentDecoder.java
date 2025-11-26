package org.jboss.netty.handler.codec.http;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.embedder.DecoderEmbedder;

/* loaded from: classes.dex */
public abstract class HttpContentDecoder extends SimpleChannelUpstreamHandler {
    private DecoderEmbedder decoder;

    protected abstract DecoderEmbedder newContentDecoder(String str);

    protected HttpContentDecoder() {
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        String strTrim;
        Object message = messageEvent.getMessage();
        if ((message instanceof HttpResponse) && ((HttpResponse) message).getStatus().getCode() == 100) {
            channelHandlerContext.sendUpstream(messageEvent);
            return;
        }
        if (message instanceof HttpMessage) {
            HttpMessage httpMessage = (HttpMessage) message;
            this.decoder = null;
            String header = httpMessage.getHeader("Content-Encoding");
            if (header != null) {
                strTrim = header.trim();
            } else {
                strTrim = "identity";
            }
            if (httpMessage.isChunked() || httpMessage.getContent().readable()) {
                DecoderEmbedder decoderEmbedderNewContentDecoder = newContentDecoder(strTrim);
                this.decoder = decoderEmbedderNewContentDecoder;
                if (decoderEmbedderNewContentDecoder != null) {
                    httpMessage.setHeader("Content-Encoding", getTargetContentEncoding(strTrim));
                    if (!httpMessage.isChunked()) {
                        ChannelBuffer channelBufferWrappedBuffer = ChannelBuffers.wrappedBuffer(decode(httpMessage.getContent()), finishDecode());
                        httpMessage.setContent(channelBufferWrappedBuffer);
                        if (httpMessage.containsHeader("Content-Length")) {
                            httpMessage.setHeader("Content-Length", Integer.toString(channelBufferWrappedBuffer.readableBytes()));
                        }
                    }
                }
            }
            channelHandlerContext.sendUpstream(messageEvent);
            return;
        }
        if (message instanceof HttpChunk) {
            HttpChunk httpChunk = (HttpChunk) message;
            ChannelBuffer content = httpChunk.getContent();
            if (this.decoder != null) {
                if (!httpChunk.isLast()) {
                    ChannelBuffer channelBufferDecode = decode(content);
                    if (channelBufferDecode.readable()) {
                        httpChunk.setContent(channelBufferDecode);
                        channelHandlerContext.sendUpstream(messageEvent);
                        return;
                    }
                    return;
                }
                ChannelBuffer channelBufferFinishDecode = finishDecode();
                if (channelBufferFinishDecode.readable()) {
                    Channels.fireMessageReceived(channelHandlerContext, new DefaultHttpChunk(channelBufferFinishDecode), messageEvent.getRemoteAddress());
                }
                channelHandlerContext.sendUpstream(messageEvent);
                return;
            }
            channelHandlerContext.sendUpstream(messageEvent);
            return;
        }
        channelHandlerContext.sendUpstream(messageEvent);
    }

    protected String getTargetContentEncoding(String str) {
        return "identity";
    }

    private ChannelBuffer decode(ChannelBuffer channelBuffer) {
        this.decoder.offer(channelBuffer);
        return ChannelBuffers.wrappedBuffer((ChannelBuffer[]) this.decoder.pollAll(new ChannelBuffer[this.decoder.size()]));
    }

    private ChannelBuffer finishDecode() {
        ChannelBuffer channelBufferWrappedBuffer;
        if (this.decoder.finish()) {
            channelBufferWrappedBuffer = ChannelBuffers.wrappedBuffer((ChannelBuffer[]) this.decoder.pollAll(new ChannelBuffer[this.decoder.size()]));
        } else {
            channelBufferWrappedBuffer = ChannelBuffers.EMPTY_BUFFER;
        }
        this.decoder = null;
        return channelBufferWrappedBuffer;
    }
}
