package com.sec.chaton.push.p051b.p053b;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C2115g;
import com.sec.p013a.p014a.p015a.C0236ap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* compiled from: MessageEncoder.java */
/* renamed from: com.sec.chaton.push.b.b.h */
/* loaded from: classes.dex */
public class C2068h extends OneToOneEncoder {

    /* renamed from: a */
    private static final String f7932a = C2068h.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f7933b;

    public C2068h(PowerManager.WakeLock wakeLock) {
        this.f7933b = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        C2115g.m8359a(f7932a, "MessageEncoder.encode()");
        if (this.f7933b != null) {
            this.f7933b.acquire();
        }
        try {
            byte[] byteArray = ((MessageLite) obj).toByteArray();
            ChannelBuffer channelBufferBuffer = ChannelBuffers.buffer(byteArray.length + 4);
            channelBufferBuffer.writeByte(0);
            channelBufferBuffer.writeByte(C0236ap.m794a(obj));
            channelBufferBuffer.writeShort(byteArray.length);
            channelBufferBuffer.writeBytes(byteArray);
            return channelBufferBuffer;
        } finally {
            if (this.f7933b != null) {
                this.f7933b.release();
            }
        }
    }
}
