package com.sec.chaton.p037j.p041d;

import android.os.PowerManager;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* compiled from: StreamEnvelopeDecoder.java */
/* renamed from: com.sec.chaton.j.d.d */
/* loaded from: classes.dex */
public class C1570d extends ReplayingDecoder<EnumC1572f> {

    /* renamed from: a */
    private EnumC1572f f5826a;

    /* renamed from: b */
    private PowerManager.WakeLock f5827b;

    /* renamed from: c */
    private String f5828c;

    /* renamed from: d */
    private int f5829d;

    /* renamed from: e */
    private int f5830e;

    /* renamed from: f */
    private int f5831f;

    public C1570d(PowerManager.WakeLock wakeLock) {
        super(EnumC1572f.READ_UID);
        this.f5826a = EnumC1572f.READ_UID;
        this.f5828c = null;
        this.f5829d = 0;
        this.f5830e = 0;
        this.f5831f = 0;
        this.f5826a = getState();
        this.f5827b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC1572f enumC1572f) {
        if (this.f5827b != null) {
            this.f5827b.acquire();
        }
        try {
            switch (enumC1572f) {
                case READ_UID:
                    this.f5828c = new String(channelBuffer.readBytes(36).array(), "UTF-8");
                    checkpoint(EnumC1572f.READ_RESERVED);
                case READ_RESERVED:
                    this.f5829d = channelBuffer.readByte();
                    checkpoint(EnumC1572f.READ_TYPE);
                case READ_TYPE:
                    this.f5830e = channelBuffer.readByte();
                    checkpoint(EnumC1572f.READ_LENGTH);
                case READ_LENGTH:
                    this.f5831f = channelBuffer.readUnsignedShort();
                    checkpoint(EnumC1572f.READ_CONTENT);
                case READ_CONTENT:
                    ChannelBuffer bytes = channelBuffer.readBytes(this.f5831f);
                    checkpoint(this.f5826a);
                    return new C1567a(this.f5828c, this.f5829d, this.f5830e, bytes.array());
                default:
                    throw new Error("Should not reach here.");
            }
        } finally {
            if (this.f5827b != null) {
                this.f5827b.release();
            }
        }
    }
}
