package com.sec.chaton.network.pipeline;

import android.os.PowerManager;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* loaded from: classes.dex */
public class StreamEnvelopeDecoder extends ReplayingDecoder {

    /* renamed from: a */
    private EnumC0350c f2554a;

    /* renamed from: b */
    private PowerManager.WakeLock f2555b;

    /* renamed from: c */
    private String f2556c;

    /* renamed from: d */
    private int f2557d;

    /* renamed from: e */
    private int f2558e;

    /* renamed from: f */
    private int f2559f;

    public StreamEnvelopeDecoder(PowerManager.WakeLock wakeLock) {
        super(EnumC0350c.READ_UID);
        this.f2554a = EnumC0350c.READ_UID;
        this.f2556c = null;
        this.f2557d = 0;
        this.f2558e = 0;
        this.f2559f = 0;
        this.f2554a = (EnumC0350c) getState();
        this.f2555b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC0350c enumC0350c) {
        if (this.f2555b != null) {
            this.f2555b.acquire();
        }
        try {
            switch (enumC0350c) {
                case READ_UID:
                    this.f2556c = new String(channelBuffer.readBytes(36).array(), "UTF-8");
                    checkpoint(EnumC0350c.READ_RESERVED);
                case READ_RESERVED:
                    this.f2557d = channelBuffer.readByte();
                    checkpoint(EnumC0350c.READ_TYPE);
                case READ_TYPE:
                    this.f2558e = channelBuffer.readByte();
                    checkpoint(EnumC0350c.READ_LENGTH);
                case READ_LENGTH:
                    this.f2559f = channelBuffer.readUnsignedShort();
                    checkpoint(EnumC0350c.READ_CONTENT);
                case READ_CONTENT:
                    ChannelBuffer bytes = channelBuffer.readBytes(this.f2559f);
                    checkpoint(this.f2554a);
                    return new Envelope(this.f2556c, this.f2557d, this.f2558e, bytes.array());
                default:
                    throw new Error("Should not reach here.");
            }
        } finally {
            if (this.f2555b != null) {
                this.f2555b.release();
            }
        }
    }
}
