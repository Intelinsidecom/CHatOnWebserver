package com.sec.chaton.p055d;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.sec.chaton.chat.C1742go;
import com.sec.chaton.chat.C1755ha;
import com.sec.chaton.chat.background.C1589h;
import com.sec.chaton.chat.background.C1590i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.C2695c;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.msgsend.ChatONMsgEntity;
import com.sec.chaton.msgsend.EnumC2692aj;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p046a.C0826bg;
import com.sec.chaton.p046a.C0852cf;
import com.sec.chaton.p046a.C0858cl;
import com.sec.chaton.p046a.C0867cu;
import com.sec.chaton.p046a.C0883dj;
import com.sec.chaton.p046a.C0902eb;
import com.sec.chaton.p046a.C0922ev;
import com.sec.chaton.p046a.C0966gl;
import com.sec.chaton.p046a.C0976l;
import com.sec.chaton.p046a.C0982r;
import com.sec.chaton.p055d.p056a.C1916ap;
import com.sec.chaton.p055d.p056a.C1917aq;
import com.sec.chaton.p055d.p056a.C1922av;
import com.sec.chaton.p055d.p056a.C1926az;
import com.sec.chaton.p055d.p056a.C1929bb;
import com.sec.chaton.p055d.p056a.C1984dc;
import com.sec.chaton.p055d.p056a.C1988dg;
import com.sec.chaton.p055d.p056a.C1989dh;
import com.sec.chaton.p055d.p056a.C1991dj;
import com.sec.chaton.p055d.p056a.C1993dl;
import com.sec.chaton.p055d.p056a.C1998dq;
import com.sec.chaton.p055d.p056a.C2001dt;
import com.sec.chaton.p055d.p056a.C2007dz;
import com.sec.chaton.p055d.p056a.C2010eb;
import com.sec.chaton.p055d.p056a.C2019ek;
import com.sec.chaton.p055d.p056a.C2037fb;
import com.sec.chaton.p055d.p056a.C2049h;
import com.sec.chaton.p055d.p056a.C2050i;
import com.sec.chaton.p055d.p056a.C2051j;
import com.sec.chaton.p055d.p056a.C2052k;
import com.sec.chaton.p055d.p056a.C2054m;
import com.sec.chaton.p055d.p056a.C2061t;
import com.sec.chaton.p055d.p056a.C2062u;
import com.sec.chaton.p055d.p056a.C2065x;
import com.sec.chaton.p055d.p056a.EnumC1992dk;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p065io.entry.ApplinkMsgEntry;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyTopicChatEntry;
import com.sec.chaton.p067j.C2417af;
import com.sec.chaton.p067j.C2422ak;
import com.sec.chaton.p067j.C2425an;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2466q;
import com.sec.chaton.p067j.InterfaceC2469t;
import com.sec.chaton.p067j.p070c.C2438e;
import com.sec.chaton.p067j.p070c.RunnableC2440g;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.specialbuddy.C4542g;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Timer;
import org.json.JSONException;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.d.w */
/* loaded from: classes.dex */
public class C2142w extends AbstractC2070ac implements InterfaceC2469t {

    /* renamed from: h */
    private static HandlerThread f7747h = null;

    /* renamed from: q */
    private static HashMap<String, C2142w> f7748q = new HashMap<>();

    /* renamed from: z */
    private static int f7749z = 360;

    /* renamed from: A */
    private Handler f7750A;

    /* renamed from: B */
    private Handler f7751B;

    /* renamed from: C */
    private Handler f7752C;

    /* renamed from: a */
    C2466q f7753a;

    /* renamed from: b */
    protected Handler f7754b;

    /* renamed from: i */
    private final Object f7755i;

    /* renamed from: j */
    private final Object f7756j;

    /* renamed from: k */
    private final Object f7757k;

    /* renamed from: l */
    private C2422ak f7758l;

    /* renamed from: m */
    private boolean f7759m;

    /* renamed from: n */
    private boolean f7760n;

    /* renamed from: o */
    private boolean f7761o;

    /* renamed from: p */
    private boolean f7762p;

    /* renamed from: r */
    private Map<Long, C2114bt> f7763r;

    /* renamed from: s */
    private ArrayList<C1589h> f7764s;

    /* renamed from: t */
    private boolean f7765t;

    /* renamed from: u */
    private String f7766u;

    /* renamed from: v */
    private C1755ha f7767v;

    /* renamed from: w */
    private ArrayList<Long> f7768w;

    /* renamed from: x */
    private long f7769x;

    /* renamed from: y */
    private Timer f7770y;

    /* renamed from: a */
    public static void m9597a() {
        if (f7747h == null) {
            f7747h = new HandlerThread("MessageControl");
            f7747h.start();
        } else if (!f7747h.isAlive()) {
            f7747h.start();
        }
    }

    /* renamed from: b */
    public static HandlerThread m9603b() {
        return f7747h;
    }

    /* renamed from: g */
    public C1755ha m9649g() {
        return this.f7767v;
    }

    /* renamed from: a */
    public void m9640a(C1755ha c1755ha) {
        synchronized (this.f7757k) {
            this.f7767v = c1755ha;
        }
    }

    /* renamed from: h */
    public String m9650h() {
        return this.f7766u;
    }

