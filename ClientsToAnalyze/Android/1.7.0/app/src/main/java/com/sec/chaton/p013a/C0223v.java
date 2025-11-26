package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0585by;
import com.sec.chaton.chat.C0592i;
import com.sec.chaton.chat.background.C0556c;
import com.sec.chaton.chat.background.C0558e;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.C0124a;
import com.sec.chaton.p013a.p014a.C0127ac;
import com.sec.chaton.p013a.p014a.C0130af;
import com.sec.chaton.p013a.p014a.C0136al;
import com.sec.chaton.p013a.p014a.C0137am;
import com.sec.chaton.p013a.p014a.C0142ar;
import com.sec.chaton.p013a.p014a.C0154bc;
import com.sec.chaton.p013a.p014a.C0178q;
import com.sec.chaton.p013a.p014a.C0180s;
import com.sec.chaton.p013a.p014a.C0182u;
import com.sec.chaton.p015b.C0305br;
import com.sec.chaton.p015b.C0314c;
import com.sec.chaton.p015b.C0322ch;
import com.sec.chaton.p018c.C0477ab;
import com.sec.chaton.p018c.C0490c;
import com.sec.chaton.p018c.C0505l;
import com.sec.chaton.p018c.C0509p;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p018c.InterfaceC0504k;
import com.sec.chaton.p018c.p019a.C0468e;
import com.sec.chaton.p018c.p021c.C0491a;
import com.sec.chaton.p018c.p021c.C0492b;
import com.sec.chaton.p018c.p021c.C0493c;
import com.sec.chaton.p018c.p021c.C0494d;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1322br;
import com.sec.chaton.util.C1325bu;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.a.v */
/* loaded from: classes.dex */
public class C0223v implements InterfaceC0504k {

    /* renamed from: b */
    private static HandlerThread f536b = null;

    /* renamed from: n */
    private static HashMap f537n = new HashMap();

    /* renamed from: f */
    private Handler f542f;

    /* renamed from: h */
    private String f544h;

    /* renamed from: i */
    private C0505l f545i;

    /* renamed from: k */
    private String f547k;

    /* renamed from: r */
    private String f553r;

    /* renamed from: s */
    private EnumC0665r f554s;

    /* renamed from: j */
    private boolean f546j = false;

    /* renamed from: l */
    private boolean f548l = false;

    /* renamed from: m */
    private boolean f549m = false;

    /* renamed from: o */
    private Map f550o = new HashMap();

    /* renamed from: p */
    private ArrayList f551p = new ArrayList();

    /* renamed from: q */
    private boolean f552q = false;

    /* renamed from: t */
    private ArrayList f555t = new ArrayList();

    /* renamed from: u */
    private Handler f556u = new HandlerC0211j(this, m816b().getLooper());

    /* renamed from: v */
    private Handler f557v = new HandlerC0209h(this, m816b().getLooper());

    /* renamed from: w */
    private Handler f558w = new HandlerC0208g(this, m816b().getLooper());

    /* renamed from: g */
    private List f543g = new ArrayList();

    /* renamed from: a */
    C0490c f538a = new C0490c(this.f558w, this);

    /* renamed from: c */
    private final Object f539c = new Object();

    /* renamed from: d */
    private final Object f540d = new Object();

    /* renamed from: e */
    private final Object f541e = new Object();

    /* renamed from: a */
    public static void m809a() {
        if (f536b == null) {
            f536b = new HandlerThread("MessageControl0");
            f536b.start();
        } else if (!f536b.isAlive()) {
            f536b.start();
        }
    }

    /* renamed from: a */
    public boolean m848a(Handler handler) {
        boolean zAdd;
        synchronized (this.f539c) {
            if (this.f543g.contains(handler)) {
                zAdd = true;
            } else {
                if (C1341p.f4578b) {
                    C1341p.m4658b("addHandler : " + handler.toString(), getClass().getSimpleName());
                }
                zAdd = this.f543g.add(handler);
            }
        }
        return zAdd;
    }

    /* renamed from: b */
    public boolean m853b(Handler handler) {
        boolean zRemove;
        if (C1341p.f4578b) {
            C1341p.m4658b("removeHandler : " + handler.toString(), getClass().getSimpleName());
        }
        synchronized (this.f539c) {
            zRemove = this.f543g.remove(handler);
        }
        return zRemove;
    }

    /* renamed from: b */
    public static HandlerThread m816b() {
        return f536b;
    }

