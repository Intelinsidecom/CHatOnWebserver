package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0229at;
import com.sec.chaton.chat.C0494bh;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.p030a.p031a.C0911a;
import com.sec.chaton.p007a.C0118ak;
import com.sec.chaton.p007a.C0182i;
import com.sec.chaton.p007a.C0188o;
import com.sec.chaton.p015d.p016a.C0547ao;
import com.sec.chaton.p015d.p016a.C0563bd;
import com.sec.chaton.p015d.p016a.C0565bf;
import com.sec.chaton.p015d.p016a.C0566bg;
import com.sec.chaton.p015d.p016a.C0590f;
import com.sec.chaton.p015d.p016a.C0591g;
import com.sec.chaton.p015d.p016a.C0592h;
import com.sec.chaton.p015d.p016a.C0596l;
import com.sec.chaton.p015d.p016a.C0601q;
import com.sec.chaton.p015d.p016a.C0602r;
import com.sec.chaton.p015d.p016a.C0606v;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p022h.C0769aa;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0805o;
import com.sec.chaton.p022h.C0810t;
import com.sec.chaton.p022h.C0816z;
import com.sec.chaton.p022h.InterfaceC0807q;
import com.sec.chaton.p022h.p023a.C0765a;
import com.sec.chaton.p022h.p023a.C0766b;
import com.sec.chaton.p022h.p023a.C0767c;
import com.sec.chaton.p022h.p023a.C0768d;
import com.sec.chaton.p022h.p025c.C0779c;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1771c;
import com.sec.chaton.util.C1786r;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MessageControl.java */
/* renamed from: com.sec.chaton.d.k */
/* loaded from: classes.dex */
public class C0639k implements InterfaceC0807q {

    /* renamed from: m */
    private static HashMap f2481m = new HashMap();

    /* renamed from: t */
    private static HandlerThread f2482t = null;

    /* renamed from: a */
    C0805o f2483a;

    /* renamed from: f */
    private Handler f2488f;

    /* renamed from: g */
    private String f2489g;

    /* renamed from: h */
    private C0816z f2490h;

    /* renamed from: i */
    private ChatFragment f2491i;

    /* renamed from: k */
    private String f2493k;

    /* renamed from: p */
    private String f2497p;

    /* renamed from: q */
    private EnumC0695j f2498q;

    /* renamed from: j */
    private boolean f2492j = false;

    /* renamed from: l */
    private boolean f2494l = false;

    /* renamed from: b */
    public boolean f2484b = true;

    /* renamed from: c */
    public Map f2485c = new HashMap();

    /* renamed from: d */
    public Map f2486d = new HashMap();

    /* renamed from: n */
    private Map f2495n = new HashMap();

    /* renamed from: o */
    private boolean f2496o = false;

    /* renamed from: r */
    private ArrayList f2499r = new ArrayList();

    /* renamed from: u */
    private Handler f2501u = new HandlerC0640l(this, m2913b().getLooper());

    /* renamed from: v */
    private Handler f2502v = new HandlerC0641m(this);

    /* renamed from: e */
    InterfaceC0667k f2487e = new C0642n(this);

    /* renamed from: w */
    private Handler f2503w = new HandlerC0643o(this, m2913b().getLooper());

    /* renamed from: s */
    private C0666j f2500s = new C0666j(GlobalApplication.m3260b().getContentResolver(), this.f2487e);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2907a(int i, int i2, int i3, Object obj, long j) {
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = i;
        messageObtain.arg2 = i2;
        messageObtain.what = i3;
        messageObtain.obj = obj;
        this.f2488f.sendMessage(messageObtain);
    }

    /* renamed from: a */
    public static void m2906a() {
        if (f2482t == null) {
            f2482t = new HandlerThread("MessageControl");
            f2482t.start();
        } else if (!f2482t.isAlive()) {
            f2482t.start();
        }
    }

    /* renamed from: b */
    public static HandlerThread m2913b() {
        return f2482t;
    }

    /* renamed from: a */
    public void m2940a(String str) {
        this.f2497p = str;
    }

    public C0639k(Handler handler, String str, EnumC0695j enumC0695j) {
        this.f2488f = handler;
        this.f2489g = str;
        this.f2493k = str;
        this.f2498q = enumC0695j;
        this.f2483a = new C0805o(this.f2488f, this);
    }