    /* renamed from: b */
    public boolean m9646b(String str) {
        if (m9613f(this.f7766u) || !m9613f(str)) {
            return false;
        }
        mo9244a(str);
        return true;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public void mo9244a(String str) {
        synchronized (this.f7756j) {
            this.f7766u = str;
        }
    }

    /* renamed from: i */
    public long m9651i() {
        return this.f7769x;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: b */
    public void mo9266b(long j) {
        this.f7769x = j;
    }

    /* renamed from: c */
    public void m9647c(long j) {
        if (this.f7769x <= 0 && j > 0) {
            this.f7769x = j;
        }
    }

    /* renamed from: j */
    public C2422ak m9652j() {
        return this.f7758l;
    }

    /* renamed from: a */
    private boolean m9600a(C1589h c1589h, boolean z) {
        EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(c1589h.m8461f());
        if (enumC2214abM10070a != null) {
            long jM8464i = c1589h.m8464i();
            if (EnumC2214ab.TEXT == enumC2214abM10070a || EnumC2214ab.LIVESHARE == enumC2214abM10070a || EnumC2214ab.LIVERECOMMEND == enumC2214abM10070a || EnumC2214ab.LIVECONTENTS == enumC2214abM10070a || EnumC2214ab.APPLINK == enumC2214abM10070a || EnumC2214ab.GLYMPSE == enumC2214abM10070a || EnumC2214ab.HUGEFILE == enumC2214abM10070a) {
                if (jM8464i != -1) {
                    m9215a(jM8464i, this.f7551c, enumC2214abM10070a, EnumC2300t.m10207a(c1589h.m8460e()), this.f7766u, c1589h.m8459d(), c1589h.m8462g(), z, c1589h.m8465j());
                } else if (z) {
                    m9625a(this.f7551c, enumC2214abM10070a, EnumC2300t.m10207a(c1589h.m8460e()), c1589h.m8459d(), c1589h.m8462g(), (String) null, c1589h.m8465j(), jM8464i);
                } else {
                    m9259b(enumC2214abM10070a, EnumC2300t.m10207a(c1589h.m8460e()), this.f7766u, c1589h.m8459d(), c1589h.m8462g(), (String) null, c1589h.m8465j(), EnumC2706n.f9699d);
                    if (C2717y.m11398b()) {
                        C2684ab.m11290a("MessageControl", "sendBufferedMessage(), SHOULD NOT BE HAPPENED HERE !! (TEXT) : No Msg ID? ", new Object[0]);
                    }
                }
            } else if (EnumC2214ab.GEO == enumC2214abM10070a) {
                if (jM8464i != -1) {
                    m9207a(jM8464i, EnumC2300t.m10207a(c1589h.m8460e()), this.f7766u, c1589h.m8459d(), z, c1589h.m8462g(), c1589h.m8465j());
                } else {
                    m9263b(EnumC2300t.m10207a(c1589h.m8460e()), this.f7766u, c1589h.m8459d(), z, c1589h.m8462g(), c1589h.m8465j(), c1589h.m8468m(), EnumC2706n.f9699d);
                    if (C2717y.m11398b()) {
                        C2684ab.m11290a("MessageControl", "sendBufferedMessage(), SHOULD NOT BE HAPPENED HERE !! (GEO) : No Msg ID? ", new Object[0]);
                    }
                }
            } else if (EnumC2214ab.ANICON == enumC2214abM10070a) {
                m9643b(c1589h.m8464i(), EnumC2300t.m10207a(c1589h.m8460e()), this.f7766u, c1589h.m8459d(), z, c1589h.m8462g(), c1589h.m8465j(), c1589h.m8468m());
            } else {
                m9598a(c1589h.m8464i(), c1589h.m8466k(), enumC2214abM10070a, EnumC2300t.m10207a(c1589h.m8460e()), this.f7766u, c1589h.m8459d(), z, c1589h.m8462g(), c1589h.m8467l(), c1589h.m8468m(), c1589h.m8469n());
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m9609c(boolean z) {
        if (z) {
            synchronized (this.f7755i) {
                if (this.f7765t) {
                    this.f7765t = false;
                    if (this.f7764s.size() > 0) {
                        Iterator<C1589h> it = this.f7764s.iterator();
                        while (it.hasNext()) {
                            m9600a(it.next(), false);
                        }
                        this.f7764s.clear();
                    }
                }
            }
            return;
        }
        synchronized (this.f7755i) {
            if (this.f7765t) {
                if (this.f7764s.size() > 0) {
                    m9600a(this.f7764s.remove(0), true);
                } else {
                    this.f7765t = false;
                }
            }
        }
    }

    public C2142w(String str, EnumC2300t enumC2300t) {
        super(str, enumC2300t);
        this.f7759m = false;
        this.f7760n = false;
        this.f7761o = false;
        this.f7762p = false;
        this.f7763r = new HashMap();
        this.f7764s = new ArrayList<>();
        this.f7765t = false;
        this.f7768w = new ArrayList<>();
        this.f7750A = new HandlerC2143x(this, m9603b().getLooper());
        this.f7751B = new HandlerC2144y(this, m9603b().getLooper());
        this.f7752C = new HandlerC2145z(this, m9603b().getLooper());
        this.f7753a = new C2466q(this.f7752C, this);
        this.f7755i = new Object();
        this.f7756j = new Object();
        this.f7757k = new Object();
        this.f7770y = null;
    }

    /* renamed from: a */
    public static synchronized C2142w m9593a(String str, EnumC2300t enumC2300t) {
        if (!f7748q.containsKey(str)) {
            f7748q.put(str, new C2142w(str, enumC2300t));
        } else {
            f7748q.get(str).f7551c = str;
            f7748q.get(str).f7553e = str;
            f7748q.get(str).f7552d = enumC2300t;
        }
        return f7748q.get(str);
    }

    /* renamed from: c */
    public static synchronized C2142w m9606c(String str) {
        return f7748q != null ? f7748q.get(str) : null;
    }

    /* renamed from: k */
    public static synchronized void m9614k() {
        Iterator it = new ArrayList(f7748q.values()).iterator();
        while (it.hasNext()) {
            C2142w c2142w = (C2142w) it.next();
            if (c2142w != null) {
                c2142w.m9615t();
            }
        }
    }

    /* renamed from: l */
    public void m9653l() {
        this.f7758l.m10487a(6, this.f7753a);
        this.f7758l.m10487a(34, this.f7753a);
        this.f7758l.m10487a(36, this.f7753a);
        this.f7758l.m10487a(10, this.f7753a);
        this.f7758l.m10487a(46, this.f7753a);
        this.f7758l.m10487a(14, this.f7753a);
        this.f7758l.m10487a(16, this.f7753a);
        this.f7758l.m10487a(24, this.f7753a);
        this.f7758l.m10487a(9999, this.f7753a);
        this.f7758l.m10487a(48, this.f7753a);
        this.f7758l.m10487a(51, this.f7753a);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9240a(String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String[] strArr, String str2, String str3) {
        return m9627a(str, enumC2214ab, enumC2300t, strArr, str2, str3, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9625a(String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String[] strArr, String str2, String str3, long j, long j2) {
        return m9626a(str, enumC2214ab, enumC2300t, strArr, str2, str3, j, j2, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9627a(String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String[] strArr, String str2, String str3, EnumC2706n enumC2706n) {
        return m9626a(str, enumC2214ab, enumC2300t, strArr, str2, str3, -1L, -1L, enumC2706n);
    }

    /* renamed from: a */
    public long m9626a(String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String[] strArr, String str2, String str3, long j, long j2, EnumC2706n enumC2706n) {
        C2114bt c2114bt;
        C4904y.m18639b("initChatRoom", getClass().getSimpleName());
        if (-1 == j2) {
            j2 = C4843bh.m18322a();
            int i = 0;
            if (!enumC2706n.m11326a() && C2717y.m11398b()) {
                i = 6;
            }
            C2204r.m10016a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(j2), str, enumC2214ab, str2, str3, strArr.length, i);
        }
        long j3 = j2;
        String str4 = !TextUtils.isEmpty(str3) ? str3 : str2;
        if (enumC2300t != EnumC2300t.BROADCAST) {
            synchronized (this.f7755i) {
                if (this.f7765t) {
                    C1590i c1590i = new C1590i();
                    c1590i.m8476a(strArr).m8477b(enumC2300t.m10210a()).m8480c(enumC2214ab.m10076a()).m8478b(j3).m8479b(str4).m8474a(enumC2706n);
                    if (j != -1) {
                        c1590i.m8481c(j);
                    } else {
                        c1590i.m8481c(C4843bh.m18322a());
                    }
                    C1589h c1589hMo8471a = c1590i.mo8471a();
                    this.f7764s.add(c1589hMo8471a);
                    return c1589hMo8471a.m8465j();
                }
                this.f7765t = true;
            }
        }
        if (j != -1) {
            c2114bt = new C2114bt(this.f7752C, this.f7758l, j);
        } else {
            c2114bt = new C2114bt(this.f7752C, this.f7758l);
        }
        c2114bt.m9454a(EnumC2118bx.NetTask, new C1984dc(c2114bt.m9455b(), str, j3, enumC2214ab, enumC2300t, strArr, str4, enumC2706n));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9247a(EnumC2300t enumC2300t, String str, Long l, String str2, String str3, long j) {
        return mo9248a(enumC2300t, str, l, str2, str3, j, false);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9248a(EnumC2300t enumC2300t, String str, Long l, String str2, String str3, long j, boolean z) {
        if (!z && C2417af.m10453b(this.f7758l)) {
            if (enumC2300t == EnumC2300t.GROUPCHAT) {
                C2134o.m9570a(this.f7751B, str3, str2, j);
            } else if (enumC2300t == EnumC2300t.TOPIC) {
                C2134o.m9571a(this.f7751B, str3, str2, j, true);
            }
            return false;
        }
        Long lValueOf = Long.valueOf(C4843bh.m18322a());
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C2049h(c2114bt.m9455b(), enumC2300t, str3, str, lValueOf.longValue(), str2));
        if (enumC2300t == EnumC2300t.GROUPCHAT) {
            C2134o.m9570a(this.f7751B, str3, str2, j);
        } else if (enumC2300t == EnumC2300t.TOPIC) {
            C2134o.m9571a(this.f7751B, str3, str2, j, true);
        }
        c2114bt.m9457d();
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        this.f7762p = true;
        return true;
    }

    /* renamed from: a */
    public void m9631a(C0826bg c0826bg) {
        C4904y.m18639b("makeDeliveryChatReply", getClass().getSimpleName());
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C1917aq(c2114bt.m9455b(), this.f7551c, c0826bg, this));
        c2114bt.m9457d();
    }

    /* renamed from: a */
    public void m9632a(C0852cf c0852cf) {
        C4904y.m18639b("makeForwardOnlineMessageReply", getClass().getSimpleName());
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C1926az(c2114bt.m9455b(), this.f7551c, c0852cf, this));
        c2114bt.m9457d();
    }

    /* renamed from: a */
    public void m9633a(C0858cl c0858cl) {
        C4904y.m18639b("makeForwardStoredMessageReply", getClass().getSimpleName());
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C1929bb(c2114bt.m9455b(), this.f7551c, c0858cl, this));
        c2114bt.m9457d();
    }

    /* renamed from: a */
    public long m9624a(SpecialBuddyTopicChatEntry specialBuddyTopicChatEntry) {
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C1993dl(c2114bt.m9455b(), specialBuddyTopicChatEntry));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9227a(EnumC2300t enumC2300t, String str) {
        if (enumC2300t == EnumC2300t.TOPIC) {
            if (C4904y.f17873c) {
                C4904y.m18641c("!topic chat! Do not request readmessage task", "MessageControl");
            }
            return -1L;
        }
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C2010eb(c2114bt.m9455b(), enumC2300t, str, this.f7551c));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    /* renamed from: a */
    public long m9630a(List<C0867cu> list, EnumC2300t enumC2300t, String str) {
        if (enumC2300t == EnumC2300t.TOPIC) {
            if (C4904y.f17873c) {
                C4904y.m18641c("!topic chat! Do not request readmessage task", "MessageControl");
            }
            return -1L;
        }
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C2010eb(list, c2114bt.m9455b(), enumC2300t, str, this.f7551c));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    /* renamed from: b */
    public void m9644b(EnumC2300t enumC2300t, String str) {
        C4904y.m18639b("sendDeliveryChatReply", getClass().getSimpleName());
        C1742go c1742goM8667b = C1742go.m8667b(this.f7551c);
        if (!C2417af.m10450a(this.f7758l)) {
            c1742goM8667b.m8668a();
        } else if (!c1742goM8667b.m8671b()) {
            new C1916ap(this.f7754b, this.f7551c, enumC2300t, str).m9103a(this.f7758l);
        }
    }

    /* renamed from: a */
    public void m9638a(C0976l c0976l) {
        if (c0976l != null) {
            C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
            c2114bt.m9454a(EnumC2118bx.NetTask, new C2051j(c2114bt.m9455b(), c0976l, this.f7551c));
            c2114bt.m9457d();
        }
    }

    /* renamed from: a */
    protected void m9634a(C0883dj c0883dj) {
        if (c0883dj != null) {
            C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
            c2114bt.m9454a(EnumC2118bx.NetTask, new C1989dh(c2114bt.m9455b(), c0883dj, this.f7551c));
            c2114bt.m9457d();
        }
    }

    /* renamed from: a */
    protected void m9636a(C0922ev c0922ev) {
        if (c0922ev != null) {
            C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
            c2114bt.m9454a(EnumC2118bx.NetTask, new C2007dz(c2114bt.m9455b(), c0922ev));
            c2114bt.m9457d();
        }
    }

    /* renamed from: a */
    protected void m9637a(C0966gl c0966gl) {
        if (c0966gl != null) {
            C4904y.m18639b("makeUndoMessageReply", getClass().getSimpleName());
            C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
            c2114bt.m9454a(EnumC2118bx.NetTask, new C2037fb(c2114bt.m9455b(), c0966gl));
            c2114bt.m9457d();
        }
    }

    /* renamed from: a */
    public long m9622a(EnumC2300t enumC2300t, String str, String[] strArr, ArrayList<ChatONMsgEntity> arrayList) {
        return m9623a(enumC2300t, str, strArr, arrayList, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9623a(EnumC2300t enumC2300t, String str, String[] strArr, ArrayList<ChatONMsgEntity> arrayList, EnumC2706n enumC2706n) {
        if (arrayList == null || arrayList.isEmpty()) {
            return -1L;
        }
        C4904y.m18639b("doSendBulkMessage", getClass().getSimpleName());
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        C2695c c2695cM11303a = C2695c.m11303a();
        Iterator<ChatONMsgEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            c2695cM11303a.m11306a(it.next());
        }
        c2114bt.m9454a(EnumC2118bx.NetTask, new C2019ek(c2114bt.m9455b(), C4843bh.m18322a(), this.f7551c, enumC2300t, str, strArr, c2695cM11303a, enumC2706n));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        C2204r.m9998a(GlobalApplication.m18732r().getContentResolver(), c2695cM11303a, EnumC2692aj.SENDING);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    /* renamed from: a */
    public long m9620a(EnumC2214ab enumC2214ab, String[] strArr, String str, EnumC2706n enumC2706n, long j, EnumC2301u enumC2301u) {
        C4904y.m18639b("requestSendMessageWithoutInsertion()", getClass().getSimpleName());
        int i = 0;
        if (!enumC2706n.m11326a() && C2717y.m11398b()) {
            i = 6;
        }
        if (!enumC2706n.m11326a() && C2717y.m11395a(enumC2301u)) {
            C2716x.m11372a(enumC2301u, this.f7551c, this.f7552d, j, enumC2214ab, str, null, EnumC2692aj.m11301a(i), strArr);
            return j;
        }
        if (!m9613f(this.f7766u) && enumC2301u == EnumC2301u.NORMAL) {
            if (this.f7552d != EnumC2300t.BROADCAST) {
                m9242a(0, 0, 9000, (Object) null, -1L);
            }
            return mo9240a(this.f7551c, enumC2214ab, this.f7552d, strArr, str, (String) null);
        }
        return m9592a(j, enumC2214ab, this.f7552d, this.f7766u, strArr, str, -1L, enumC2706n);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9221a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) {
        String str4 = !TextUtils.isEmpty(str3) ? str3 : str2;
        C4904y.m18639b("requestSendMessage", getClass().getSimpleName());
        long jM18322a = C4843bh.m18322a();
        int i = 0;
        if (!enumC2706n.m11326a() && C2717y.m11398b()) {
            i = 6;
        }
        C2204r.m10016a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(jM18322a), this.f7551c, enumC2214ab, str2, str3, strArr.length, i);
        if (enumC2706n.m11326a() || !C2717y.m11398b()) {
            return m9592a(jM18322a, enumC2214ab, enumC2300t, str, strArr, str4, j, enumC2706n);
        }
        C2716x.m11372a(EnumC2301u.NORMAL, this.f7551c, this.f7552d, jM18322a, enumC2214ab, str4, null, EnumC2692aj.m11301a(i), strArr);
        return jM18322a;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9222a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n, String str4, String str5) {
        String str6 = !TextUtils.isEmpty(str3) ? str3 : str2;
        C4904y.m18639b("requestSendMessage", getClass().getSimpleName());
        long jM18322a = C4843bh.m18322a();
        int i = 0;
        if (!enumC2706n.m11326a() && C2717y.m11398b()) {
            i = 6;
        }
        C2204r.m10017a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(jM18322a), this.f7551c, enumC2214ab, str2, str3, strArr.length, i, str4, str5);
        if (enumC2706n.m11326a() || !C2717y.m11398b()) {
            return m9592a(jM18322a, enumC2214ab, enumC2300t, str, strArr, str6, j, enumC2706n);
        }
        C2716x.m11372a(EnumC2301u.NORMAL, this.f7551c, this.f7552d, jM18322a, enumC2214ab, str6, null, EnumC2692aj.m11301a(i), strArr);
        return jM18322a;
    }

    /* renamed from: a */
    private long m9592a(long j, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, long j2, EnumC2706n enumC2706n) {
        C2114bt c2114bt;
        C4904y.m18639b("doSendMessage", getClass().getSimpleName());
        if (j2 != -1) {
            c2114bt = new C2114bt(this.f7752C, this.f7758l, j2);
        } else {
            c2114bt = new C2114bt(this.f7752C, this.f7758l);
        }
        c2114bt.m9454a(EnumC2118bx.NetTask, new C2065x(c2114bt.m9455b(), j, this.f7551c, enumC2214ab, enumC2300t, str, str2, strArr, enumC2706n));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9245a(long j, String str, String str2, String str3, EnumC2214ab enumC2214ab, String str4, int i, String[] strArr) {
        File file;
        String str5;
        String strNextToken = "";
        String str6 = this.f7551c;
        if (enumC2214ab == EnumC2214ab.TEXT || enumC2214ab == EnumC2214ab.GEO || enumC2214ab == EnumC2214ab.ANICON || enumC2214ab == EnumC2214ab.POLL || enumC2214ab == EnumC2214ab.APPLINK || enumC2214ab == EnumC2214ab.LIVERECOMMEND || enumC2214ab == EnumC2214ab.LIVESHARE || enumC2214ab == EnumC2214ab.LIVECONTENTS || enumC2214ab == EnumC2214ab.GLYMPSE || enumC2214ab == EnumC2214ab.HUGEFILE) {
            file = null;
            str5 = "";
        } else {
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            File file2 = new File(Uri.parse(str3).getPath());
            StringTokenizer stringTokenizer = new StringTokenizer(str3, ".");
            while (stringTokenizer.hasMoreTokens()) {
                strNextToken = stringTokenizer.nextToken();
            }
            file = file2;
            str5 = "." + strNextToken.toUpperCase();
        }
        boolean z = false;
        if (!m9613f(this.f7766u)) {
            if (this.f7552d != EnumC2300t.BROADCAST) {
            }
            z = true;
        }
        if (enumC2214ab == EnumC2214ab.TEXT || enumC2214ab == EnumC2214ab.LIVERECOMMEND || enumC2214ab == EnumC2214ab.LIVESHARE || enumC2214ab == EnumC2214ab.LIVECONTENTS || enumC2214ab == EnumC2214ab.GLYMPSE || enumC2214ab == EnumC2214ab.HUGEFILE) {
            m9214a(j, str6, enumC2214ab, this.f7552d, this.f7766u, strArr, str, z);
        } else if (enumC2214ab == EnumC2214ab.GEO) {
            m9206a(j, this.f7552d, this.f7766u, strArr, z, str);
        } else if (enumC2214ab == EnumC2214ab.ANICON) {
            String[] strArr2 = new String[0];
            String[] strArrSplit = str.split("\n");
            String strM13781c = C3460d.m13781c(strArrSplit[2]);
            if (strArrSplit.length > 6 && "mixed".equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 6; i2 < strArrSplit.length; i2++) {
                    stringBuffer.append(strArrSplit[i2] + "\n");
                }
                m9269c(j, this.f7552d, this.f7766u, strArr, z, strM13781c, -1L, stringBuffer.toString().substring(0, stringBuffer.length() - 1));
            } else {
                m9269c(j, this.f7552d, this.f7766u, strArr, z, strM13781c, -1L, null);
            }
        } else if (enumC2214ab == EnumC2214ab.APPLINK) {
            m9254b(j, this.f7552d, this.f7766u, strArr, str);
        } else if (enumC2214ab == EnumC2214ab.POLL) {
            m9204a(j, this.f7552d, this.f7766u, strArr, str);
        } else {
            boolean z2 = false;
            if (i == 1 && C1998dq.m9146a(str)) {
                z2 = true;
            }
            if (z2) {
                m9202a(j, this.f7552d, str, this.f7766u, strArr, z, str4, str5, enumC2214ab);
            } else {
                if (file == null) {
                    return false;
                }
                String strSubstring = null;
                if (str != null) {
                    String[] strArrSplit2 = str.split("\n");
                    if (strArrSplit2.length > 6) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        for (int i3 = 6; i3 < strArrSplit2.length; i3++) {
                            stringBuffer2.append(strArrSplit2[i3] + "\n");
                        }
                        strSubstring = stringBuffer2.toString().substring(0, stringBuffer2.length() - 1);
                    }
                }
                m9212a(j, file, (String) null, enumC2214ab, this.f7552d, this.f7766u, strArr, z, str4, strSubstring);
            }
        }
        return true;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9229a(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C4904y.f17872b) {
                C4904y.m18634a("chatMsg is null or recipients is null", "MessageControl");
            }
            return -1L;
        }
        try {
            String string = ApplinkMsgEntry.createJson(str2, str3).toString();
            if (TextUtils.isEmpty(str) && (enumC2706n.m11326a() || !C2717y.m11398b())) {
                return m9626a(this.f7551c, EnumC2214ab.APPLINK, enumC2300t, strArr, string, (String) null, j, -1L, enumC2706n);
            }
            return m9259b(EnumC2214ab.APPLINK, enumC2300t, str, strArr, string, (String) null, j, enumC2706n);
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "MessageControl");
            }
            return -1L;
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: b */
    public long mo9262b(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) throws JSONException {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C4904y.f17872b) {
                C4904y.m18634a("requestSendLiveShare(), chatMsg is null or recipients is null", "MessageControl");
            }
            return -1L;
        }
        String strM17236b = C4542g.m17236b(str2);
        if (TextUtils.isEmpty(strM17236b)) {
            C4904y.m18634a("requestSendLiveShare(), failed in converting chat msg : " + str2, "MessageControl");
            return -1L;
        }
        if (TextUtils.isEmpty(str) && (enumC2706n.m11326a() || !C2717y.m11398b())) {
            return m9626a(this.f7551c, EnumC2214ab.LIVESHARE, enumC2300t, strArr, strM17236b, (String) null, j, -1L, enumC2706n);
        }
        return m9259b(EnumC2214ab.LIVESHARE, enumC2300t, str, strArr, strM17236b, (String) null, j, enumC2706n);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: c */
    public long mo9271c(EnumC2300t enumC2300t, String str, String[] strArr, String str2, String str3, long j, EnumC2706n enumC2706n) throws JSONException {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C4904y.f17872b) {
                C4904y.m18634a("requestSendLiveRecommend(), chatMsg is null or recipients is null", "MessageControl");
            }
            return -1L;
        }
        String strM17241f = C4542g.m17241f(str2);
        if (TextUtils.isEmpty(strM17241f)) {
            C4904y.m18634a("requestSendLiveRecommend(), failed in converting chat msg : " + str2, "MessageControl");
            return -1L;
        }
        if (TextUtils.isEmpty(str) && (enumC2706n.m11326a() || !C2717y.m11398b())) {
            return m9626a(this.f7551c, EnumC2214ab.LIVERECOMMEND, enumC2300t, strArr, strM17241f, (String) null, j, -1L, enumC2706n);
        }
        return m9259b(EnumC2214ab.LIVERECOMMEND, enumC2300t, str, strArr, strM17241f, (String) null, j, enumC2706n);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9219a(EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str, String[] strArr, String str2, long j, EnumC2706n enumC2706n) {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C4904y.f17872b) {
                C4904y.m18634a("requestSendMediaChatImpl(), chatMsg is null or recipients is null", "MessageControl");
            }
            return -1L;
        }
        if (TextUtils.isEmpty(str) && (enumC2706n.m11326a() || !C2717y.m11398b())) {
            return m9626a(this.f7551c, enumC2214ab, enumC2300t, strArr, str2, (String) null, j, -1L, enumC2706n);
        }
        return m9259b(enumC2214ab, enumC2300t, str, strArr, str2, (String) null, j, enumC2706n);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9231a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j, String str3, EnumC2706n enumC2706n) {
        String str4;
        if (TextUtils.isEmpty(str2) || str2.startsWith("geo") || str2.startsWith("mixed")) {
            str4 = str2;
        } else if (TextUtils.isEmpty(str3)) {
            str4 = "geo\n\n\n\n\n" + str2;
        } else {
            str4 = "mixed\ngeo\n\n\n\n" + str2 + "\n" + str3;
        }
        long jM18322a = C4843bh.m18322a();
        int i = 0;
        if (C2717y.m11398b() && !enumC2706n.m11326a()) {
            i = 6;
        }
        C2204r.m10016a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(jM18322a), this.f7551c, EnumC2214ab.GEO, str4, (String) null, strArr.length, i);
        if (C2717y.m11398b() && !enumC2706n.m11326a()) {
            C2716x.m11372a(EnumC2301u.NORMAL, this.f7551c, this.f7552d, jM18322a, EnumC2214ab.GEO, str4, null, EnumC2692aj.m11301a(i), strArr);
            return jM18322a;
        }
        return m9617a(jM18322a, enumC2300t, str, strArr, z, str2, j, str3, str4, enumC2706n);
    }

