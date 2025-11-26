package com.sec.chaton.push.p091b.p093b;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C3115g;
import com.sec.p043a.p044a.p045a.C0749ap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* compiled from: MessageEncoder.java */
/* renamed from: com.sec.chaton.push.b.b.h */
/* loaded from: classes.dex */
public class C3068h extends OneToOneEncoder {

    /* renamed from: a */
    private static final String f11342a = C3068h.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f11343b;

    public C3068h(PowerManager.WakeLock wakeLock) {
        this.f11343b = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        C3115g.m12701a(f11342a, "MessageEncoder.encode()");
        if (this.f11343b != null) {
            this.f11343b.acquire();
        }
        try {
            byte[] byteArray = ((MessageLite) obj).toByteArray();
            ChannelBuffer channelBufferBuffer = ChannelBuffers.buffer(byteArray.length + 4);
            channelBufferBuffer.writeByte(0);
            channelBufferBuffer.writeByte(C0749ap.m2526a(obj));
            channelBufferBuffer.writeShort(byteArray.length);
            channelBufferBuffer.writeBytes(byteArray);
            return channelBufferBuffer;
        } finally {
            if (this.f11343b != null) {
                this.f11343b.release();
            }
        }
    }
}
