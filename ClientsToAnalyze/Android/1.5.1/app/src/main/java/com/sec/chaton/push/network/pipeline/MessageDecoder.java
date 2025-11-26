package com.sec.chaton.push.network.pipeline;

import android.os.PowerManager;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* loaded from: classes.dex */
public class MessageDecoder extends ReplayingDecoder {

    /* renamed from: a */
    private static final String f2751a = MessageDecoder.class.getSimpleName();

    /* renamed from: b */
    private PowerManager.WakeLock f2752b;

    /* renamed from: c */
    private byte f2753c;

    /* renamed from: d */
    private byte f2754d;

    /* renamed from: e */
    private short f2755e;

    public MessageDecoder(PowerManager.WakeLock wakeLock) {
        super(EnumC0399e.READ_RESERVED);
        this.f2752b = wakeLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, EnumC0399e enumC0399e) {
        PushLog.m3025a(f2751a, "MessageDecoder.decode()");
        if (this.f2752b != null) {
            this.f2752b.acquire();
        }
        try {
            switch (C0395a.f2774a[enumC0399e.ordinal()]) {
                case 1:
                    this.f2753c = channelBuffer.readByte();
                    checkpoint(EnumC0399e.READ_TYPE);
                case 2:
                    this.f2754d = channelBuffer.readByte();
                    checkpoint(EnumC0399e.READ_LENGTH);
                case 3:
                    this.f2755e = channelBuffer.readShort();
                    checkpoint(EnumC0399e.READ_BODY);
                case 4:
                    MessageLite messageLite = (MessageLite) MsgFrontendCommon.newMessageClass(this.f2754d, channelBuffer.readBytes(this.f2755e).array());
                    checkpoint(EnumC0399e.READ_RESERVED);
                    return messageLite;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        } finally {
            if (this.f2752b != null) {
                this.f2752b.release();
            }
        }
    }
}
