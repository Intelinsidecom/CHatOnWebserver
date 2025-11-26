package com.sec.chaton.network.pipeline;

import android.os.PowerManager;
import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.network.GpbTypeValue;
import com.sec.chaton.network.TcpContext;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.AesCipher;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;

/* loaded from: classes.dex */
public class TcpEnvelopeBicoder extends OneToOneBicoder {

    /* renamed from: a */
    protected TcpContext f2567a;

    /* renamed from: b */
    public Map f2568b = new Hashtable();

    /* renamed from: c */
    private PowerManager.WakeLock f2569c;

    /* renamed from: d */
    private AesCipher f2570d;

    /* renamed from: e */
    private long f2571e;

    public TcpEnvelopeBicoder(TcpContext tcpContext, PowerManager.WakeLock wakeLock) {
        this.f2570d = null;
        this.f2571e = Long.MAX_VALUE;
        this.f2567a = tcpContext;
        this.f2569c = wakeLock;
        this.f2570d = this.f2567a.m2790f();
        this.f2571e = this.f2567a.m2791g();
    }

    /* renamed from: a */
    private TcpEnvelope m2838a(Envelope envelope) {
        GeneratedMessageLite generatedMessageLiteM2725a;
        try {
            if ((envelope.m2827b() & 1) == 0) {
                try {
                    generatedMessageLiteM2725a = GpbTypeValue.m2725a(envelope.m2828c(), this.f2570d.m3472c(envelope.m2829d()));
                } catch (Exception e) {
                    ChatONLogWriter.m3500a((Throwable) e);
                    return null;
                }
            } else {
                generatedMessageLiteM2725a = GpbTypeValue.m2725a(envelope.m2828c(), envelope.m2829d());
            }
            long jM2724a = GpbTypeValue.m2724a(envelope.m2828c(), generatedMessageLiteM2725a);
            TcpEnvelope.Builder builderM2813a = new TcpEnvelope.Builder().m2815a(envelope.m2826a()).m2811a(envelope.m2828c()).m2813a(generatedMessageLiteM2725a);
            if (!GpbTypeValue.m2726a(envelope.m2828c())) {
                ChatONLogWriter.m3506b("Received msgID is " + jM2724a, getClass().getSimpleName());
                if (jM2724a == -1) {
                    builderM2813a.m2814a(this.f2567a.f2478m);
                    TcpEnvelope tcpEnvelopeM2816b = builderM2813a.m2816b();
                    tcpEnvelopeM2816b.m2803a(null, tcpEnvelopeM2816b);
                    return tcpEnvelopeM2816b;
                }
                TcpEnvelope tcpEnvelopeM2839a = m2839a(jM2724a);
                if (tcpEnvelopeM2839a == null) {
                    return null;
                }
                builderM2813a.m2814a(tcpEnvelopeM2839a.m2808e());
                TcpEnvelope tcpEnvelopeM2816b2 = builderM2813a.m2816b();
                tcpEnvelopeM2816b2.m2803a(tcpEnvelopeM2839a, tcpEnvelopeM2816b2);
                return tcpEnvelopeM2816b2;
            }
            try {
                switch (envelope.m2828c()) {
                    case 6:
                        if (this.f2567a != null) {
                            builderM2813a.m2814a(this.f2567a.f2476k);
                            break;
                        }
                        break;
                    case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                        if (this.f2567a != null) {
                            builderM2813a.m2814a(this.f2567a.f2475j);
                            break;
                        }
                        break;
                    case 14:
                        if (this.f2567a != null) {
                            builderM2813a.m2814a(this.f2567a.f2477l);
                            break;
                        }
                        break;
                    case 16:
                        if (this.f2567a != null) {
                            builderM2813a.m2814a(this.f2567a.f2474i);
                            break;
                        }
                        break;
                    default:
                        ChatONLogWriter.m3509d("Should not reach here.");
                        break;
                }
            } catch (Exception e2) {
                ChatONLogWriter.m3500a((Throwable) e2);
            }
            TcpEnvelope tcpEnvelopeM2816b3 = builderM2813a.m2816b();
            tcpEnvelopeM2816b3.m2803a(null, tcpEnvelopeM2816b3);
            return tcpEnvelopeM2816b3;
        } catch (Exception e3) {
            ChatONLogWriter.m3500a((Throwable) e3);
            return null;
        }
    }

