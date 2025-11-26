package com.sec.chaton.push.util;

import com.google.protobuf.MessageLite;
import com.sec.p013a.p014a.p015a.C0221aa;
import com.sec.p013a.p014a.p015a.C0224ad;
import com.sec.p013a.p014a.p015a.C0227ag;
import com.sec.p013a.p014a.p015a.C0230aj;
import com.sec.p013a.p014a.p015a.C0233am;
import com.sec.p013a.p014a.p015a.C0238c;
import com.sec.p013a.p014a.p015a.C0241f;
import com.sec.p013a.p014a.p015a.C0244i;
import com.sec.p013a.p014a.p015a.C0247l;
import com.sec.p013a.p014a.p015a.C0250o;
import com.sec.p013a.p014a.p015a.C0253r;
import com.sec.p013a.p014a.p015a.C0256u;
import com.sec.p013a.p014a.p015a.C0259x;
import java.util.Iterator;
import java.util.Random;

/* compiled from: MessageUtil.java */
/* renamed from: com.sec.chaton.push.util.d */
/* loaded from: classes.dex */
public class C2112d {

    /* renamed from: a */
    private static Random f8041a = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static String m8342a(MessageLite messageLite) {
        Class<?> cls = messageLite.getClass();
        if (cls == C0227ag.class) {
            return m8345a((C0227ag) messageLite);
        }
        if (cls == C0224ad.class) {
            return m8344a((C0224ad) messageLite);
        }
        if (cls == C0247l.class) {
            return m8351a((C0247l) messageLite);
        }
        if (cls == C0244i.class) {
            return m8350a((C0244i) messageLite);
        }
        if (cls == C0233am.class) {
            return m8347a((C0233am) messageLite);
        }
        if (cls == C0230aj.class) {
            return m8346a((C0230aj) messageLite);
        }
        if (cls == C0241f.class) {
            return m8349a((C0241f) messageLite);
        }
        if (cls == C0238c.class) {
            return m8348a((C0238c) messageLite);
        }
        if (cls == C0221aa.class) {
            return m8343a((C0221aa) messageLite);
        }
        if (cls == C0259x.class) {
            return m8354a((C0259x) messageLite);
        }
        if (cls == C0256u.class) {
            return m8353a((C0256u) messageLite);
        }
        if (cls == C0250o.class) {
            return m8352a((C0250o) messageLite);
        }
        return "";
    }

    /* renamed from: a */
    private static String m8345a(C0227ag c0227ag) {
        return String.format("MessageType: %s\nDeviceToken: %s\nDeviceId: %s\nClientVersion: %s\nDeviceType: %s\n", c0227ag.getClass(), c0227ag.m690j(), c0227ag.m686f(), c0227ag.m684d(), c0227ag.m688h());
    }

    /* renamed from: a */
    private static String m8344a(C0224ad c0224ad) {
        return String.format("MessageType: %s\nDeviceToken: %s\nPingInterval: %s\nPrimaryIp: %s\nPrimaryPort: %s\nSecondaryIp: %s\nSecondaryPort: %s\nUserData: %s\n", c0224ad.getClass(), c0224ad.m632f(), Integer.valueOf(c0224ad.m642p()), c0224ad.m634h(), Integer.valueOf(c0224ad.m636j()), c0224ad.m638l(), Integer.valueOf(c0224ad.m640n()), c0224ad.m644r());
    }

    /* renamed from: a */
    private static String m8351a(C0247l c0247l) {
        return String.format("MessageType: %s\nAsyncId: %s\nDeviceToken: %s\n", c0247l.getClass(), Integer.valueOf(c0247l.m918d()), c0247l.m920f());
    }

    /* renamed from: a */
    private static String m8350a(C0244i c0244i) {
        return String.format("MessageType: %s\nAsyncId: %s\nResultCode: %s\nResultMsg: %s\n", c0244i.getClass(), Integer.valueOf(c0244i.m886d()), Integer.valueOf(c0244i.m888f()), c0244i.m890h());
    }

    /* renamed from: a */
    private static String m8347a(C0233am c0233am) {
        return String.format("MessageType: %s\nAsyncId: %s\nAppId: %s\nDeviceToken: %s\nUserData: %s\n", c0233am.getClass(), Integer.valueOf(c0233am.m769d()), c0233am.m773h(), c0233am.m771f(), c0233am.m775j());
    }

    /* renamed from: a */
    private static String m8346a(C0230aj c0230aj) {
        return String.format("MessageType: %s\nAsyncId: %s\nRegId: %s\nResultCode: %s\nResultMsg: %s\nUserData: %s\n", c0230aj.getClass(), Integer.valueOf(c0230aj.m727d()), c0230aj.m733j(), Integer.valueOf(c0230aj.m729f()), c0230aj.m731h(), c0230aj.m735l());
    }

    /* renamed from: a */
    private static String m8349a(C0241f c0241f) {
        return String.format("MessageType: %s\nAsyncId: %s\nRegId: %s\nDeviceToken: %s\nUserData: %s\n", c0241f.getClass(), Integer.valueOf(c0241f.m850d()), c0241f.m854h(), c0241f.m852f(), c0241f.m856j());
    }

    /* renamed from: a */
    private static String m8348a(C0238c c0238c) {
        return String.format("MessageType: %s\nAsyncId: %s\nResultCode: %s\nResultMsg: %s\nUserData: %s\n", c0238c.getClass(), Integer.valueOf(c0238c.m811d()), Integer.valueOf(c0238c.m813f()), c0238c.m815h(), c0238c.m817j());
    }

    /* renamed from: a */
    private static String m8343a(C0221aa c0221aa) {
        return String.format("MessageType: %s\nAsyncId: %s\nCreatedTime: %s\nInterval: %s\n", c0221aa.getClass(), Integer.valueOf(c0221aa.m589d()), Long.valueOf(c0221aa.m591f()), Integer.valueOf(c0221aa.m593h()));
    }

    /* renamed from: a */
    private static String m8354a(C0259x c0259x) {
        return String.format("MessageType: %s\nAsyncId: %s\nCreatedTime: %s\nDelta: %s\n", c0259x.getClass(), Integer.valueOf(c0259x.m1068d()), Long.valueOf(c0259x.m1070f()), Integer.valueOf(c0259x.m1072h()));
    }

    /* renamed from: a */
    private static String m8353a(C0256u c0256u) {
        StringBuffer stringBuffer = new StringBuffer();
        for (C0253r c0253r : c0256u.m1040c()) {
            stringBuffer.append(String.format("NotiId: %s\nAppId: %s\nReliableLevel: %s\nType: %s\nMessage: %s\nSender: %s\nAppData: %s\nTimeStamp: %s\nSessionInfo: %s\n ConnectionTerm: %s\n", c0253r.m990d(), c0253r.m992f(), Integer.valueOf(c0253r.m994h()), Integer.valueOf(c0253r.m996j()), c0253r.m1000n(), c0253r.m998l(), c0253r.m1002p(), Long.valueOf(c0253r.m1004r()), c0253r.m1008v(), Integer.valueOf(c0253r.m1006t())));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m8352a(C0250o c0250o) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("MessageType: %s\nDeviceToken: %s\n", c0250o.getClass(), c0250o.m948d()));
        Iterator<String> it = c0250o.m949e().iterator();
        while (it.hasNext()) {
            stringBuffer.append(String.format("Noti Ack Id: %s\n", it.next()));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static int m8341a() {
        return f8041a.nextInt();
    }
}
