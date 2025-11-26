package com.sec.chaton.push.p035a.p036a;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C0921g;
import com.sec.p004a.p005a.p006a.C0068ab;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* compiled from: MessageDecoder.java */
/* renamed from: com.sec.chaton.push.a.a.d */
/* loaded from: classes.dex */
public class C0856d extends ReplayingDecoder {

    /* renamed from: a */
    private static final String f2966a = C0856d.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f2967b;

    /* renamed from: c */
    private byte f2968c;

    /* renamed from: d */
    private byte f2969d;

    /* renamed from: e */
    private short f2970e;

    public C0856d(PowerManager.WakeLock wakeLock) {
        super(EnumC0860h.READ_RESERVED);
        this.f2967b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC0860h enumC0860h) {
        C0921g.m3637a(f2966a, "MessageDecoder.decode()");
        if (this.f2967b != null) {
            this.f2967b.acquire();
        }
        try {
            switch (enumC0860h) {
                case READ_RESERVED:
                    this.f2968c = channelBuffer.readByte();
                    checkpoint(EnumC0860h.READ_TYPE);
                case READ_TYPE:
                    this.f2969d = channelBuffer.readByte();
                    checkpoint(EnumC0860h.READ_LENGTH);
                case READ_LENGTH:
                    this.f2970e = channelBuffer.readShort();
                    checkpoint(EnumC0860h.READ_BODY);
                case READ_BODY:
                    MessageLite messageLite = (MessageLite) C0068ab.m105a(this.f2969d, channelBuffer.readBytes(this.f2970e).array());
                    checkpoint(EnumC0860h.READ_RESERVED);
                    return messageLite;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        } finally {
            if (this.f2967b != null) {
                this.f2967b.release();
            }
        }
    }
}
