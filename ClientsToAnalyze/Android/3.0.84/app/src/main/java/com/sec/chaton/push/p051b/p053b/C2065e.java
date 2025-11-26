package com.sec.chaton.push.p051b.p053b;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C2115g;
import com.sec.p013a.p014a.p015a.C0236ap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* compiled from: MessageDecoder.java */
/* renamed from: com.sec.chaton.push.b.b.e */
/* loaded from: classes.dex */
public class C2065e extends ReplayingDecoder<EnumC2067g> {

    /* renamed from: a */
    private static final String f7921a = C2065e.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f7922b;

    /* renamed from: c */
    private byte f7923c;

    /* renamed from: d */
    private byte f7924d;

    /* renamed from: e */
    private short f7925e;

    public C2065e(PowerManager.WakeLock wakeLock) {
        super(EnumC2067g.READ_RESERVED);
        this.f7922b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC2067g enumC2067g) {
        C2115g.m8359a(f7921a, "MessageDecoder.decode()");
        if (this.f7922b != null) {
            this.f7922b.acquire();
        }
        try {
            switch (enumC2067g) {
                case READ_RESERVED:
                    this.f7923c = channelBuffer.readByte();
                    checkpoint(EnumC2067g.READ_TYPE);
                case READ_TYPE:
                    this.f7924d = channelBuffer.readByte();
                    checkpoint(EnumC2067g.READ_LENGTH);
                case READ_LENGTH:
                    this.f7925e = channelBuffer.readShort();
                    checkpoint(EnumC2067g.READ_BODY);
                case READ_BODY:
                    MessageLite messageLite = (MessageLite) C0236ap.m795a(this.f7924d, channelBuffer.readBytes(this.f7925e).array());
                    checkpoint(EnumC2067g.READ_RESERVED);
                    return messageLite;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        } finally {
            if (this.f7922b != null) {
                this.f7922b.release();
            }
        }
    }
}