    /* renamed from: a */
    public static synchronized C0639k m2904a(Handler handler, String str, EnumC0695j enumC0695j) {
        if (!f2481m.containsKey(str)) {
            f2481m.put(str, new C0639k(handler, str, enumC0695j));
        } else {
            ((C0639k) f2481m.get(str)).f2488f = handler;
            ((C0639k) f2481m.get(str)).f2489g = str;
            ((C0639k) f2481m.get(str)).f2493k = str;
            ((C0639k) f2481m.get(str)).f2483a = new C0805o(handler, (InterfaceC0807q) f2481m.get(str));
        }
        return (C0639k) f2481m.get(str);
    }

    /* renamed from: b */
    public static synchronized C0639k m2914b(String str) {
        return f2481m != null ? (C0639k) f2481m.get(str) : null;
    }

    /* renamed from: c */
    public static synchronized void m2917c() {
        Iterator it = new ArrayList(f2481m.values()).iterator();
        while (it.hasNext()) {
            C0639k c0639k = (C0639k) it.next();
            if (c0639k != null) {
                c0639k.m2953e();
            }
        }
    }

    /* renamed from: d */
    public void m2952d() {
        C0767c.m3275a(this.f2490h, this.f2483a);
        C0766b.m3274a(this.f2490h, this.f2483a);
        C0768d.m3277a(this.f2490h, this.f2483a);
        C0765a.m3273a(this.f2490h, this.f2483a);
        this.f2490h.f3007m = this.f2483a;
    }