    /* renamed from: a */
    public long m9617a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, String str3, String str4, EnumC2706n enumC2706n) {
        C2114bt c2114bt;
        if (z && enumC2300t != EnumC2300t.BROADCAST) {
            synchronized (this.f7755i) {
                if (this.f7765t) {
                    C1590i c1590i = new C1590i();
                    c1590i.m8476a(strArr).m8477b(enumC2300t.m10210a()).m8480c(EnumC2214ab.GEO.m10076a()).m8479b(str2).m8485f(str3);
                    if (j2 != -1) {
                        c1590i.m8481c(j2);
                    } else {
                        c1590i.m8481c(C4843bh.m18322a());
                    }
                    C1589h c1589hMo8471a = c1590i.mo8471a();
                    this.f7764s.add(c1589hMo8471a);
                    return c1589hMo8471a.m8465j();
                }
                this.f7765t = true;
            }
        }
        if (j2 != -1) {
            c2114bt = new C2114bt(this.f7752C, this.f7758l, j2);
        } else {
            c2114bt = new C2114bt(this.f7752C, this.f7758l);
        }
        if (!TextUtils.isEmpty(str4) && !str4.startsWith("geo") && !str4.startsWith("mixed")) {
            C2684ab.m11290a("MessageControl", "doSendGeoTag(), ERROR : SEND GEO", str4);
            C2684ab.m11290a("MessageControl", "doSendGeoTag(), ERROR : SEND GEO", str4);
            C2684ab.m11290a("MessageControl", "doSendGeoTag(), ERROR : SEND GEO", str4);
            return -1L;
        }
        c2114bt.m9454a(EnumC2118bx.NetTask, new C1998dq(c2114bt.m9455b(), this.f7551c, j, "", EnumC2214ab.GEO, enumC2300t, str, strArr, "", z, str4, null, enumC2706n));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9208a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, EnumC2706n enumC2706n) {
        C2114bt c2114bt;
        if (z && enumC2300t != EnumC2300t.BROADCAST) {
            synchronized (this.f7755i) {
                if (this.f7765t) {
                    C1590i c1590i = new C1590i();
                    c1590i.m8476a(strArr).m8477b(enumC2300t.m10210a()).m8480c(EnumC2214ab.GEO.m10076a()).m8479b(str2).m8478b(j).m8474a(enumC2706n);
                    if (j2 != -1) {
                        c1590i.m8481c(j2);
                    } else {
                        c1590i.m8481c(C4843bh.m18322a());
                    }
                    C1589h c1589hMo8471a = c1590i.mo8471a();
                    this.f7764s.add(c1589hMo8471a);
                    return c1589hMo8471a.m8465j();
                }
                this.f7765t = true;
            }
        }
        if (j2 != -1) {
            c2114bt = new C2114bt(this.f7752C, this.f7758l, j2);
        } else {
            c2114bt = new C2114bt(this.f7752C, this.f7758l);
        }
        C2114bt c2114bt2 = c2114bt;
        c2114bt2.m9454a(EnumC2118bx.NetTask, new C1998dq(c2114bt.m9455b(), this.f7551c, j, "", EnumC2214ab.GEO, enumC2300t, str, strArr, "", z, str2, null, enumC2706n));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        C2204r.m10056e(GlobalApplication.m18732r().getContentResolver(), Long.valueOf(j));
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9216a(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, String str3, boolean z, long j2, EnumC2706n enumC2706n) {
        C2114bt c2114bt;
        if (C4904y.f17872b) {
            C4904y.m18639b("reSend", getClass().getSimpleName());
        }
        if (z && enumC2300t != EnumC2300t.BROADCAST) {
            synchronized (this.f7755i) {
                if (this.f7765t) {
                    C1590i c1590i = new C1590i();
                    c1590i.m8476a(strArr).m8477b(enumC2300t.m10210a()).m8480c(enumC2214ab.m10076a()).m8479b(str3).m8478b(j).m8474a(enumC2706n);
                    if (j2 != -1) {
                        c1590i.m8481c(j2);
                    } else {
                        c1590i.m8481c(C4843bh.m18322a());
                    }
                    C1589h c1589hMo8471a = c1590i.mo8471a();
                    this.f7764s.add(c1589hMo8471a);
                    return c1589hMo8471a.m8465j();
                }
                this.f7765t = true;
            }
        }
        if (j2 != -1) {
            c2114bt = new C2114bt(this.f7752C, this.f7758l, j2);
        } else {
            c2114bt = new C2114bt(this.f7752C, this.f7758l);
        }
        if (z) {
            switch (C2069ab.f7549a[enumC2300t.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    C2204r.m10056e(CommonApplication.m18732r().getContentResolver(), Long.valueOf(j));
                    break;
            }
            c2114bt.m9454a(EnumC2118bx.NetTask, new C1984dc(c2114bt.m9455b(), str, j, enumC2214ab, enumC2300t, strArr, str3, enumC2706n));
        } else {
            switch (C2069ab.f7549a[enumC2300t.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    C2204r.m10056e(CommonApplication.m18732r().getContentResolver(), Long.valueOf(j));
                    break;
            }
            c2114bt.m9454a(EnumC2118bx.NetTask, new C2065x(c2114bt.m9455b(), j, this.f7551c, enumC2214ab, enumC2300t, str2, str3, strArr, enumC2706n));
        }
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9238a(File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC2706n enumC2706n, String str6, String str7) throws Throwable {
        String strSubstring;
        long jM18322a = C4843bh.m18322a();
        String strDecode = Uri.decode(Uri.fromFile(file).toString());
        String strM10587a = RunnableC2440g.m10587a(file, enumC2214ab);
        if (strM10587a == null) {
            C2684ab.m11290a("MessageControl", "requestSendFile(), FILE Extention : forced to be '%s' with parameter", str);
            strM10587a = str;
        }
        if (!C4894o.m18609a(enumC2214ab, strM10587a) || file.length() > 31457280) {
            C2684ab.m11290a("MessageControl", "requestSendFile(), not support ext. or excess limited size", new Object[0]);
            return -1L;
        }
        String strM18603a = null;
        if (C4873ck.m18500a()) {
            String str8 = GlobalApplication.m18732r().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f7551c;
            if (!file.getAbsolutePath().contains(str8)) {
                String strValueOf = String.valueOf(System.currentTimeMillis());
                if (file.getName().indexOf(".") > -1) {
                    strSubstring = file.getName().substring(file.getName().lastIndexOf("."));
                } else if (strM10587a == null) {
                    strSubstring = "";
                } else {
                    strSubstring = "." + strM10587a;
                }
                strM18603a = C4894o.m18603a(file.getAbsolutePath(), str8, strValueOf + strSubstring);
            }
        }
        if (strM18603a != null) {
            file = new File(Uri.parse(strM18603a).getPath());
        } else {
            strM18603a = strDecode;
        }
        if (TextUtils.isEmpty(strM18603a)) {
            C2684ab.m11290a("MessageControl", "requestSendFile(), invalid Local File URI", new Object[0]);
            return -1L;
        }
        String str9 = "\n\n\n\n\n\n";
        if (!TextUtils.isEmpty(str4)) {
            str9 = "mixed\n\n\n\n\n\n" + str4;
        }
        int i = 0;
        if (!enumC2706n.m11326a() && C2717y.m11398b()) {
            i = 6;
        }
        C2204r.m10015a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(jM18322a), this.f7551c, enumC2214ab, strM18603a, strArr.length, str9, i, str5, str6, str7);
        String strM18613b = enumC2214ab == EnumC2214ab.AUDIO ? C4894o.m18613b(strM18603a) : str3;
        switch (C2069ab.f7550b[enumC2214ab.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (TextUtils.isEmpty(strM18613b)) {
                    return -1L;
                }
                C2204r.m10030a(GlobalApplication.m18732r().getContentResolver(), this.f7551c, Long.valueOf(jM18322a), strM18613b);
                break;
        }
        if (!enumC2706n.m11326a() && C2717y.m11398b()) {
            C2716x.m11373a(EnumC2301u.NORMAL, this.f7551c, enumC2300t, jM18322a, enumC2214ab, str9, str5, EnumC2692aj.m11301a(i), strArr, strM18613b, 0, strM18603a);
            return jM18322a;
        }
        return m9619a(jM18322a, file, str, enumC2214ab, enumC2300t, str2, strArr, z, strM18613b, str4, str5, true, enumC2706n);
    }

    /* renamed from: a */
    public long m9619a(long j, File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, boolean z2, EnumC2706n enumC2706n) {
        C2438e.m10572a().m10576a(this.f7750A, str2, file, j, this.f7551c, enumC2300t, enumC2214ab, str, strArr, str3, false, str4, str5, z2, enumC2706n);
        return j;
    }

    /* renamed from: a */
    private boolean m9598a(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, String str6) {
        return m9599a(j, str, enumC2214ab, enumC2300t, str2, strArr, z, str3, str4, str5, str6, EnumC2706n.f9699d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m9599a(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, String str6, EnumC2706n enumC2706n) {
        C2684ab.m11290a("MessageControl", "doSendFileInternal(), msgId(%d), extension(%s), msgType(%s), chatType(%s), sessionId(%s), isInit(%s), message(%s), result(%s), extraChat(%s), ignoreAutoResend(%s)", Long.valueOf(j), str, enumC2214ab, enumC2300t, str2, Boolean.valueOf(z), str3, str4, str5, enumC2706n);
        if (TextUtils.isEmpty(str4)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("result is null", "MessageControl");
            }
            return false;
        }
        if (z && enumC2300t != EnumC2300t.BROADCAST) {
            synchronized (this.f7755i) {
                if (this.f7765t) {
                    C1590i c1590i = new C1590i();
                    c1590i.m8476a(strArr).m8477b(enumC2300t.m10210a()).m8480c(enumC2214ab.m10076a()).m8479b(str3).m8478b(j).m8481c(j).m8484e(str4).m8483d(str).m8485f(str5).m8486g(str6).m8474a(enumC2706n);
                    this.f7764s.add(c1590i.mo8471a());
                    return true;
                }
                this.f7765t = true;
            }
        }
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C1998dq(c2114bt.m9455b(), this.f7551c, j, str, enumC2214ab, enumC2300t, str2, strArr, str4, z, str3, str5, str6, enumC2706n));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return true;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9213a(long j, File file, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC2706n enumC2706n) {
        C2438e.m10572a().m10575a(this.f7750A, str2, file, j, this.f7551c, enumC2300t, enumC2214ab, str, strArr, str3, true, str4, str5, enumC2706n);
        return j;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9203a(long j, EnumC2300t enumC2300t, String str, String str2, String[] strArr, boolean z, String str3, String str4, EnumC2214ab enumC2214ab, EnumC2706n enumC2706n) {
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
                C2204r.m10056e(CommonApplication.m18732r().getContentResolver(), Long.valueOf(j));
                return m9618a(j, this.f7552d, this.f7766u, strArr, z, str3, (File) null, str4, strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4], enumC2214ab, strSubstring, enumC2706n);
            }
        }
        return -1L;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9251a(File file, boolean z, String str, String str2, String str3, EnumC2214ab enumC2214ab, ArrayList<String> arrayList, EnumC2706n enumC2706n) throws Throwable {
        String string;
        String strM18603a = C4894o.m18603a(file.getAbsolutePath(), GlobalApplication.m10279a().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f7551c, file.getName());
        Long lValueOf = Long.valueOf(C4843bh.m18322a());
        String[] strArrSplit = str.split("\n");
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        int length = strArrSplit.length;
        if (length < 5) {
            C2684ab.m11290a("MessageControl", "requestSendMediaChatForward(), token length is too short (%d)", Integer.valueOf(length));
            return false;
        }
        String str4 = length > 5 ? strArrSplit[5] : null;
        String str5 = strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4];
        if (str3 != null) {
            StringBuilder sb = new StringBuilder();
            if (length == 5) {
                for (int i = 0; i < 5; i++) {
                    sb.append(strArrSplit[i] + "\n");
                }
                sb.append("\n");
            } else {
                for (int i2 = 0; i2 < 6; i2++) {
                    sb.append(strArrSplit[i2] + "\n");
                }
            }
            sb.append(str3 + "\n");
            string = sb.toString();
        } else {
            string = str;
        }
        int i3 = 0;
        if (!enumC2706n.m11326a() && C2717y.m11398b()) {
            i3 = 6;
        }
        C2204r.m10014a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(lValueOf), this.f7551c, enumC2214ab, strM18603a, arrayList.size(), string, i3, null);
        C2204r.m10055d(GlobalApplication.m18732r().getContentResolver(), lValueOf);
        if (enumC2214ab == EnumC2214ab.CONTACT || enumC2214ab == EnumC2214ab.CALENDAR || enumC2214ab == EnumC2214ab.DOCUMENT || enumC2214ab == EnumC2214ab.FILE) {
            C2204r.m10030a(GlobalApplication.m18732r().getContentResolver(), this.f7551c, lValueOf, str4);
        }
        if (!enumC2706n.m11326a() && C2717y.m11398b()) {
            C2716x.m11373a(EnumC2301u.NORMAL, this.f7551c, this.f7552d, lValueOf.longValue(), enumC2214ab, string, (String) null, EnumC2692aj.PENDING, strArr, str4, 1, Uri.decode(Uri.fromFile(file).toString()));
            C2716x.m11380a(this.f7551c, lValueOf.longValue(), EnumC2692aj.SENDING, (Integer) 1);
            if (enumC2214ab == EnumC2214ab.CONTACT || enumC2214ab == EnumC2214ab.CALENDAR || enumC2214ab == EnumC2214ab.DOCUMENT || enumC2214ab == EnumC2214ab.FILE) {
                C2716x.m11382a(this.f7551c, lValueOf.longValue(), str4);
            }
        } else {
            m9618a(lValueOf.longValue(), this.f7552d, this.f7766u, strArr, z, str4, file, str2, str5, enumC2214ab, str3, enumC2706n);
        }
        return true;
    }

    /* renamed from: a */
    public long m9618a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, File file, String str3, String str4, EnumC2214ab enumC2214ab, String str5, EnumC2706n enumC2706n) {
        if (z && enumC2300t != EnumC2300t.BROADCAST) {
            synchronized (this.f7755i) {
                if (this.f7765t) {
                    C1590i c1590i = new C1590i();
                    c1590i.m8476a(strArr).m8477b(enumC2300t.m10210a()).m8480c(enumC2214ab.m10076a()).m8479b(str2).m8478b(j).m8481c(j).m8484e(str4).m8485f(str5).m8474a(enumC2706n);
                    this.f7764s.add(c1590i.mo8471a());
                } else {
                    this.f7765t = true;
                    C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
                    c2114bt.m9454a(EnumC2118bx.NetTask, new C1998dq(c2114bt.m9455b(), this.f7551c, j, str3, enumC2214ab, enumC2300t, str, strArr, str4, z, str2, str5, enumC2706n));
                    this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
                    c2114bt.m9457d();
                }
            }
        } else {
            C2114bt c2114bt2 = new C2114bt(this.f7752C, this.f7758l);
            c2114bt2.m9454a(EnumC2118bx.NetTask, new C1998dq(c2114bt2.m9455b(), this.f7551c, j, str3, enumC2214ab, enumC2300t, str, strArr, str4, z, str2, str5, enumC2706n));
            this.f7763r.put(Long.valueOf(c2114bt2.m9452a()), c2114bt2);
            c2114bt2.m9457d();
        }
        return j;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9232a(EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j, String str3, String str4, EnumC2706n enumC2706n, String str5, String str6) {
        String str7 = !TextUtils.isEmpty(str4) ? str4 : str3;
        String strM9183a = C2050i.m9183a(str2, str7);
        long jM18322a = C4843bh.m18322a();
        int i = 0;
        if (!enumC2706n.m11326a() && C2717y.m11398b()) {
            i = 6;
        }
        C2204r.m10017a(GlobalApplication.m18732r().getContentResolver(), String.valueOf(jM18322a), this.f7551c, EnumC2214ab.ANICON, C2050i.m9183a(str2, str3), str4, strArr.length, i, str5, str6);
        if (enumC2706n.m11326a() || !C2717y.m11398b()) {
            return m9616a(jM18322a, enumC2300t, str, strArr, z, str2, j, str7, enumC2706n);
        }
        C2716x.m11372a(EnumC2301u.NORMAL, this.f7551c, this.f7552d, jM18322a, EnumC2214ab.ANICON, strM9183a, null, EnumC2692aj.m11301a(i), strArr);
        return jM18322a;
    }

    /* renamed from: b */
    public long m9643b(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, String str3) {
        return m9616a(j, enumC2300t, str, strArr, z, str2, j2, str3, EnumC2706n.f9699d);
    }

    /* renamed from: a */
    public long m9616a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, String str3, EnumC2706n enumC2706n) {
        C2114bt c2114bt;
        if (z && enumC2300t != EnumC2300t.BROADCAST) {
            synchronized (this.f7755i) {
                if (this.f7765t) {
                    C1590i c1590i = new C1590i();
                    c1590i.m8476a(strArr).m8477b(enumC2300t.m10210a()).m8480c(EnumC2214ab.ANICON.m10076a()).m8478b(j).m8479b(str2).m8485f(str3);
                    if (j2 != -1) {
                        c1590i.m8481c(j2);
                    } else {
                        c1590i.m8481c(C4843bh.m18322a());
                    }
                    C1589h c1589hMo8471a = c1590i.mo8471a();
                    this.f7764s.add(c1589hMo8471a);
                    return c1589hMo8471a.m8465j();
                }
                this.f7765t = true;
            }
        }
        if (j2 != -1) {
            c2114bt = new C2114bt(this.f7752C, this.f7758l, j2);
        } else {
            c2114bt = new C2114bt(this.f7752C, this.f7758l);
        }
        c2114bt.m9454a(EnumC2118bx.NetTask, new C2050i(c2114bt.m9455b(), this.f7551c, j, enumC2300t, str, strArr, z, str2, str3, enumC2706n));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9209a(long j, EnumC2300t enumC2300t, String str, String[] strArr, boolean z, String str2, long j2, String str3) {
        C2114bt c2114bt;
        if (z && enumC2300t != EnumC2300t.BROADCAST) {
            synchronized (this.f7755i) {
                if (this.f7765t) {
                    C1590i c1590i = new C1590i();
                    c1590i.m8476a(strArr).m8477b(enumC2300t.m10210a()).m8480c(EnumC2214ab.ANICON.m10076a()).m8478b(j).m8479b(str2).m8478b(j);
                    if (j2 != -1) {
                        c1590i.m8481c(j2);
                    } else {
                        c1590i.m8481c(C4843bh.m18322a());
                    }
                    C1589h c1589hMo8471a = c1590i.mo8471a();
                    this.f7764s.add(c1589hMo8471a);
                    return c1589hMo8471a.m8465j();
                }
                this.f7765t = true;
            }
        }
        if (j2 != -1) {
            c2114bt = new C2114bt(this.f7752C, this.f7758l, j2);
        } else {
            c2114bt = new C2114bt(this.f7752C, this.f7758l);
        }
        c2114bt.m9454a(EnumC2118bx.NetTask, new C2050i(c2114bt.m9455b(), this.f7551c, j, enumC2300t, str, strArr, z, str2, str3));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        C2204r.m10056e(CommonApplication.m18732r().getContentResolver(), Long.valueOf(j));
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    /* renamed from: a */
    public void m9639a(C0982r c0982r) {
        new C2052k(this.f7754b, this.f7551c, c0982r).m9103a(this.f7758l);
    }

    /* renamed from: a */
    public void m9635a(C0902eb c0902eb) {
        new C2001dt(this.f7754b, this.f7551c, c0902eb).m9103a(this.f7758l);
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9226a(EnumC2214ab enumC2214ab, String str, String[] strArr, String[] strArr2) {
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C1988dg(c2114bt.m9455b(), enumC2214ab, str, strArr, strArr2, this.f7551c));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public long mo9241a(String str, String[] strArr, String[] strArr2, boolean z) {
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C2062u(c2114bt.m9455b(), str, strArr, strArr2, z, this.f7551c));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    /* renamed from: a */
    public long m9628a(String str, String str2, EnumC2300t enumC2300t, String str3, long j) {
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C2061t(c2114bt.m9455b(), str, str2, enumC2300t, str3, j));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    /* renamed from: d */
    public static synchronized void m9610d(String str) {
        C2142w c2142wM9606c = m9606c(str);
        if (c2142wM9606c != null) {
            c2142wM9606c.m9615t();
        }
    }

    /* renamed from: t */
    private void m9615t() {
        C2684ab.m11290a("MessageControl", "------------------- Message Control CLEARED (%s ) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ---------------------", this.f7551c);
        if (this.f7758l != null) {
            C2417af.m10459e(this.f7758l);
            f7748q.remove(this.f7551c);
        }
    }

    /* renamed from: a */
    public long m9621a(EnumC2300t enumC2300t, String str, String str2) {
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        c2114bt.m9454a(EnumC2118bx.NetTask, new C1922av(c2114bt.m9455b(), enumC2300t, str, str2));
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    /* renamed from: a */
    public long m9629a(ArrayList<String> arrayList) {
        C2114bt c2114bt = new C2114bt(this.f7752C, this.f7758l);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0 && i % f7749z == 0) {
                c2114bt.m9454a(EnumC2118bx.NetTask, new C2054m(c2114bt.m9455b(), arrayList2));
                arrayList2.clear();
            }
            arrayList2.add(arrayList.get(i));
        }
        if (arrayList2.size() > 0) {
            c2114bt.m9454a(EnumC2118bx.NetTask, new C2054m(c2114bt.m9455b(), arrayList2));
            arrayList2.clear();
        }
        this.f7763r.put(Long.valueOf(c2114bt.m9452a()), c2114bt);
        c2114bt.m9457d();
        return c2114bt.m9452a();
    }

    /* renamed from: a */
    public void m9641a(String str, int i) {
        if (this.f7758l != null && !TextUtils.isEmpty(this.f7766u)) {
            new C1991dj(null, this.f7551c, this.f7552d, EnumC1992dk.TEXT, i, this.f7766u, str).m9103a(this.f7758l);
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public boolean mo9252a(String str, String str2, int i) {
        boolean z;
        String str3;
        String simpleName;
        C2425an c2425an = new C2425an();
        this.f7551c = str;
        try {
            c2425an.m10504a(str).m10505b(str2).m10502a(i).m10503a((C4808a) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            try {
                this.f7758l = c2425an.m10501a();
                m9653l();
                z = true;
                str3 = "ChatRoom Info : InboxNO = " + this.f7551c + " SERVER = " + str2;
                simpleName = getClass().getSimpleName();
            } catch (NoSuchFieldException e2) {
                C4904y.m18634a("TCP Context buiilder" + e2, toString());
                this.f7758l = null;
                z = false;
                str3 = "ChatRoom Info : InboxNO = " + this.f7551c + " SERVER = " + str2;
                simpleName = getClass().getSimpleName();
            }
            C4904y.m18646e(str3, simpleName);
            return z;
        } catch (Throwable th) {
            C4904y.m18646e("ChatRoom Info : InboxNO = " + this.f7551c + " SERVER = " + str2, getClass().getSimpleName());
            throw th;
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: a */
    public void mo9243a(long j) {
        if (this.f7758l != null) {
            this.f7758l.m10488a(j);
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: d */
    public void mo9274d() {
        C1742go.m8666a(this.f7551c);
        if (this.f7758l != null && C2417af.m10450a(this.f7758l)) {
            C2417af.m10458d(this.f7758l);
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: f */
    public void mo9278f() {
        C1742go.m8666a(this.f7551c);
        if (this.f7758l != null) {
            C2417af.m10455c(this.f7758l);
        }
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: e */
    public boolean mo9276e() {
        if (this.f7758l != null) {
            return C2417af.m10450a(this.f7758l);
        }
        return false;
    }

    /* renamed from: a */
    public void m9642a(boolean z) {
        this.f7759m = z;
    }

    /* renamed from: m */
    public boolean m9654m() {
        return this.f7759m;
    }

    /* renamed from: b */
    public void m9645b(boolean z) {
        this.f7761o = z;
    }

    /* renamed from: n */
    public boolean m9655n() {
        return this.f7761o;
    }

    /* renamed from: o */
    public boolean m9656o() {
        return this.f7762p;
    }

    /* renamed from: e */
    public void m9648e(String str) {
        this.f7553e = str;
    }

    /* renamed from: p */
    public String m9657p() {
        return this.f7553e;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: c */
    public boolean mo9272c() {
        boolean z;
        synchronized (this.f7755i) {
            z = this.f7765t;
        }
        return z;
    }

    @Override // com.sec.chaton.p067j.InterfaceC2469t
    /* renamed from: a */
    public void mo9130a(int i, Object obj) {
    }

    @Override // com.sec.chaton.p067j.InterfaceC2469t
    /* renamed from: a */
    public void mo9131a(int i, Object obj, Object obj2) {
        if (obj2 != null) {
            C2426ao c2426ao = (C2426ao) obj2;
            if (c2426ao.m10513c() != null) {
                switch (c2426ao.m10512b()) {
                    case 6:
                        C0826bg c0826bg = (C0826bg) c2426ao.m10513c();
                        C4904y.m18639b("DeliveryChat From Server : Session ID = " + c0826bg.m3599d(), getClass().getSimpleName());
                        m9631a(c0826bg);
                        break;
                    case 10:
                        C0982r c0982r = (C0982r) c2426ao.m10513c();
                        C4904y.m18639b("AnswerBack From Server", getClass().getSimpleName());
                        m9639a(c0982r);
                        break;
                    case 16:
                        C0976l c0976l = (C0976l) c2426ao.m10513c();
                        C4904y.m18639b("AnnounceChange From Server", getClass().getSimpleName());
                        m9638a(c0976l);
                        break;
                    case 24:
                        C0883dj c0883dj = (C0883dj) c2426ao.m10513c();
                        if (C4904y.f17873c) {
                            C4904y.m18641c("IsTyping From Server", getClass().getSimpleName());
                        }
                        m9634a(c0883dj);
                        break;
                    case 34:
                        C0852cf c0852cf = (C0852cf) c2426ao.m10513c();
                        C4904y.m18639b("ForwardOnlineMessage From Server : Session ID = " + c0852cf.m3932d(), getClass().getSimpleName());
                        m9632a(c0852cf);
                        break;
                    case 36:
                        C0858cl c0858cl = (C0858cl) c2426ao.m10513c();
                        C4904y.m18639b("ForwardStoredMessage From Server : Session ID = " + c0858cl.m4034d(), getClass().getSimpleName());
                        m9633a(c0858cl);
                        break;
                    case 46:
                        C0902eb c0902eb = (C0902eb) c2426ao.m10513c();
                        C4904y.m18639b("MirrorAcknowledge From Server", getClass().getSimpleName());
                        m9635a(c0902eb);
                        break;
                    case 48:
                        C0922ev c0922ev = (C0922ev) c2426ao.m10513c();
                        if (C4904y.f17873c) {
                            C4904y.m18641c("PushConnectivityNotify From Server", getClass().getSimpleName());
                        }
                        m9636a(c0922ev);
                        break;
                    case 51:
                        C0966gl c0966gl = (C0966gl) c2426ao.m10513c();
                        if (C4904y.f17873c) {
                            C4904y.m18641c("UndoMessage From Server", getClass().getSimpleName());
                        }
                        m9637a(c0966gl);
                        break;
                }
            }
        }
    }

    /* renamed from: f */
    public static boolean m9613f(String str) {
        return (TextUtils.isEmpty(str) || "null".equals(str) || "".equals(str)) ? false : true;
    }

    /* renamed from: q */
    public boolean m9658q() {
        return (this.f7552d == EnumC2300t.BROADCAST || m9613f(this.f7766u)) ? false : true;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: r */
    public boolean mo9279r() {
        if (this.f7552d != EnumC2300t.GROUPCHAT) {
            if (C4904y.f17873c) {
                C4904y.m18641c("(C_C)Only if ChatType is GROUPCHAT, it will be started the timer to close the connection.", "MessageControl");
            }
            return false;
        }
        if (this.f7770y == null) {
            this.f7770y = new Timer();
        }
        C2068aa c2068aa = new C2068aa(this);
        if (C4904y.f17873c) {
            C4904y.m18641c("(C_C)Start a timer to close the connection", "MessageControl");
        }
        this.f7770y.schedule(c2068aa, 10000L);
        return true;
    }

    @Override // com.sec.chaton.p055d.AbstractC2070ac
    /* renamed from: s */
    public void mo9280s() {
        if (this.f7770y == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("(C_C)There isn't a timer to close the connection", "MessageControl");
            }
        } else {
            this.f7770y.cancel();
            this.f7770y = null;
            if (C4904y.f17873c) {
                C4904y.m18641c("(C_C)Stop a timer to close the connection", "MessageControl");
            }
        }
    }
}
