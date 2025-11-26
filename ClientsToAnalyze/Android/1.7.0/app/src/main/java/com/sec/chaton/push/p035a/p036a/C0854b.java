package com.sec.chaton.push.p035a.p036a;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C0921g;
import com.sec.p004a.p005a.p006a.C0068ab;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/* compiled from: MessageEncoder.java */
/* renamed from: com.sec.chaton.push.a.a.b */
/* loaded from: classes.dex */
public class C0854b extends OneToOneEncoder {

    /* renamed from: a */
    private static final String f2964a = C0854b.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f2965b;

    public C0854b(PowerManager.WakeLock wakeLock) {
        this.f2965b = wakeLock;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        C0921g.m3637a(f2964a, "MessageEncoder.encode()");
        if (this.f2965b != null) {
            this.f2965b.acquire();
        }
        try {
            byte[] byteArray = ((MessageLite) obj).toByteArray();
            ChannelBuffer channelBufferBuffer = ChannelBuffers.buffer(byteArray.length + 4);
            channelBufferBuffer.writeByte(0);
            channelBufferBuffer.writeByte(C0068ab.m104a(obj));
            channelBufferBuffer.writeShort(byteArray.length);
            channelBufferBuffer.writeBytes(byteArray);
            return channelBufferBuffer;
        } finally {
            if (this.f2965b != null) {
                this.f2965b.release();
            }
        }
    }
}