    /* renamed from: a */
    public void m2941a(String str, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String[] strArr, String str2) {
        C1786r.m6061b("initChatRoom", getClass().getSimpleName());
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0563bd(c0623am.m2822c(), str, enumC0699n, enumC0695j, strArr, str2));
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        c0623am.m2824e();
    }

    /* renamed from: a */
    public boolean m2945a(EnumC0695j enumC0695j, String str, Long l, String str2, String str3) {
        Long lValueOf = Long.valueOf(C1735ar.m5918a());
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0590f(c0623am.m2822c(), enumC0695j, str3, str, lValueOf.longValue(), str2));
        if (enumC0695j != EnumC0695j.BROADCAST) {
            c0623am.m2820a(EnumC0627aq.NetTask, new C0547ao(c0623am.m2822c(), null, this.f2489g));
        }
        c0623am.m2824e();
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        return true;
    }

    /* renamed from: a */
    public boolean m2946a(EnumC0695j enumC0695j, String str, Long l, String str2, String str3, long j, boolean z) {
        if (!z && C0810t.m3428b(this.f2490h)) {
            if (enumC0695j != EnumC0695j.BROADCAST) {
                C0635g.m2886a(this.f2501u, str3, str2, j);
            }
            return false;
        }
        Long lValueOf = Long.valueOf(C1735ar.m5918a());
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0590f(c0623am.m2822c(), enumC0695j, str3, str, lValueOf.longValue(), str2));
        if (enumC0695j != EnumC0695j.BROADCAST) {
            C0635g.m2886a(this.f2501u, str3, str2, j);
        }
        c0623am.m2824e();
        this.f2495n.put(Long.valueOf(c0623am.m2821b()), c0623am);
        return true;
    }

    /* renamed from: a */
    public void m2932a(C0118ak c0118ak) {
        C1786r.m6061b("makeDeliveryChatReply", getClass().getSimpleName());
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0602r(c0623am.m2822c(), this.f2489g, c0118ak, this));
        c0623am.m2824e();
    }

    /* renamed from: a */
    public void m2936a(EnumC0695j enumC0695j, String str) {
        C1786r.m6061b("sendDeliveryChatReply", getClass().getSimpleName());
        C0494bh c0494bhM2692b = C0494bh.m2692b(this.f2489g);
        if (!C0810t.m3426a(this.f2490h)) {
            c0494bhM2692b.m2693a();
        } else if (!c0494bhM2692b.m2695b()) {
            new C0601q(this.f2488f, this.f2489g, enumC0695j, str).m2757a(this.f2490h);
        }
    }

    /* renamed from: a */
    public void m2933a(C0182i c0182i) {
        new C0591g(this.f2488f, c0182i, this.f2489g).m2757a(this.f2490h);
    }

    /* renamed from: a */
    public void m2938a(EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str, String[] strArr, String str2) {
        C1786r.m6061b("sendMessage", getClass().getSimpleName());
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        long jM5918a = C1735ar.m5918a();
        c0623am.m2820a(EnumC0627aq.NetTask, new C0596l(c0623am.m2822c(), jM5918a, this.f2489g, enumC0699n, enumC0695j, str, str2));
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        C0665i.m3067b(GlobalApplication.m3260b().getContentResolver(), String.valueOf(jM5918a), this.f2489g, enumC0699n, str2, strArr.length);
        c0623am.m2824e();
    }

    /* renamed from: a */
    public long m2927a(File file, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2) {
        return m2928a(file, enumC0699n, enumC0695j, str, strArr, z, str2, (String) null);
    }

    /* renamed from: a */
    public long m2928a(File file, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, String str3) {
        return m2929a(file, enumC0699n, enumC0695j, str, strArr, z, str2, str3, true);
    }

    /* renamed from: a */
    public long m2929a(File file, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, String str3, boolean z2) {
        long jM5918a = C1735ar.m5918a();
        C0779c.m3335a().m3338a(this.f2503w, str, file, jM5918a, this.f2489g, enumC0695j, enumC0699n, strArr, str2, false, str3, z2);
        return jM5918a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2908a(long j, String str, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str2, String[] strArr, boolean z, String str3, String str4, String str5) {
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0566bg(c0623am.m2822c(), this.f2489g, j, str, enumC0699n, enumC0695j, str2, strArr, str4, z, str3, str5));
        this.f2495n.put(Long.valueOf(c0623am.m2821b()), c0623am);
        c0623am.m2824e();
    }

    /* renamed from: a */
    public long m2924a(long j, File file, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, String str3) {
        C0779c.m3335a().m3337a(this.f2503w, str, file, j, this.f2489g, enumC0695j, enumC0699n, strArr, str2, true, str3);
        return j;
    }

    /* renamed from: a */
    public long m2920a(long j, EnumC0695j enumC0695j, String str, String str2, String[] strArr, boolean z, String str3, String str4, EnumC0699n enumC0699n) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("\n");
            String strSubstring = null;
            if (strArrSplit.length > 6) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 6; i < strArrSplit.length; i++) {
                    stringBuffer.append(strArrSplit[i] + "\n");
                }
                strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
            }
            if (strArrSplit.length > 4) {
                C0665i.m3074c(GlobalApplication.m3260b().getContentResolver(), Long.valueOf(j));
                return m2923a(j, this.f2498q, this.f2497p, strArr, z, str3, (File) null, str4, strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4], enumC0699n, strSubstring);
            }
        }
        return -1L;
    }

    /* renamed from: a */
    public long m2926a(EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, String str3) {
        return m2925a(enumC0695j, str, strArr, z, str2, -1L, str3);
    }

    /* renamed from: a */
    public long m2925a(EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, long j, String str3) {
        String str4;
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        if (TextUtils.isEmpty(str3)) {
            str4 = "geo\n\n\n\n\n" + str2;
        } else {
            str4 = "mixed\ngeo\n\n\n\n" + str2 + "\n" + str3;
        }
        long jM5918a = C1735ar.m5918a();
        c0623am.m2820a(EnumC0627aq.NetTask, new C0566bg(c0623am.m2822c(), this.f2489g, jM5918a, "", EnumC0699n.GEO, enumC0695j, str, strArr, "", z, str4, null));
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        if ((TextUtils.isEmpty(str) || "null".equals(str)) && enumC0695j != EnumC0695j.BROADCAST && !this.f2491i.f1771L.isShowing()) {
            this.f2491i.f1771L.show();
        }
        C0665i.m3061a(this.f2500s, 11, String.valueOf(jM5918a), this.f2489g, EnumC0699n.GEO, str4, strArr.length);
        c0623am.m2824e();
        return c0623am.m2821b();
    }

    /* renamed from: a */
    public long m2921a(long j, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2) {
        return m2922a(j, enumC0695j, str, strArr, z, str2, -1L);
    }

    /* renamed from: a */
    public long m2922a(long j, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, long j2) {
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0566bg(c0623am.m2822c(), this.f2489g, j, "", EnumC0699n.GEO, enumC0695j, str, strArr, "", z, str2, null));
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        if (!z) {
            C0665i.m3060a(this.f2500s, 0, Long.valueOf(j));
        }
        c0623am.m2824e();
        return c0623am.m2821b();
    }

    /* renamed from: a */
    public long m2923a(long j, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, File file, String str3, String str4, EnumC0699n enumC0699n, String str5) {
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0566bg(c0623am.m2822c(), this.f2489g, j, str3, enumC0699n, enumC0695j, str, strArr, str4, z, str2, str5));
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        c0623am.m2824e();
        return j;
    }

    /* renamed from: b */
    public long m2948b(long j, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, long j2) {
        C0623am c0623am;
        try {
            if (j2 != -1) {
                c0623am = new C0623am(this.f2502v, this.f2490h, j2);
            } else {
                c0623am = new C0623am(this.f2502v, this.f2490h);
            }
            long jM5918a = j == -1 ? C1735ar.m5918a() : j;
            C0911a c0911a = new C0911a(c0623am.m2822c(), this.f2489g, jM5918a, enumC0695j, str, strArr, z, str2);
            c0623am.m2820a(EnumC0627aq.NetTask, c0911a);
            this.f2495n.put(Long.valueOf(c0623am.m2821b()), c0623am);
            C0665i.m3042a(GlobalApplication.m3260b().getContentResolver(), String.valueOf(jM5918a), this.f2489g, EnumC0699n.ANICON, c0911a.m3673d(), strArr.length);
            c0623am.m2824e();
            return c0623am.m2821b();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: c */
    public long m2950c(long j, EnumC0695j enumC0695j, String str, String[] strArr, boolean z, String str2, long j2) {
        C0623am c0623am;
        if (j2 != -1) {
            c0623am = new C0623am(this.f2502v, this.f2490h, j2);
        } else {
            c0623am = new C0623am(this.f2502v, this.f2490h);
        }
        c0623am.m2820a(EnumC0627aq.NetTask, new C0911a(c0623am.m2822c(), this.f2489g, j, enumC0695j, str, strArr, z, str2));
        this.f2495n.put(Long.valueOf(c0623am.m2821b()), c0623am);
        C0665i.m3074c(GlobalApplication.m3260b().getContentResolver(), Long.valueOf(j));
        c0623am.m2824e();
        return c0623am.m2821b();
    }

    /* renamed from: a */
    public void m2931a(long j, String str, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str2, String[] strArr, String str3, boolean z) {
        C1786r.m6061b("reSend", getClass().getSimpleName());
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        if (z) {
            c0623am.m2820a(EnumC0627aq.NetTask, new C0563bd(c0623am.m2822c(), str, j, enumC0699n, enumC0695j, strArr, str3));
        } else {
            switch (C0645q.f2510a[enumC0695j.ordinal()]) {
                case 1:
                case 2:
                    C0665i.m3060a(this.f2500s, 0, Long.valueOf(j));
                    break;
            }
            c0623am.m2820a(EnumC0627aq.NetTask, new C0596l(c0623am.m2822c(), j, this.f2489g, enumC0699n, enumC0695j, str2, str3));
        }
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        c0623am.m2824e();
    }

    /* renamed from: a */
    public void m2934a(C0188o c0188o) {
        new C0592h(this.f2488f, c0188o).m2757a(this.f2490h);
    }

    /* renamed from: a */
    public void m2939a(EnumC0699n enumC0699n, String str, String[] strArr, String[] strArr2) {
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0565bf(c0623am.m2822c(), enumC0699n, str, strArr, strArr2, this.f2489g));
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        c0623am.m2824e();
    }

    /* renamed from: e */
    public void m2953e() {
        if (this.f2490h != null) {
            C0810t.m3433e(this.f2490h);
            f2481m.remove(this.f2489g);
        }
    }

    /* renamed from: a */
    public void m2937a(EnumC0695j enumC0695j, String str, String str2, String[] strArr) {
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0606v(c0623am.m2822c(), enumC0695j, str, str2, strArr));
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        c0623am.m2824e();
    }

    /* renamed from: a */
    public void m2943a(ArrayList arrayList) {
        C0623am c0623am = new C0623am(this.f2502v, this.f2490h);
        c0623am.m2820a(EnumC0627aq.NetTask, new C0547ao(c0623am.m2822c(), arrayList, this.f2489g));
        this.f2495n.put(Long.valueOf(c0623am.m2818a()), c0623am);
        c0623am.m2824e();
    }

    /* renamed from: a */
    public boolean m2947a(String str, String str2, int i) {
        boolean z;
        String str3;
        String simpleName;
        C0769aa c0769aa = new C0769aa();
        this.f2489g = str;
        try {
            c0769aa.m3280a(str).m3282b(str2).m3278a(i).m3279a((C1771c) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            try {
                this.f2490h = c0769aa.m3281a();
                m2952d();
                z = true;
                str3 = "ChatRoom Info : InboxNO = " + this.f2489g + " SERVER = " + str2;
                simpleName = getClass().getSimpleName();
            } catch (NoSuchFieldException e2) {
                C1786r.m6054a("TCP Context buiilder" + e2, toString());
                this.f2490h = null;
                z = false;
                str3 = "ChatRoom Info : InboxNO = " + this.f2489g + " SERVER = " + str2;
                simpleName = getClass().getSimpleName();
            }
            C1786r.m6066e(str3, simpleName);
            return z;
        } catch (Throwable th) {
            C1786r.m6066e("ChatRoom Info : InboxNO = " + this.f2489g + " SERVER = " + str2, getClass().getSimpleName());
            throw th;
        }
    }

    /* renamed from: a */
    public void m2930a(long j) {
        if (this.f2490h != null) {
            this.f2490h.m3451a(j);
        }
    }

    /* renamed from: a */
    public void m2935a(ChatFragment chatFragment) {
        this.f2491i = chatFragment;
    }

    /* renamed from: f */
    public void m2954f() {
        C0494bh.m2691a(this.f2489g);
        if (this.f2490h != null && C0810t.m3426a(this.f2490h)) {
            C0810t.m3431d(this.f2490h);
        }
    }

    /* renamed from: g */
    public void m2955g() {
        C0494bh.m2691a(this.f2489g);
        if (this.f2490h != null) {
            C0810t.m3430c(this.f2490h);
        }
    }

    /* renamed from: a */
    public void m2944a(boolean z) {
        this.f2492j = z;
    }

    /* renamed from: h */
    public boolean m2956h() {
        return this.f2492j;
    }

    /* renamed from: b */
    public void m2949b(boolean z) {
        this.f2496o = z;
    }

    /* renamed from: i */
    public boolean m2957i() {
        return this.f2496o;
    }

    /* renamed from: c */
    public void m2951c(String str) {
        this.f2493k = str;
    }

    /* renamed from: j */
    public String m2958j() {
        return this.f2493k;
    }

    /* renamed from: k */
    public void m2959k() {
        Handler handler = new Handler();
        handler.post(new RunnableC0644p(this, handler));
    }

    @Override // com.sec.chaton.p022h.InterfaceC0807q
    /* renamed from: a */
    public void mo2781a(int i, Object obj) {
    }

    @Override // com.sec.chaton.p022h.InterfaceC0807q
    /* renamed from: a */
    public void mo2782a(int i, Object obj, Object obj2) {
        if (obj2 != null) {
            C0770ab c0770ab = (C0770ab) obj2;
            if (c0770ab.m3290c() != null) {
                switch (c0770ab.m3289b()) {
                    case 6:
                        C0118ak c0118ak = (C0118ak) c0770ab.m3290c();
                        C1786r.m6061b("DeliveryChat From Server : Session ID = " + c0118ak.m831d(), getClass().getSimpleName());
                        m2932a(c0118ak);
                        break;
                    case 10:
                        C0188o c0188o = (C0188o) c0770ab.m3290c();
                        C1786r.m6061b("AnswerBack From Server", getClass().getSimpleName());
                        m2934a(c0188o);
                        break;
                    case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                        C0182i c0182i = (C0182i) c0770ab.m3290c();
                        C1786r.m6061b("AnnounceChange From Server", getClass().getSimpleName());
                        m2933a(c0182i);
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    public void m2942a(String str, String str2) {
        this.f2500s.startQuery(99, new String[]{str, str2}, C0698m.f2626a, null, "message_inbox_no='" + this.f2489g + "' AND (message_content_type='" + EnumC0699n.IMAGE.m3162a() + "' OR message_content_type='" + EnumC0699n.VIDEO.m3162a() + "') AND message_content is not null AND (message_type!=1 AND message_type!=4)", null, null);
    }

    /* renamed from: a */
    public static void m2911a(String str, String str2, String str3) {
        C0639k c0639kM2914b = m2914b(str);
        if (c0639kM2914b != null) {
            c0639kM2914b.m2942a(str2, str3);
        }
    }
}
