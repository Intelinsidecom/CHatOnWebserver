package com.sec.chaton.push.p041b.p043b;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C1139g;
import com.sec.p004a.p005a.p006a.C0072ap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* compiled from: MessageDecoder.java */
/* renamed from: com.sec.chaton.push.b.b.e */
/* loaded from: classes.dex */
public class C1092e extends ReplayingDecoder {

    /* renamed from: a */
    private static final String f4018a = C1092e.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f4019b;

    /* renamed from: c */
    private byte f4020c;

    /* renamed from: d */
    private byte f4021d;

    /* renamed from: e */
    private short f4022e;

    public C1092e(PowerManager.WakeLock wakeLock) {
        super(EnumC1094g.READ_RESERVED);
        this.f4019b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC1094g enumC1094g) {
        C1139g.m4308a(f4018a, "MessageDecoder.decode()");
        if (this.f4019b != null) {
            this.f4019b.acquire();
        }
        try {
            switch (enumC1094g) {
                case READ_RESERVED:
                    this.f4020c = channelBuffer.readByte();
                    checkpoint(EnumC1094g.READ_TYPE);
                case READ_TYPE:
                    this.f4021d = channelBuffer.readByte();
                    checkpoint(EnumC1094g.READ_LENGTH);
                case READ_LENGTH:
                    this.f4022e = channelBuffer.readShort();
                    checkpoint(EnumC1094g.READ_BODY);
                case READ_BODY:
                    MessageLite messageLite = (MessageLite) C0072ap.m283a(this.f4021d, channelBuffer.readBytes(this.f4022e).array());
                    checkpoint(EnumC1094g.READ_RESERVED);
                    return messageLite;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        } finally {
            if (this.f4019b != null) {
                this.f4019b.release();
            }
        }
    }
}
