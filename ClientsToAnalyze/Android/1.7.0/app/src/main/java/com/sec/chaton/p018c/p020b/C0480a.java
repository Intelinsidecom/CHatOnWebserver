package com.sec.chaton.p018c.p020b;

import android.os.PowerManager;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* compiled from: StreamEnvelopeDecoder.java */
/* renamed from: com.sec.chaton.c.b.a */
/* loaded from: classes.dex */
public class C0480a extends ReplayingDecoder {

    /* renamed from: a */
    private EnumC0489j f1543a;

    /* renamed from: b */
    private PowerManager.WakeLock f1544b;

    /* renamed from: c */
    private String f1545c;

    /* renamed from: d */
    private int f1546d;

    /* renamed from: e */
    private int f1547e;

    /* renamed from: f */
    private int f1548f;

    public C0480a(PowerManager.WakeLock wakeLock) {
        super(EnumC0489j.READ_UID);
        this.f1543a = EnumC0489j.READ_UID;
        this.f1545c = null;
        this.f1546d = 0;
        this.f1547e = 0;
        this.f1548f = 0;
        this.f1543a = (EnumC0489j) getState();
        this.f1544b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC0489j enumC0489j) {
        if (this.f1544b != null) {
            this.f1544b.acquire();
        }
        try {
            switch (enumC0489j) {
                case READ_UID:
                    this.f1545c = new String(channelBuffer.readBytes(36).array(), "UTF-8");
                    checkpoint(EnumC0489j.READ_RESERVED);
                case READ_RESERVED:
                    this.f1546d = channelBuffer.readByte();
                    checkpoint(EnumC0489j.READ_TYPE);
                case READ_TYPE:
                    this.f1547e = channelBuffer.readByte();
                    checkpoint(EnumC0489j.READ_LENGTH);
                case READ_LENGTH:
                    this.f1548f = channelBuffer.readUnsignedShort();
                    checkpoint(EnumC0489j.READ_CONTENT);
                case READ_CONTENT:
                    ChannelBuffer bytes = channelBuffer.readBytes(this.f1548f);
                    checkpoint(this.f1543a);
                    return new C0488i(this.f1545c, this.f1546d, this.f1547e, bytes.array());
                default:
                    throw new Error("Should not reach here.");
            }
        } finally {
            if (this.f1544b != null) {
                this.f1544b.release();
            }
        }
    }
}