    /* renamed from: a */
    public void m846a(String str) {
        synchronized (this.f541e) {
            this.f553r = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m810a(int i, int i2, int i3, Object obj, long j) {
        synchronized (this.f539c) {
            for (Handler handler : this.f543g) {
                Message messageObtain = Message.obtain();
                messageObtain.arg1 = i;
                messageObtain.arg2 = i2;
                messageObtain.what = i3;
                messageObtain.obj = new C0592i(j, obj);
                handler.sendMessage(messageObtain);
            }
        }
        C1341p.m4658b("RequestID : " + String.valueOf(j), getClass().getSimpleName());
    }

    /* renamed from: a */
    private boolean m815a(C0558e c0558e, boolean z) {
        EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(c0558e.m2747e());
        if (enumC0651dM2976a != null) {
            if (EnumC0651d.TEXT == enumC0651dM2976a) {
                if (z) {
                    m840a(this.f544h, enumC0651dM2976a, EnumC0665r.m3011a(c0558e.m2746d()), c0558e.m2745c(), c0558e.m2748f(), c0558e.m2751i());
                } else {
                    m833a(enumC0651dM2976a, EnumC0665r.m3011a(c0558e.m2746d()), this.f553r, c0558e.m2745c(), c0558e.m2748f(), c0558e.m2751i());
                }
            } else if (EnumC0651d.GEO == enumC0651dM2976a) {
                m837a(EnumC0665r.m3011a(c0558e.m2746d()), this.f553r, c0558e.m2745c(), z, c0558e.m2748f(), c0558e.m2751i());
            } else {
                m811a(c0558e.m2750h(), c0558e.m2752j(), enumC0651dM2976a, EnumC0665r.m3011a(c0558e.m2746d()), this.f553r, c0558e.m2745c(), z, c0558e.m2748f(), c0558e.m2753k());
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m822c(boolean z) {
        if (z) {
            synchronized (this.f540d) {
                if (this.f552q) {
                    this.f552q = false;
                    if (this.f551p.size() > 0) {
                        Iterator it = this.f551p.iterator();
                        while (it.hasNext()) {
                            m815a((C0558e) it.next(), false);
                        }
                        this.f551p.clear();
                    }
                }
            }
            return;
        }
        synchronized (this.f540d) {
            if (this.f552q) {
                if (this.f551p.size() > 0) {
                    m815a((C0558e) this.f551p.remove(0), true);
                } else {
                    this.f552q = false;
                }
            }
        }
    }

    public C0223v(String str, EnumC0665r enumC0665r) {
        this.f544h = str;
        this.f547k = str;
        this.f554s = enumC0665r;
    }

    /* renamed from: a */
    public static synchronized C0223v m806a(String str, EnumC0665r enumC0665r) {
        if (!f537n.containsKey(str)) {
            f537n.put(str, new C0223v(str, enumC0665r));
        } else {
            ((C0223v) f537n.get(str)).f544h = str;
            ((C0223v) f537n.get(str)).f547k = str;
            ((C0223v) f537n.get(str)).f554s = enumC0665r;
        }
        return (C0223v) f537n.get(str);
    }

    /* renamed from: b */
    public static synchronized C0223v m817b(String str) {
        return f537n != null ? (C0223v) f537n.get(str) : null;
    }

    /* renamed from: c */
    public static synchronized void m821c() {
        Iterator it = new ArrayList(f537n.values()).iterator();
        while (it.hasNext()) {
            C0223v c0223v = (C0223v) it.next();
            if (c0223v != null) {
                c0223v.m856e();
            }
        }
    }

    /* renamed from: d */
    public void m855d() {
        C0494d.m2497a(this.f545i, this.f538a);
        C0491a.m2493a(this.f545i, this.f538a);
        C0493c.m2496a(this.f545i, this.f538a);
        C0492b.m2494a(this.f545i, this.f538a);
        this.f545i.f1640m = this.f538a;
    }

    /* renamed from: a */
    public long m839a(String str, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String[] strArr, String str2) {
        return m840a(str, enumC0651d, enumC0665r, strArr, str2, -1L);
    }

    /* renamed from: a */
    public long m840a(String str, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String[] strArr, String str2, long j) {
        C0215n c0215n;
        C1341p.m4658b("initChatRoom", getClass().getSimpleName());
        if (enumC0665r != EnumC0665r.BROADCAST) {
            synchronized (this.f540d) {
                if (this.f552q) {
                    C0556c c0556c = new C0556c();
                    c0556c.m2734a(strArr).m2731a(enumC0665r.m3012a()).m2736b(enumC0651d.m2978a()).m2738b(str2);
                    if (j != -1) {
                        c0556c.m2739c(j);
                    } else {
                        c0556c.m2739c(C1325bu.m4591a());
                    }
                    C0558e c0558eM2735a = c0556c.m2735a();
                    this.f551p.add(c0558eM2735a);
                    return c0558eM2735a.m2751i();
                }
                this.f552q = true;
            }
        }
        if (j != -1) {
            c0215n = new C0215n(this.f558w, this.f545i, j);
        } else {
            c0215n = new C0215n(this.f558w, this.f545i);
        }
        c0215n.m787a(EnumC0206e.NetTask, new C0127ac(c0215n.m788b(), str, enumC0651d, enumC0665r, strArr, str2));
        this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
        c0215n.m790d();
        return c0215n.m785a();
    }

    /* renamed from: a */
    public boolean m849a(EnumC0665r enumC0665r, String str, Long l, String str2, String str3, long j) {
        return m850a(enumC0665r, str, l, str2, str3, j, false);
    }

    /* renamed from: a */
    public boolean m850a(EnumC0665r enumC0665r, String str, Long l, String str2, String str3, long j, boolean z) {
        if (!z && C0477ab.m2448b(this.f545i)) {
            if (enumC0665r != EnumC0665r.BROADCAST) {
                C0227z.m877a(this.f557v, str3, str2, j);
            }
            return false;
        }
        Long lValueOf = Long.valueOf(C1325bu.m4591a());
        C0215n c0215n = new C0215n(this.f558w, this.f545i);
        c0215n.m787a(EnumC0206e.NetTask, new C0130af(c0215n.m788b(), enumC0665r, str3, str, lValueOf.longValue(), str2));
        if (enumC0665r != EnumC0665r.BROADCAST) {
            C0227z.m877a(this.f557v, str3, str2, j);
        }
        c0215n.m790d();
        this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
        return true;
    }

    /* renamed from: a */
    public void m842a(C0305br c0305br) {
        C1341p.m4658b("makeDeliveryChatReply", getClass().getSimpleName());
        C0215n c0215n = new C0215n(this.f558w, this.f545i);
        c0215n.m787a(EnumC0206e.NetTask, new C0182u(c0215n.m788b(), this.f544h, c0305br, this));
        c0215n.m790d();
    }

    /* renamed from: a */
    public void m845a(EnumC0665r enumC0665r, String str) {
        C1341p.m4658b("sendDeliveryChatReply", getClass().getSimpleName());
        C0585by c0585byM2770b = C0585by.m2770b(this.f544h);
        if (!C0477ab.m2446a(this.f545i)) {
            c0585byM2770b.m2771a();
        } else if (!c0585byM2770b.m2773b()) {
            new C0142ar(this.f542f, this.f544h, enumC0665r, str).m702a(this.f545i);
        }
    }

    /* renamed from: a */
    public void m843a(C0314c c0314c) {
        new C0154bc(this.f542f, c0314c, this.f544h).m702a(this.f545i);
    }

    /* renamed from: a */
    public long m832a(EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str, String[] strArr, String str2) {
        return m833a(enumC0651d, enumC0665r, str, strArr, str2, -1L);
    }

    /* renamed from: a */
    public long m833a(EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str, String[] strArr, String str2, long j) {
        C0215n c0215n;
        C1341p.m4658b("sendMessage", getClass().getSimpleName());
        if (str2.length() > 2000) {
            C1619g.m5888a(GlobalApplication.m3100a(), R.string.toast_text_max_Length, 0).show();
            return 0L;
        }
        if (j != -1) {
            c0215n = new C0215n(this.f558w, this.f545i, j);
        } else {
            c0215n = new C0215n(this.f558w, this.f545i);
        }
        long jM4591a = C1325bu.m4591a();
        c0215n.m787a(EnumC0206e.NetTask, new C0137am(c0215n.m788b(), jM4591a, this.f544h, enumC0651d, enumC0665r, str, str2, strArr));
        this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
        C0635o.m2930a(GlobalApplication.m3100a().getContentResolver(), String.valueOf(jM4591a), this.f544h, enumC0651d, str2, strArr.length);
        c0215n.m790d();
        return c0215n.m785a();
    }

    /* renamed from: a */
    public long m836a(EnumC0665r enumC0665r, String str, String[] strArr, boolean z, String str2) {
        return m837a(enumC0665r, str, strArr, z, str2, -1L);
    }

    /* renamed from: a */
    public long m837a(EnumC0665r enumC0665r, String str, String[] strArr, boolean z, String str2, long j) {
        C0215n c0215n;
        if (z && enumC0665r != EnumC0665r.BROADCAST) {
            synchronized (this.f540d) {
                if (this.f552q) {
                    C0556c c0556c = new C0556c();
                    c0556c.m2734a(strArr).m2731a(enumC0665r.m3012a()).m2736b(EnumC0651d.GEO.m2978a()).m2738b(str2);
                    if (j != -1) {
                        c0556c.m2739c(j);
                    } else {
                        c0556c.m2739c(C1325bu.m4591a());
                    }
                    C0558e c0558eM2735a = c0556c.m2735a();
                    this.f551p.add(c0558eM2735a);
                    return c0558eM2735a.m2751i();
                }
                this.f552q = true;
            }
        }
        if (j != -1) {
            c0215n = new C0215n(this.f558w, this.f545i, j);
        } else {
            c0215n = new C0215n(this.f558w, this.f545i);
        }
        String str3 = "geo\n\n\n\n\n" + str2;
        long jM4591a = C1325bu.m4591a();
        c0215n.m787a(EnumC0206e.NetTask, new C0180s(c0215n.m788b(), this.f544h, jM4591a, "", EnumC0651d.GEO, enumC0665r, str, strArr, "", z, str3));
        this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
        C0635o.m2930a(GlobalApplication.m3100a().getContentResolver(), String.valueOf(jM4591a), this.f544h, EnumC0651d.GEO, str3, strArr.length);
        c0215n.m790d();
        return c0215n.m785a();
    }

    /* renamed from: a */
    public long m826a(long j, EnumC0665r enumC0665r, String str, String[] strArr, boolean z, String str2) {
        return m827a(j, enumC0665r, str, strArr, z, str2, -1L);
    }

    /* renamed from: a */
    public long m827a(long j, EnumC0665r enumC0665r, String str, String[] strArr, boolean z, String str2, long j2) {
        C0215n c0215n;
        if (z && enumC0665r != EnumC0665r.BROADCAST) {
            synchronized (this.f540d) {
                if (this.f552q) {
                    C0556c c0556c = new C0556c();
                    c0556c.m2734a(strArr).m2731a(enumC0665r.m3012a()).m2736b(EnumC0651d.GEO.m2978a()).m2738b(str2).m2737b(j);
                    if (j2 != -1) {
                        c0556c.m2739c(j2);
                    } else {
                        c0556c.m2739c(C1325bu.m4591a());
                    }
                    C0558e c0558eM2735a = c0556c.m2735a();
                    this.f551p.add(c0558eM2735a);
                    return c0558eM2735a.m2751i();
                }
                this.f552q = true;
            }
        }
        if (j2 != -1) {
            c0215n = new C0215n(this.f558w, this.f545i, j2);
        } else {
            c0215n = new C0215n(this.f558w, this.f545i);
        }
        c0215n.m787a(EnumC0206e.NetTask, new C0180s(c0215n.m788b(), this.f544h, j, "", EnumC0651d.GEO, enumC0665r, str, strArr, "", z, str2));
        this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
        C0635o.m2947c(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(j));
        c0215n.m790d();
        return c0215n.m785a();
    }

    /* renamed from: a */
    public long m830a(long j, String str, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str2, String[] strArr, String str3, boolean z) {
        return m831a(j, str, enumC0651d, enumC0665r, str2, strArr, str3, z, -1L);
    }

    /* renamed from: a */
    public long m831a(long j, String str, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str2, String[] strArr, String str3, boolean z, long j2) {
        C0215n c0215n;
        C1341p.m4658b("reSend", getClass().getSimpleName());
        if (z && enumC0665r != EnumC0665r.BROADCAST) {
            synchronized (this.f540d) {
                if (this.f552q) {
                    C0556c c0556c = new C0556c();
                    c0556c.m2734a(strArr).m2731a(enumC0665r.m3012a()).m2736b(enumC0651d.m2978a()).m2738b(str3).m2737b(j);
                    if (j2 != -1) {
                        c0556c.m2739c(j2);
                    } else {
                        c0556c.m2739c(C1325bu.m4591a());
                    }
                    C0558e c0558eM2735a = c0556c.m2735a();
                    this.f551p.add(c0558eM2735a);
                    return c0558eM2735a.m2751i();
                }
                this.f552q = true;
            }
        }
        if (j2 != -1) {
            c0215n = new C0215n(this.f558w, this.f545i, j2);
        } else {
            c0215n = new C0215n(this.f558w, this.f545i);
        }
        if (z) {
            c0215n.m787a(EnumC0206e.NetTask, new C0127ac(c0215n.m788b(), str, j, enumC0651d, enumC0665r, strArr, str3));
        } else {
            switch (C0210i.f512a[enumC0665r.ordinal()]) {
                case 1:
                case 2:
                    C0635o.m2947c(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(j));
                    break;
            }
            c0215n.m787a(EnumC0206e.NetTask, new C0137am(c0215n.m788b(), j, this.f544h, enumC0651d, enumC0665r, str2, str3, strArr));
        }
        this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
        c0215n.m790d();
        return c0215n.m785a();
    }

    /* renamed from: a */
    public long m838a(File file, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str, String[] strArr, boolean z, String str2) {
        long jM4591a = C1325bu.m4591a();
        C0468e.m2389a().m2391a(this.f556u, str, file, jM4591a, this.f544h, enumC0665r, enumC0651d, strArr, str2, false);
        return jM4591a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m811a(long j, String str, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str2, String[] strArr, boolean z, String str3, String str4) {
        if (z && enumC0665r != EnumC0665r.BROADCAST) {
            synchronized (this.f540d) {
                if (this.f552q) {
                    C0556c c0556c = new C0556c();
                    c0556c.m2734a(strArr).m2731a(enumC0665r.m3012a()).m2736b(enumC0651d.m2978a()).m2738b(str3).m2737b(j).m2739c(j).m2742e(str4).m2741d(str);
                    this.f551p.add(c0556c.m2735a());
                    return;
                }
                this.f552q = true;
            }
        }
        C0215n c0215n = new C0215n(this.f558w, this.f545i);
        c0215n.m787a(EnumC0206e.NetTask, new C0180s(c0215n.m788b(), this.f544h, j, str, enumC0651d, enumC0665r, str2, strArr, str4, z, str3));
        this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
        c0215n.m790d();
    }

    /* renamed from: a */
    public long m829a(long j, File file, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str, String[] strArr, boolean z, String str2) {
        C0468e.m2389a().m2391a(this.f556u, str, file, j, this.f544h, enumC0665r, enumC0651d, strArr, str2, true);
        return j;
    }

    /* renamed from: a */
    public long m825a(long j, EnumC0665r enumC0665r, String str, String str2, String[] strArr, boolean z, String str3, String str4, EnumC0651d enumC0651d) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length > 4) {
                C0635o.m2947c(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(j));
                return m828a(j, this.f554s, this.f553r, strArr, z, str3, (File) null, str4, strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4], enumC0651d);
            }
        }
        return -1L;
    }

    /* renamed from: a */
    public long m828a(long j, EnumC0665r enumC0665r, String str, String[] strArr, boolean z, String str2, File file, String str3, String str4, EnumC0651d enumC0651d) {
        if (z && enumC0665r != EnumC0665r.BROADCAST) {
            synchronized (this.f540d) {
                if (this.f552q) {
                    C0556c c0556c = new C0556c();
                    c0556c.m2734a(strArr).m2731a(enumC0665r.m3012a()).m2736b(enumC0651d.m2978a()).m2738b(str2).m2737b(j).m2739c(j).m2742e(str4);
                    this.f551p.add(c0556c.m2735a());
                } else {
                    this.f552q = true;
                    C0215n c0215n = new C0215n(this.f558w, this.f545i);
                    c0215n.m787a(EnumC0206e.NetTask, new C0180s(c0215n.m788b(), this.f544h, j, str3, enumC0651d, enumC0665r, str, strArr, str4, z, str2));
                    this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
                    c0215n.m790d();
                }
            }
        } else {
            C0215n c0215n2 = new C0215n(this.f558w, this.f545i);
            c0215n2.m787a(EnumC0206e.NetTask, new C0180s(c0215n2.m788b(), this.f544h, j, str3, enumC0651d, enumC0665r, str, strArr, str4, z, str2));
            this.f550o.put(Long.valueOf(c0215n2.m785a()), c0215n2);
            c0215n2.m790d();
        }
        return j;
    }

    /* renamed from: a */
    public void m844a(C0322ch c0322ch) {
        new C0178q(this.f542f, c0322ch).m702a(this.f545i);
    }

    /* renamed from: a */
    public long m834a(EnumC0651d enumC0651d, String str, String[] strArr, String[] strArr2) {
        C0215n c0215n = new C0215n(this.f558w, this.f545i);
        c0215n.m787a(EnumC0206e.NetTask, new C0124a(c0215n.m788b(), enumC0651d, str, strArr, strArr2, this.f544h));
        this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
        c0215n.m790d();
        return c0215n.m785a();
    }

    /* renamed from: e */
    public void m856e() {
        if (this.f545i != null) {
            C0477ab.m2453e(this.f545i);
            f537n.remove(this.f544h);
        }
    }

    /* renamed from: a */
    public long m835a(EnumC0665r enumC0665r, String str, String str2, String[] strArr) {
        C0215n c0215n = new C0215n(this.f558w, this.f545i);
        c0215n.m787a(EnumC0206e.NetTask, new C0136al(c0215n.m788b(), enumC0665r, str, str2, strArr));
        this.f550o.put(Long.valueOf(c0215n.m785a()), c0215n);
        c0215n.m790d();
        return c0215n.m785a();
    }

    /* renamed from: a */
    public boolean m851a(String str, String str2, int i) {
        StringBuilder sb;
        String str3;
        StringBuilder sbAppend;
        String str4;
        StringBuilder sbAppend2;
        String str5;
        StringBuilder sbAppend3;
        StringBuilder sbAppend4;
        String string;
        Class<?> cls;
        String simpleName;
        C0509p c0509p = new C0509p();
        this.f544h = str;
        try {
            c0509p.m2565a(str).m2566b(str2).m2563a(i).m2564a((C1322br) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f545i = c0509p.m2562a();
            m855d();
            return true;
        } catch (NoSuchFieldException e2) {
            C1341p.m4651a("TCP Context buiilder" + e2, toString());
            this.f545i = null;
            return false;
        } finally {
            C1341p.m4662e("ChatRoom Info : InboxNO = " + this.f544h + " SERVER = " + str2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m841a(long j) {
        if (this.f545i != null) {
            this.f545i.m2545a(j);
        }
    }

    /* renamed from: f */
    public void m857f() {
        C0585by.m2769a(this.f544h);
        if (this.f545i != null && C0477ab.m2446a(this.f545i)) {
            C0477ab.m2451d(this.f545i);
        }
    }

    /* renamed from: g */
    public void m858g() {
        C0585by.m2769a(this.f544h);
        if (this.f545i != null) {
            C0477ab.m2450c(this.f545i);
        }
    }

    /* renamed from: a */
    public void m847a(boolean z) {
        this.f546j = z;
    }

    /* renamed from: h */
    public boolean m859h() {
        return this.f546j;
    }

    /* renamed from: b */
    public void m852b(boolean z) {
        this.f549m = z;
    }

    /* renamed from: i */
    public boolean m860i() {
        return this.f549m;
    }

    /* renamed from: c */
    public void m854c(String str) {
        this.f547k = str;
    }

    /* renamed from: j */
    public String m861j() {
        return this.f547k;
    }

    @Override // com.sec.chaton.p018c.InterfaceC0504k
    /* renamed from: a */
    public void mo668a(int i, Object obj) {
    }

    @Override // com.sec.chaton.p018c.InterfaceC0504k
    /* renamed from: a */
    public void mo669a(int i, Object obj, Object obj2) {
        if (obj2 != null) {
            C0510q c0510q = (C0510q) obj2;
            if (c0510q.m2574c() != null) {
                switch (c0510q.m2573b()) {
                    case 6:
                        C0305br c0305br = (C0305br) c0510q.m2574c();
                        C1341p.m4658b("DeliveryChat From Server : Session ID = " + c0305br.m1508d(), getClass().getSimpleName());
                        m842a(c0305br);
                        break;
                    case 10:
                        C0322ch c0322ch = (C0322ch) c0510q.m2574c();
                        C1341p.m4658b("AnswerBack From Server", getClass().getSimpleName());
                        m844a(c0322ch);
                        break;
                    case 16:
                        C0314c c0314c = (C0314c) c0510q.m2574c();
                        C1341p.m4658b("AnnounceChange From Server", getClass().getSimpleName());
                        m843a(c0314c);
                        break;
                }
            }
        }
    }
}
