package com.sec.chaton.p022h.p026d;

import android.os.PowerManager;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* compiled from: StreamEnvelopeDecoder.java */
/* renamed from: com.sec.chaton.h.d.d */
/* loaded from: classes.dex */
public class C0788d extends ReplayingDecoder {

    /* renamed from: a */
    private EnumC0790f f2893a;

    /* renamed from: b */
    private PowerManager.WakeLock f2894b;

    /* renamed from: c */
    private String f2895c;

    /* renamed from: d */
    private int f2896d;

    /* renamed from: e */
    private int f2897e;

    /* renamed from: f */
    private int f2898f;

    public C0788d(PowerManager.WakeLock wakeLock) {
        super(EnumC0790f.READ_UID);
        this.f2893a = EnumC0790f.READ_UID;
        this.f2895c = null;
        this.f2896d = 0;
        this.f2897e = 0;
        this.f2898f = 0;
        this.f2893a = (EnumC0790f) getState();
        this.f2894b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC0790f enumC0790f) {
        if (this.f2894b != null) {
            this.f2894b.acquire();
        }
        try {
            switch (enumC0790f) {
                case READ_UID:
                    this.f2895c = new String(channelBuffer.readBytes(36).array(), "UTF-8");
                    checkpoint(EnumC0790f.READ_RESERVED);
                case READ_RESERVED:
                    this.f2896d = channelBuffer.readByte();
                    checkpoint(EnumC0790f.READ_TYPE);
                case READ_TYPE:
                    this.f2897e = channelBuffer.readByte();
                    checkpoint(EnumC0790f.READ_LENGTH);
                case READ_LENGTH:
                    this.f2898f = channelBuffer.readUnsignedShort();
                    checkpoint(EnumC0790f.READ_CONTENT);
                case READ_CONTENT:
                    ChannelBuffer bytes = channelBuffer.readBytes(this.f2898f);
                    checkpoint(this.f2893a);
                    return new C0785a(this.f2895c, this.f2896d, this.f2897e, bytes.array());
                default:
                    throw new Error("Should not reach here.");
            }
        } finally {
            if (this.f2894b != null) {
                this.f2894b.release();
            }
        }
    }
}
