package com.sec.chaton.push.util;

import com.google.protobuf.MessageLite;
import com.sec.p004a.p005a.p006a.C0057aa;
import com.sec.p004a.p005a.p006a.C0060ad;
import com.sec.p004a.p005a.p006a.C0063ag;
import com.sec.p004a.p005a.p006a.C0066aj;
import com.sec.p004a.p005a.p006a.C0069am;
import com.sec.p004a.p005a.p006a.C0074c;
import com.sec.p004a.p005a.p006a.C0077f;
import com.sec.p004a.p005a.p006a.C0080i;
import com.sec.p004a.p005a.p006a.C0083l;
import com.sec.p004a.p005a.p006a.C0086o;
import com.sec.p004a.p005a.p006a.C0089r;
import com.sec.p004a.p005a.p006a.C0092u;
import com.sec.p004a.p005a.p006a.C0095x;
import java.util.Iterator;
import java.util.Random;

/* compiled from: MessageUtil.java */
/* renamed from: com.sec.chaton.push.util.d */
/* loaded from: classes.dex */
public class C1136d {

    /* renamed from: a */
    private static Random f4135a = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static String m4291a(MessageLite messageLite) {
        Class<?> cls = messageLite.getClass();
        if (cls == C0063ag.class) {
            return m4294a((C0063ag) messageLite);
        }
        if (cls == C0060ad.class) {
            return m4293a((C0060ad) messageLite);
        }
        if (cls == C0083l.class) {
            return m4300a((C0083l) messageLite);
        }
        if (cls == C0080i.class) {
            return m4299a((C0080i) messageLite);
        }
        if (cls == C0069am.class) {
            return m4296a((C0069am) messageLite);
        }
        if (cls == C0066aj.class) {
            return m4295a((C0066aj) messageLite);
        }
        if (cls == C0077f.class) {
            return m4298a((C0077f) messageLite);
        }
        if (cls == C0074c.class) {
            return m4297a((C0074c) messageLite);
        }
        if (cls == C0057aa.class) {
            return m4292a((C0057aa) messageLite);
        }
        if (cls == C0095x.class) {
            return m4303a((C0095x) messageLite);
        }
        if (cls == C0092u.class) {
            return m4302a((C0092u) messageLite);
        }
        if (cls == C0086o.class) {
            return m4301a((C0086o) messageLite);
        }
        return "";
    }

    /* renamed from: a */
    private static String m4294a(C0063ag c0063ag) {
        return String.format("MessageType: %s\nDeviceToken: %s\nDeviceId: %s\nClientVersion: %s\nDeviceType: %s\n", c0063ag.getClass(), c0063ag.m178j(), c0063ag.m174f(), c0063ag.m172d(), c0063ag.m176h());
    }

    /* renamed from: a */
    private static String m4293a(C0060ad c0060ad) {
        return String.format("MessageType: %s\nDeviceToken: %s\nPingInterval: %s\nPrimaryIp: %s\nPrimaryPort: %s\nSecondaryIp: %s\nSecondaryPort: %s\nUserData: %s\n", c0060ad.getClass(), c0060ad.m120f(), Integer.valueOf(c0060ad.m130p()), c0060ad.m122h(), Integer.valueOf(c0060ad.m124j()), c0060ad.m126l(), Integer.valueOf(c0060ad.m128n()), c0060ad.m132r());
    }

    /* renamed from: a */
    private static String m4300a(C0083l c0083l) {
        return String.format("MessageType: %s\nAsyncId: %s\nDeviceToken: %s\n", c0083l.getClass(), Integer.valueOf(c0083l.m406d()), c0083l.m408f());
    }

    /* renamed from: a */
    private static String m4299a(C0080i c0080i) {
        return String.format("MessageType: %s\nAsyncId: %s\nResultCode: %s\nResultMsg: %s\n", c0080i.getClass(), Integer.valueOf(c0080i.m374d()), Integer.valueOf(c0080i.m376f()), c0080i.m378h());
    }

    /* renamed from: a */
    private static String m4296a(C0069am c0069am) {
        return String.format("MessageType: %s\nAsyncId: %s\nAppId: %s\nDeviceToken: %s\nUserData: %s\n", c0069am.getClass(), Integer.valueOf(c0069am.m257d()), c0069am.m261h(), c0069am.m259f(), c0069am.m263j());
    }

    /* renamed from: a */
    private static String m4295a(C0066aj c0066aj) {
        return String.format("MessageType: %s\nAsyncId: %s\nRegId: %s\nResultCode: %s\nResultMsg: %s\nUserData: %s\n", c0066aj.getClass(), Integer.valueOf(c0066aj.m215d()), c0066aj.m221j(), Integer.valueOf(c0066aj.m217f()), c0066aj.m219h(), c0066aj.m223l());
    }

    /* renamed from: a */
    private static String m4298a(C0077f c0077f) {
        return String.format("MessageType: %s\nAsyncId: %s\nRegId: %s\nDeviceToken: %s\nUserData: %s\n", c0077f.getClass(), Integer.valueOf(c0077f.m338d()), c0077f.m342h(), c0077f.m340f(), c0077f.m344j());
    }

    /* renamed from: a */
    private static String m4297a(C0074c c0074c) {
        return String.format("MessageType: %s\nAsyncId: %s\nResultCode: %s\nResultMsg: %s\nUserData: %s\n", c0074c.getClass(), Integer.valueOf(c0074c.m299d()), Integer.valueOf(c0074c.m301f()), c0074c.m303h(), c0074c.m305j());
    }

    /* renamed from: a */
    private static String m4292a(C0057aa c0057aa) {
        return String.format("MessageType: %s\nAsyncId: %s\nCreatedTime: %s\nInterval: %s\n", c0057aa.getClass(), Integer.valueOf(c0057aa.m77d()), Long.valueOf(c0057aa.m79f()), Integer.valueOf(c0057aa.m81h()));
    }

    /* renamed from: a */
    private static String m4303a(C0095x c0095x) {
        return String.format("MessageType: %s\nAsyncId: %s\nCreatedTime: %s\nDelta: %s\n", c0095x.getClass(), Integer.valueOf(c0095x.m556d()), Long.valueOf(c0095x.m558f()), Integer.valueOf(c0095x.m560h()));
    }

    /* renamed from: a */
    private static String m4302a(C0092u c0092u) {
        StringBuffer stringBuffer = new StringBuffer();
        for (C0089r c0089r : c0092u.m528c()) {
            stringBuffer.append(String.format("NotiId: %s\nAppId: %s\nReliableLevel: %s\nType: %s\nMessage: %s\nSender: %s\nAppData: %s\nTimeStamp: %s\nSessionInfo: %s\n ConnectionTerm: %s\n", c0089r.m478d(), c0089r.m480f(), Integer.valueOf(c0089r.m482h()), Integer.valueOf(c0089r.m484j()), c0089r.m488n(), c0089r.m486l(), c0089r.m490p(), Long.valueOf(c0089r.m492r()), c0089r.m496v(), Integer.valueOf(c0089r.m494t())));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m4301a(C0086o c0086o) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("MessageType: %s\nDeviceToken: %s\n", c0086o.getClass(), c0086o.m436d()));
        Iterator it = c0086o.m437e().iterator();
        while (it.hasNext()) {
            stringBuffer.append(String.format("Noti Ack Id: %s\n", (String) it.next()));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static int m4290a() {
        return f4135a.nextInt();
    }
}
