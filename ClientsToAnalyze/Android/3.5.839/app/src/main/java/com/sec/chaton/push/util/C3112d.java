package com.sec.chaton.push.util;

import com.google.protobuf.MessageLite;
import com.sec.p043a.p044a.p045a.C0734aa;
import com.sec.p043a.p044a.p045a.C0737ad;
import com.sec.p043a.p044a.p045a.C0740ag;
import com.sec.p043a.p044a.p045a.C0743aj;
import com.sec.p043a.p044a.p045a.C0746am;
import com.sec.p043a.p044a.p045a.C0751c;
import com.sec.p043a.p044a.p045a.C0754f;
import com.sec.p043a.p044a.p045a.C0757i;
import com.sec.p043a.p044a.p045a.C0760l;
import com.sec.p043a.p044a.p045a.C0763o;
import com.sec.p043a.p044a.p045a.C0766r;
import com.sec.p043a.p044a.p045a.C0769u;
import com.sec.p043a.p044a.p045a.C0772x;
import java.util.Iterator;
import java.util.Random;

/* compiled from: MessageUtil.java */
/* renamed from: com.sec.chaton.push.util.d */
/* loaded from: classes.dex */
public class C3112d {

    /* renamed from: a */
    private static Random f11451a = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static String m12684a(MessageLite messageLite) {
        Class<?> cls = messageLite.getClass();
        if (cls == C0740ag.class) {
            return m12687a((C0740ag) messageLite);
        }
        if (cls == C0737ad.class) {
            return m12686a((C0737ad) messageLite);
        }
        if (cls == C0760l.class) {
            return m12693a((C0760l) messageLite);
        }
        if (cls == C0757i.class) {
            return m12692a((C0757i) messageLite);
        }
        if (cls == C0746am.class) {
            return m12689a((C0746am) messageLite);
        }
        if (cls == C0743aj.class) {
            return m12688a((C0743aj) messageLite);
        }
        if (cls == C0754f.class) {
            return m12691a((C0754f) messageLite);
        }
        if (cls == C0751c.class) {
            return m12690a((C0751c) messageLite);
        }
        if (cls == C0734aa.class) {
            return m12685a((C0734aa) messageLite);
        }
        if (cls == C0772x.class) {
            return m12696a((C0772x) messageLite);
        }
        if (cls == C0769u.class) {
            return m12695a((C0769u) messageLite);
        }
        if (cls == C0763o.class) {
            return m12694a((C0763o) messageLite);
        }
        return "";
    }

    /* renamed from: a */
    private static String m12687a(C0740ag c0740ag) {
        return String.format("MessageType: %s\nDeviceToken: %s\nDeviceId: %s\nClientVersion: %s\nDeviceType: %s\n", c0740ag.getClass(), c0740ag.m2422j(), c0740ag.m2418f(), c0740ag.m2416d(), c0740ag.m2420h());
    }

    /* renamed from: a */
    private static String m12686a(C0737ad c0737ad) {
        return String.format("MessageType: %s\nDeviceToken: %s\nPingInterval: %s\nPrimaryIp: %s\nPrimaryPort: %s\nSecondaryIp: %s\nSecondaryPort: %s\nUserData: %s\n", c0737ad.getClass(), c0737ad.m2364f(), Integer.valueOf(c0737ad.m2374p()), c0737ad.m2366h(), Integer.valueOf(c0737ad.m2368j()), c0737ad.m2370l(), Integer.valueOf(c0737ad.m2372n()), c0737ad.m2376r());
    }

    /* renamed from: a */
    private static String m12693a(C0760l c0760l) {
        return String.format("MessageType: %s\nAsyncId: %s\nDeviceToken: %s\n", c0760l.getClass(), Integer.valueOf(c0760l.m2650d()), c0760l.m2652f());
    }

