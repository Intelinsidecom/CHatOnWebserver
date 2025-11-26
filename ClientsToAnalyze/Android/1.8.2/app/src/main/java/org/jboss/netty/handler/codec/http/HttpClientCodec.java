package org.jboss.netty.handler.codec.http;

import java.util.Queue;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.handler.codec.http.HttpMessageDecoder;
import org.jboss.netty.util.internal.LinkedTransferQueue;

/* loaded from: classes.dex */
public class HttpClientCodec implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    private final HttpResponseDecoder decoder;
    volatile boolean done;
    private final HttpRequestEncoder encoder;
    final Queue queue;

    public HttpClientCodec() {
        this(4096, 8192, 8192);
    }

    public HttpClientCodec(int i, int i2, int i3) {
        this.queue = new LinkedTransferQueue();
        this.encoder = new Encoder();
        this.decoder = new Decoder(i, i2, i3);
    }

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        this.decoder.handleUpstream(channelHandlerContext, channelEvent);
    }

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        this.encoder.handleDownstream(channelHandlerContext, channelEvent);
    }

    final class Encoder extends HttpRequestEncoder {
        Encoder() {
        }

        @Override // org.jboss.netty.handler.codec.http.HttpMessageEncoder, org.jboss.netty.handler.codec.oneone.OneToOneEncoder
        protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
            if ((obj instanceof HttpRequest) && !HttpClientCodec.this.done) {
                HttpClientCodec.this.queue.offer(((HttpRequest) obj).getMethod());
            }
            return super.encode(channelHandlerContext, channel, obj);
        }
    }

    final class Decoder extends HttpResponseDecoder {
        Decoder(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jboss.netty.handler.codec.http.HttpMessageDecoder, org.jboss.netty.handler.codec.replay.ReplayingDecoder
        public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, HttpMessageDecoder.State state) {
            return HttpClientCodec.this.done ? channelBuffer.readBytes(actualReadableBytes()) : super.decode(channelHandlerContext, channel, channelBuffer, state);
        }

        @Override // org.jboss.netty.handler.codec.http.HttpMessageDecoder
        protected boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
            int code = ((HttpResponse) httpMessage).getStatus().getCode();
            if (code == 100) {
                return true;
            }
            HttpMethod httpMethod = (HttpMethod) HttpClientCodec.this.queue.poll();
            switch (httpMethod.getName().charAt(0)) {
                case 'C':
                    if (code == 200 && HttpMethod.CONNECT.equals(httpMethod)) {
                        HttpClientCodec.this.done = true;
                        HttpClientCodec.this.queue.clear();
                        return true;
                    }
                    break;
                case 'H':
                    if (HttpMethod.HEAD.equals(httpMethod)) {
                        return true;
                    }
                    break;
            }
            return super.isContentAlwaysEmpty(httpMessage);
        }
    }
}
