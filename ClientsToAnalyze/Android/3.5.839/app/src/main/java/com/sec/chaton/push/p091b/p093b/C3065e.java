package com.sec.chaton.push.p091b.p093b;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C3115g;
import com.sec.p043a.p044a.p045a.C0749ap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* compiled from: MessageDecoder.java */
/* renamed from: com.sec.chaton.push.b.b.e */
/* loaded from: classes.dex */
public class C3065e extends ReplayingDecoder<EnumC3067g> {

    /* renamed from: a */
    private static final String f11331a = C3065e.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f11332b;

    /* renamed from: c */
    private byte f11333c;

    /* renamed from: d */
    private byte f11334d;

    /* renamed from: e */
    private short f11335e;

    public C3065e(PowerManager.WakeLock wakeLock) {
        super(EnumC3067g.READ_RESERVED);
        this.f11332b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC3067g enumC3067g) {
        C3115g.m12701a(f11331a, "MessageDecoder.decode()");
        if (this.f11332b != null) {
            this.f11332b.acquire();
        }
        try {
            switch (enumC3067g) {
                case READ_RESERVED:
                    this.f11333c = channelBuffer.readByte();
                    checkpoint(EnumC3067g.READ_TYPE);
                case READ_TYPE:
                    this.f11334d = channelBuffer.readByte();
                    checkpoint(EnumC3067g.READ_LENGTH);
                case READ_LENGTH:
                    this.f11335e = channelBuffer.readShort();
                    checkpoint(EnumC3067g.READ_BODY);
                case READ_BODY:
                    MessageLite messageLite = (MessageLite) C0749ap.m2527a(this.f11334d, channelBuffer.readBytes(this.f11335e).array());
                    checkpoint(EnumC3067g.READ_RESERVED);
                    return messageLite;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        } finally {
            if (this.f11332b != null) {
                this.f11332b.release();
            }
        }
    }
}