    /* renamed from: a */
    private static String m12692a(C0757i c0757i) {
        return String.format("MessageType: %s\nAsyncId: %s\nResultCode: %s\nResultMsg: %s\n", c0757i.getClass(), Integer.valueOf(c0757i.m2618d()), Integer.valueOf(c0757i.m2620f()), c0757i.m2622h());
    }

    /* renamed from: a */
    private static String m12689a(C0746am c0746am) {
        return String.format("MessageType: %s\nAsyncId: %s\nAppId: %s\nDeviceToken: %s\nUserData: %s\n", c0746am.getClass(), Integer.valueOf(c0746am.m2501d()), c0746am.m2505h(), c0746am.m2503f(), c0746am.m2507j());
    }

    /* renamed from: a */
    private static String m12688a(C0743aj c0743aj) {
        return String.format("MessageType: %s\nAsyncId: %s\nRegId: %s\nResultCode: %s\nResultMsg: %s\nUserData: %s\n", c0743aj.getClass(), Integer.valueOf(c0743aj.m2459d()), c0743aj.m2465j(), Integer.valueOf(c0743aj.m2461f()), c0743aj.m2463h(), c0743aj.m2467l());
    }

    /* renamed from: a */
    private static String m12691a(C0754f c0754f) {
        return String.format("MessageType: %s\nAsyncId: %s\nRegId: %s\nDeviceToken: %s\nUserData: %s\n", c0754f.getClass(), Integer.valueOf(c0754f.m2582d()), c0754f.m2586h(), c0754f.m2584f(), c0754f.m2588j());
    }

    /* renamed from: a */
    private static String m12690a(C0751c c0751c) {
        return String.format("MessageType: %s\nAsyncId: %s\nResultCode: %s\nResultMsg: %s\nUserData: %s\n", c0751c.getClass(), Integer.valueOf(c0751c.m2543d()), Integer.valueOf(c0751c.m2545f()), c0751c.m2547h(), c0751c.m2549j());
    }

    /* renamed from: a */
    private static String m12685a(C0734aa c0734aa) {
        return String.format("MessageType: %s\nAsyncId: %s\nCreatedTime: %s\nInterval: %s\n", c0734aa.getClass(), Integer.valueOf(c0734aa.m2321d()), Long.valueOf(c0734aa.m2323f()), Integer.valueOf(c0734aa.m2325h()));
    }

    /* renamed from: a */
    private static String m12696a(C0772x c0772x) {
        return String.format("MessageType: %s\nAsyncId: %s\nCreatedTime: %s\nDelta: %s\n", c0772x.getClass(), Integer.valueOf(c0772x.m2800d()), Long.valueOf(c0772x.m2802f()), Integer.valueOf(c0772x.m2804h()));
    }

    /* renamed from: a */
    private static String m12695a(C0769u c0769u) {
        StringBuffer stringBuffer = new StringBuffer();
        for (C0766r c0766r : c0769u.m2772c()) {
            stringBuffer.append(String.format("NotiId: %s\nAppId: %s\nReliableLevel: %s\nType: %s\nMessage: %s\nSender: %s\nAppData: %s\nTimeStamp: %s\nSessionInfo: %s\n ConnectionTerm: %s\n", c0766r.m2722d(), c0766r.m2724f(), Integer.valueOf(c0766r.m2726h()), Integer.valueOf(c0766r.m2728j()), c0766r.m2732n(), c0766r.m2730l(), c0766r.m2734p(), Long.valueOf(c0766r.m2736r()), c0766r.m2740v(), Integer.valueOf(c0766r.m2738t())));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m12694a(C0763o c0763o) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("MessageType: %s\nDeviceToken: %s\n", c0763o.getClass(), c0763o.m2680d()));
        Iterator<String> it = c0763o.m2681e().iterator();
        while (it.hasNext()) {
            stringBuffer.append(String.format("Noti Ack Id: %s\n", it.next()));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static int m12683a() {
        return f11451a.nextInt();
    }
}
