package com.sec.chaton.push.util;

import com.google.protobuf.MessageLite;
import com.sec.p004a.p005a.p006a.C0066a;
import com.sec.p004a.p005a.p006a.C0069ac;
import com.sec.p004a.p005a.p006a.C0074ah;
import com.sec.p004a.p005a.p006a.C0076aj;
import com.sec.p004a.p005a.p006a.C0077ak;
import com.sec.p004a.p005a.p006a.C0084c;
import com.sec.p004a.p005a.p006a.C0089h;
import com.sec.p004a.p005a.p006a.C0090i;
import com.sec.p004a.p005a.p006a.C0092k;
import com.sec.p004a.p005a.p006a.C0094m;
import com.sec.p004a.p005a.p006a.C0096o;
import com.sec.p004a.p005a.p006a.C0103v;
import com.sec.p004a.p005a.p006a.C0104w;
import java.util.Iterator;
import java.util.Random;

/* compiled from: MessageUtil.java */
/* renamed from: com.sec.chaton.push.util.e */
/* loaded from: classes.dex */
public class C0919e {

    /* renamed from: a */
    private static Random f3114a = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static String m3621a(MessageLite messageLite) {
        Class<?> cls = messageLite.getClass();
        if (cls == C0096o.class) {
            return m3632a((C0096o) messageLite);
        }
        if (cls == C0069ac.class) {
            return m3623a((C0069ac) messageLite);
        }
        if (cls == C0092k.class) {
            return m3630a((C0092k) messageLite);
        }
        if (cls == C0084c.class) {
            return m3627a((C0084c) messageLite);
        }
        if (cls == C0066a.class) {
            return m3622a((C0066a) messageLite);
        }
        if (cls == C0089h.class) {
            return m3628a((C0089h) messageLite);
        }
        if (cls == C0074ah.class) {
            return m3624a((C0074ah) messageLite);
        }
        if (cls == C0090i.class) {
            return m3629a((C0090i) messageLite);
        }
        if (cls == C0104w.class) {
            return m3633a((C0104w) messageLite);
        }
        if (cls == C0094m.class) {
            return m3631a((C0094m) messageLite);
        }
        if (cls == C0077ak.class) {
            return m3626a((C0077ak) messageLite);
        }
        if (cls == C0076aj.class) {
            return m3625a((C0076aj) messageLite);
        }
        return "";
    }

    /* renamed from: a */
    private static String m3632a(C0096o c0096o) {
        return String.format("MessageType: %s\nDeviceToken: %s\nDeviceId: %s\nClientVersion: %s\nDeviceType: %s\n", c0096o.getClass(), c0096o.m479j(), c0096o.m475f(), c0096o.m473d(), c0096o.m477h());
    }

    /* renamed from: a */
    private static String m3623a(C0069ac c0069ac) {
        return String.format("MessageType: %s\nDeviceToken: %s\nPingInterval: %s\nPrimaryIp: %s\nPrimaryPort: %s\nSecondaryIp: %s\nSecondaryPort: %s\nUserData: %s\n", c0069ac.getClass(), c0069ac.m129f(), Integer.valueOf(c0069ac.m139p()), c0069ac.m131h(), Integer.valueOf(c0069ac.m133j()), c0069ac.m135l(), Integer.valueOf(c0069ac.m137n()), c0069ac.m141r());
    }

    /* renamed from: a */
    private static String m3630a(C0092k c0092k) {
        return String.format("MessageType: %s\nAsyncId: %s\nDeviceToken: %s\n", c0092k.getClass(), Integer.valueOf(c0092k.m404d()), c0092k.m406f());
    }

    /* renamed from: a */
    private static String m3627a(C0084c c0084c) {
        return String.format("MessageType: %s\nAsyncId: %s\nResultCode: %s\nResultMsg: %s\n", c0084c.getClass(), Integer.valueOf(c0084c.m339d()), Integer.valueOf(c0084c.m341f()), c0084c.m343h());
    }

    /* renamed from: a */
    private static String m3622a(C0066a c0066a) {
        return String.format("MessageType: %s\nAsyncId: %s\nAppId: %s\nDeviceToken: %s\nUserData: %s\n", c0066a.getClass(), Integer.valueOf(c0066a.m81d()), c0066a.m85h(), c0066a.m83f(), c0066a.m87j());
    }

    /* renamed from: a */
    private static String m3628a(C0089h c0089h) {
        return String.format("MessageType: %s\nAsyncId: %s\nRegId: %s\nResultCode: %s\nResultMsg: %s\nUserData: %s\n", c0089h.getClass(), Integer.valueOf(c0089h.m361d()), c0089h.m367j(), Integer.valueOf(c0089h.m363f()), c0089h.m365h(), c0089h.m369l());
    }

    /* renamed from: a */
    private static String m3624a(C0074ah c0074ah) {
        return String.format("MessageType: %s\nAsyncId: %s\nRegId: %s\nDeviceToken: %s\nUserData: %s\n", c0074ah.getClass(), Integer.valueOf(c0074ah.m226d()), c0074ah.m230h(), c0074ah.m228f(), c0074ah.m232j());
    }

    /* renamed from: a */
    private static String m3629a(C0090i c0090i) {
        return String.format("MessageType: %s\nAsyncId: %s\nResultCode: %s\nResultMsg: %s\nUserData: %s\n", c0090i.getClass(), Integer.valueOf(c0090i.m385d()), Integer.valueOf(c0090i.m387f()), c0090i.m389h(), c0090i.m391j());
    }

    /* renamed from: a */
    private static String m3633a(C0104w c0104w) {
        return String.format("MessageType: %s\nAsyncId: %s\nCreatedTime: %s\nInterval: %s\n", c0104w.getClass(), Integer.valueOf(c0104w.m555d()), Long.valueOf(c0104w.m557f()), Integer.valueOf(c0104w.m559h()));
    }

    /* renamed from: a */
    private static String m3631a(C0094m c0094m) {
        return String.format("MessageType: %s\nAsyncId: %s\nCreatedTime: %s\nDelta: %s\n", c0094m.getClass(), Integer.valueOf(c0094m.m435d()), Long.valueOf(c0094m.m437f()), Integer.valueOf(c0094m.m439h()));
    }

    /* renamed from: a */
    private static String m3626a(C0077ak c0077ak) {
        StringBuffer stringBuffer = new StringBuffer();
        for (C0103v c0103v : c0077ak.m272c()) {
            stringBuffer.append(String.format("NotiId: %s\nAppId: %s\nReliableLevel: %s\nType: %s\nMessage: %s\nSender: %s\nAppData: %s\nTimeStamp: %s\nSessionInfo: %s\n ConnectionTerm: %s\n", c0103v.m524d(), c0103v.m526f(), Integer.valueOf(c0103v.m528h()), Integer.valueOf(c0103v.m530j()), c0103v.m534n(), c0103v.m532l(), c0103v.m536p(), Long.valueOf(c0103v.m538r()), c0103v.m542v(), Integer.valueOf(c0103v.m540t())));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m3625a(C0076aj c0076aj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("MessageType: %s\nDeviceToken: %s\n", c0076aj.getClass(), c0076aj.m261d()));
        Iterator it = c0076aj.m262e().iterator();
        while (it.hasNext()) {
            stringBuffer.append(String.format("Noti Ack Id: %s\n", (String) it.next()));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static int m3620a() {
        return f3114a.nextInt();
    }
}
