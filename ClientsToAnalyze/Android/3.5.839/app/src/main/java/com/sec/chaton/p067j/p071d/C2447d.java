package com.sec.chaton.p067j.p071d;

import android.os.PowerManager;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* compiled from: StreamEnvelopeDecoder.java */
/* renamed from: com.sec.chaton.j.d.d */
/* loaded from: classes.dex */
public class C2447d extends ReplayingDecoder<EnumC2449f> {

    /* renamed from: a */
    private EnumC2449f f8770a;

    /* renamed from: b */
    private PowerManager.WakeLock f8771b;

    /* renamed from: c */
    private String f8772c;

    /* renamed from: d */
    private int f8773d;

    /* renamed from: e */
    private int f8774e;

    /* renamed from: f */
    private int f8775f;

    public C2447d(PowerManager.WakeLock wakeLock) {
        super(EnumC2449f.READ_UID);
        this.f8770a = EnumC2449f.READ_UID;
        this.f8772c = null;
        this.f8773d = 0;
        this.f8774e = 0;
        this.f8775f = 0;
        this.f8770a = getState();
        this.f8771b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC2449f enumC2449f) {
        if (this.f8771b != null) {
            this.f8771b.acquire();
        }
        try {
            switch (enumC2449f) {
                case READ_UID:
                    this.f8772c = new String(channelBuffer.readBytes(36).array(), "UTF-8");
                    checkpoint(EnumC2449f.READ_RESERVED);
                case READ_RESERVED:
                    this.f8773d = channelBuffer.readByte();
                    checkpoint(EnumC2449f.READ_TYPE);
                case READ_TYPE:
                    this.f8774e = channelBuffer.readByte();
                    checkpoint(EnumC2449f.READ_LENGTH);
                case READ_LENGTH:
                    this.f8775f = channelBuffer.readInt();
                    checkpoint(EnumC2449f.READ_CONTENT);
                case READ_CONTENT:
                    ChannelBuffer bytes = channelBuffer.readBytes(this.f8775f);
                    checkpoint(this.f8770a);
                    return new C2444a(this.f8772c, this.f8773d, this.f8774e, bytes.array());
                default:
                    throw new Error("Should not reach here.");
            }
        } finally {
            if (this.f8771b != null) {
                this.f8771b.release();
            }
        }
    }
}