    /* renamed from: a */
    public synchronized TcpEnvelope m2839a(long j) {
        TcpEnvelope tcpEnvelope;
        TcpEnvelope tcpEnvelope2 = (TcpEnvelope) this.f2568b.remove(Long.valueOf(j));
        if (tcpEnvelope2 == null) {
            ChatONLogWriter.m3506b(getClass().getSimpleName() + ".extractReqFormHistory() -> already handled error callback", getClass().getSimpleName());
            tcpEnvelope = null;
        } else if (tcpEnvelope2.m2807d() != j) {
            tcpEnvelope = null;
        } else if (tcpEnvelope2.m2809f()) {
            ChatONLogWriter.m3506b(getClass().getSimpleName() + ".extractReqFormHistory() hasExpired() -> try tcp error callback", getClass().getSimpleName());
            tcpEnvelope2.m2802a(tcpEnvelope2);
            tcpEnvelope = null;
        } else {
            int iM2805b = tcpEnvelope2.m2805b();
            tcpEnvelope = tcpEnvelope2;
            if (iM2805b == -1) {
                ChatONLogWriter.m3509d("Should not reach here.");
                tcpEnvelope = null;
            }
        }
        return tcpEnvelope;
    }

    @Override // com.sec.chaton.network.pipeline.OneToOneBicoder
    /* renamed from: a */
    protected Object mo2830a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        Envelope envelope;
        PowerManager.WakeLock wakeLock;
        if (this.f2569c != null) {
            this.f2569c.acquire();
        }
        try {
            TcpEnvelope tcpEnvelope = (TcpEnvelope) obj;
            if (GpbTypeValue.m2726a(tcpEnvelope.m2805b())) {
                m2841a(tcpEnvelope);
            }
            if (this.f2570d == null) {
                envelope = new Envelope(tcpEnvelope.m2800a(), 1, tcpEnvelope.m2805b(), tcpEnvelope.m2806c().toByteArray());
                if (this.f2569c != null) {
                    wakeLock = this.f2569c;
                    wakeLock.release();
                }
            } else {
                envelope = new Envelope(tcpEnvelope.m2800a(), 0, tcpEnvelope.m2805b(), this.f2570d.m3471b(tcpEnvelope.m2806c().toByteArray()));
                if (this.f2569c != null) {
                    wakeLock = this.f2569c;
                    wakeLock.release();
                }
            }
            return envelope;
        } catch (Throwable th) {
            if (this.f2569c != null) {
                this.f2569c.release();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public synchronized void m2840a() {
        for (TcpEnvelope tcpEnvelope : this.f2568b.values()) {
            ChatONLogWriter.m3506b("TcpEnvelopeBicoder.kickHistory() -> try tcp error callback", getClass().getSimpleName());
            tcpEnvelope.m2802a(tcpEnvelope);
        }
        this.f2568b.clear();
    }

    /* renamed from: a */
    public synchronized void m2841a(TcpEnvelope tcpEnvelope) {
        this.f2568b.put(Long.valueOf(tcpEnvelope.m2807d()), tcpEnvelope);
    }

    @Override // com.sec.chaton.network.pipeline.OneToOneBicoder
    /* renamed from: b */
    protected Object mo2831b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        try {
            return m2838a((Envelope) obj);
        } catch (Exception e) {
            ChatONLogWriter.m3500a((Throwable) e);
            return null;
        }
    }

    /* renamed from: b */
    public synchronized void m2842b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList(this.f2568b.values());
        int i = 0;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TcpEnvelope tcpEnvelope = (TcpEnvelope) it.next();
                if (tcpEnvelope != null && tcpEnvelope.m2804a(jElapsedRealtime)) {
                    i++;
                    this.f2568b.remove(Long.valueOf(tcpEnvelope.m2807d()));
                    ChatONLogWriter.m3506b("TcpEnvelopeBicoder.expiredCollector() -> try tcp error callback", getClass().getSimpleName());
                    tcpEnvelope.m2802a(tcpEnvelope);
                }
            }
        }
    }
}
