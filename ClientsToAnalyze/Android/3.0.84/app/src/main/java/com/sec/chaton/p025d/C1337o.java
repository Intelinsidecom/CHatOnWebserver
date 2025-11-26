package com.sec.chaton.p025d;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.renren.android.Renren;
import com.sec.chaton.chat.C1077es;
import com.sec.chaton.chat.C1092fg;
import com.sec.chaton.chat.background.C0974h;
import com.sec.chaton.chat.background.C0975i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1740a;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.ChatONMsgEntity;
import com.sec.chaton.msgsend.EnumC1741aa;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p016a.C0280ad;
import com.sec.chaton.p016a.C0307bd;
import com.sec.chaton.p016a.C0394i;
import com.sec.chaton.p016a.C0400o;
import com.sec.chaton.p025d.p026a.C1147ab;
import com.sec.chaton.p025d.p026a.C1161ap;
import com.sec.chaton.p025d.p026a.C1162aq;
import com.sec.chaton.p025d.p026a.C1168aw;
import com.sec.chaton.p025d.p026a.C1220cu;
import com.sec.chaton.p025d.p026a.C1225cz;
import com.sec.chaton.p025d.p026a.C1228db;
import com.sec.chaton.p025d.p026a.C1240dn;
import com.sec.chaton.p025d.p026a.C1270i;
import com.sec.chaton.p025d.p026a.C1275n;
import com.sec.chaton.p025d.p026a.C1276o;
import com.sec.chaton.p025d.p026a.C1277p;
import com.sec.chaton.p025d.p026a.C1278q;
import com.sec.chaton.p025d.p026a.C1286y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p035io.entry.ApplinkMsgEntry;
import com.sec.chaton.p037j.C1544ac;
import com.sec.chaton.p037j.C1547af;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1589q;
import com.sec.chaton.p037j.C1596x;
import com.sec.chaton.p037j.InterfaceC1592t;
import com.sec.chaton.p037j.p040c.C1561g;
import com.sec.chaton.p037j.p040c.RunnableC1563i;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.specialbuddy.C2930k;
import com.sec.chaton.util.C3158a;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Query;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.d.o */
/* loaded from: classes.dex */
public class C1337o implements InterfaceC1592t {

    /* renamed from: b */
    private static HandlerThread f5035b = null;

    /* renamed from: o */
    private static HashMap<String, C1337o> f5036o = new HashMap<>();

    /* renamed from: x */
    private static int f5037x = 360;

    /* renamed from: g */
    private Handler f5044g;

    /* renamed from: i */
    private String f5046i;

    /* renamed from: j */
    private C1544ac f5047j;

    /* renamed from: l */
    private String f5049l;

    /* renamed from: s */
    private String f5055s;

    /* renamed from: t */
    private String f5056t;

    /* renamed from: u */
    private EnumC1450r f5057u;

    /* renamed from: w */
    private long f5059w;

    /* renamed from: k */
    private boolean f5048k = false;

    /* renamed from: m */
    private boolean f5050m = false;

    /* renamed from: n */
    private boolean f5051n = false;

    /* renamed from: p */
    private Map<Long, C1318bd> f5052p = new HashMap();

    /* renamed from: q */
    private ArrayList<C0974h> f5053q = new ArrayList<>();

    /* renamed from: r */
    private boolean f5054r = false;

    /* renamed from: v */
    private ArrayList<Long> f5058v = new ArrayList<>();

    /* renamed from: y */
    private Handler f5060y = new HandlerC1338p(this, m5807b().getLooper());

    /* renamed from: z */
    private Handler f5061z = new HandlerC1339q(this, m5807b().getLooper());

    /* renamed from: A */
    private Handler f5038A = new HandlerC1340r(this, m5807b().getLooper());

    /* renamed from: h */
    private List<Handler> f5045h = new ArrayList();

    /* renamed from: a */
    C1589q f5039a = new C1589q(this.f5038A, this);

    /* renamed from: c */
    private final Object f5040c = new Object();

    /* renamed from: d */
    private final Object f5041d = new Object();

    /* renamed from: e */
    private final Object f5042e = new Object();

    /* renamed from: f */
    private final Object f5043f = new Object();

    /* renamed from: a */
    public static void m5798a() {
        if (f5035b == null) {
            f5035b = new HandlerThread("MessageControl");
            f5035b.start();
        } else if (!f5035b.isAlive()) {
            f5035b.start();
        }
    }

    /* renamed from: a */
    public boolean m5874a(Handler handler) {
        boolean zAdd;
        synchronized (this.f5040c) {
            if (this.f5045h.contains(handler)) {
                zAdd = true;
            } else {
                if (C3250y.f11734b) {
                    C3250y.m11450b("addHandler : " + handler.toString(), getClass().getSimpleName());
                }
                zAdd = this.f5045h.add(handler);
            }
        }
        return zAdd;
    }

    /* renamed from: b */
    public boolean m5888b(Handler handler) {
        boolean zRemove;
        if (C3250y.f11734b) {
            C3250y.m11450b("removeHandler : " + handler.toString(), getClass().getSimpleName());
        }
        synchronized (this.f5040c) {
            zRemove = this.f5045h.remove(handler);
        }
        return zRemove;
    }

    /* renamed from: b */
    public static HandlerThread m5807b() {
        return f5035b;
    }

    /* renamed from: c */
    public String m5892c() {
        return this.f5056t;
    }

    /* renamed from: a */
    public void m5872a(String str) {
        synchronized (this.f5043f) {
            this.f5056t = str;
        }
    }

    /* renamed from: d */
    public String m5895d() {
        return this.f5055s;
    }

    /* renamed from: b */
    public boolean m5889b(String str) {
        if (m5816f(this.f5055s) || !m5816f(str)) {
            return false;
        }
        m5894c(str);
        return true;
    }

    /* renamed from: c */
    public void m5894c(String str) {
        synchronized (this.f5042e) {
            this.f5055s = str;
        }
    }

    /* renamed from: e */
    public long m5896e() {
        return this.f5059w;
    }

    /* renamed from: a */
    public void m5867a(long j) {
        this.f5059w = j;
    }

    /* renamed from: b */
    public void m5886b(long j) {
        if (this.f5059w <= 0 && j > 0) {
            this.f5059w = j;
        }
    }

    /* renamed from: f */
    public C1544ac m5898f() {
        return this.f5047j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5799a(int i, int i2, int i3, Object obj, long j) {
        synchronized (this.f5040c) {
            for (Handler handler : this.f5045h) {
                Message messageObtain = Message.obtain();
                messageObtain.arg1 = i;
                messageObtain.arg2 = i2;
                messageObtain.what = i3;
                messageObtain.obj = new C1092fg(j, obj);
                handler.sendMessage(messageObtain);
            }
        }
        C3250y.m11450b("RequestID : " + String.valueOf(j), getClass().getSimpleName());
    }

    /* renamed from: a */
    private boolean m5804a(C0974h c0974h, boolean z) {
        EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(c0974h.m5209e());
        if (enumC1455wM6358a != null) {
            long jM5212h = c0974h.m5212h();
            if (EnumC1455w.TEXT == enumC1455wM6358a || EnumC1455w.LIVESHARE == enumC1455wM6358a || EnumC1455w.LIVERECOMMEND == enumC1455wM6358a || EnumC1455w.LIVECONTENTS == enumC1455wM6358a || EnumC1455w.APPLINK == enumC1455wM6358a) {
                if (jM5212h != -1) {
                    m5835a(jM5212h, this.f5046i, enumC1455wM6358a, EnumC1450r.m6339a(c0974h.m5208d()), this.f5055s, c0974h.m5207c(), c0974h.m5210f(), z, c0974h.m5213i());
                } else if (z) {
                    m5862a(this.f5046i, enumC1455wM6358a, EnumC1450r.m6339a(c0974h.m5208d()), c0974h.m5207c(), c0974h.m5210f(), (String) null, c0974h.m5213i(), jM5212h);
                } else {
                    m5854a(enumC1455wM6358a, EnumC1450r.m6339a(c0974h.m5208d()), this.f5055s, c0974h.m5207c(), c0974h.m5210f(), (String) null, c0974h.m5213i(), EnumC1751k.f6455d);
                    if (C1757q.m7251b()) {
                        C1759s.m7260a("MessageControl", "sendBufferedMessage(), SHOULD NOT BE HAPPENED HERE !! (TEXT) : No Msg ID? ", new Object[0]);
                    }
                }
            } else if (EnumC1455w.GEO == enumC1455wM6358a) {
                if (jM5212h != -1) {
                    m5823a(jM5212h, EnumC1450r.m6339a(c0974h.m5208d()), this.f5055s, c0974h.m5207c(), z, c0974h.m5210f(), c0974h.m5213i());
                } else {
                    m5847a(EnumC1450r.m6339a(c0974h.m5208d()), this.f5055s, c0974h.m5207c(), z, c0974h.m5210f(), c0974h.m5213i(), c0974h.m5216l(), EnumC1751k.f6455d);
                    if (C1757q.m7251b()) {
                        C1759s.m7260a("MessageControl", "sendBufferedMessage(), SHOULD NOT BE HAPPENED HERE !! (GEO) : No Msg ID? ", new Object[0]);
                    }
                }
            } else if (EnumC1455w.ANICON == enumC1455wM6358a) {
                m5825a(c0974h.m5212h(), EnumC1450r.m6339a(c0974h.m5208d()), this.f5055s, c0974h.m5207c(), z, c0974h.m5210f(), c0974h.m5213i(), c0974h.m5216l());
            } else {
                m5801a(c0974h.m5212h(), c0974h.m5214j(), enumC1455wM6358a, EnumC1450r.m6339a(c0974h.m5208d()), this.f5055s, c0974h.m5207c(), z, c0974h.m5210f(), c0974h.m5215k(), c0974h.m5216l(), c0974h.m5217m());
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5811c(boolean z) {
        if (z) {
            synchronized (this.f5041d) {
                if (this.f5054r) {
                    this.f5054r = false;
                    if (this.f5053q.size() > 0) {
                        Iterator<C0974h> it = this.f5053q.iterator();
                        while (it.hasNext()) {
                            m5804a(it.next(), false);
                        }
                        this.f5053q.clear();
                    }
                }
            }
            return;
        }
        synchronized (this.f5041d) {
            if (this.f5054r) {
                if (this.f5053q.size() > 0) {
                    m5804a(this.f5053q.remove(0), true);
                } else {
                    this.f5054r = false;
                }
            }
        }
    }

    public C1337o(String str, EnumC1450r enumC1450r) {
        this.f5046i = str;
        this.f5049l = str;
        this.f5057u = enumC1450r;
    }

    /* renamed from: a */
    public static synchronized C1337o m5795a(String str, EnumC1450r enumC1450r) {
        if (!f5036o.containsKey(str)) {
            f5036o.put(str, new C1337o(str, enumC1450r));
        } else {
            f5036o.get(str).f5046i = str;
            f5036o.get(str).f5049l = str;
            f5036o.get(str).f5057u = enumC1450r;
        }
        return f5036o.get(str);
    }

    /* renamed from: d */
    public static synchronized C1337o m5813d(String str) {
        return f5036o != null ? f5036o.get(str) : null;
    }

    /* renamed from: g */
    public static synchronized void m5817g() {
        Iterator it = new ArrayList(f5036o.values()).iterator();
        while (it.hasNext()) {
            C1337o c1337o = (C1337o) it.next();
            if (c1337o != null) {
                c1337o.m5900i();
            }
        }
    }

    /* renamed from: h */
    public void m5899h() {
        this.f5047j.m6551a(6, this.f5039a);
        this.f5047j.m6551a(10, this.f5039a);
        this.f5047j.m6551a(14, this.f5039a);
        this.f5047j.m6551a(16, this.f5039a);
        this.f5047j.m6551a(24, this.f5039a);
        this.f5047j.m6551a(9999, this.f5039a);
    }

    /* renamed from: a */
    public long m5861a(String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String[] strArr, String str2, String str3) {
        return m5864a(str, enumC1455w, enumC1450r, strArr, str2, str3, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5862a(String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String[] strArr, String str2, String str3, long j, long j2) {
        return m5863a(str, enumC1455w, enumC1450r, strArr, str2, str3, j, j2, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5864a(String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String[] strArr, String str2, String str3, EnumC1751k enumC1751k) {
        return m5863a(str, enumC1455w, enumC1450r, strArr, str2, str3, -1L, -1L, enumC1751k);
    }

    /* renamed from: a */
    public long m5863a(String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String[] strArr, String str2, String str3, long j, long j2, EnumC1751k enumC1751k) {
        C1318bd c1318bd;
        C3250y.m11450b("initChatRoom", getClass().getSimpleName());
        if (-1 == j2) {
            j2 = C3193bh.m11148a();
            int i = 0;
            if (!enumC1751k.m7198a() && C1757q.m7251b()) {
                i = 6;
            }
            C1373q.m6169a(GlobalApplication.m11493l().getContentResolver(), String.valueOf(j2), str, enumC1455w, str2, str3, strArr.length, i);
        }
        long j3 = j2;
        String str4 = !TextUtils.isEmpty(str3) ? str3 : str2;
        if (enumC1450r != EnumC1450r.BROADCAST) {
            synchronized (this.f5041d) {
                if (this.f5054r) {
                    C0975i c0975i = new C0975i();
                    c0975i.m5224a(strArr).m5220a(enumC1450r.m6342a()).m5225b(enumC1455w.m6364a()).m5226b(j3).m5227b(str4).m5222a(enumC1751k);
                    if (j != -1) {
                        c0975i.m5228c(j);
                    } else {
                        c0975i.m5228c(C3193bh.m11148a());
                    }
                    C0974h c0974hMo5219a = c0975i.mo5219a();
                    this.f5053q.add(c0974hMo5219a);
                    return c0974hMo5219a.m5213i();
                }
                this.f5054r = true;
            }
        }
        if (j != -1) {
            c1318bd = new C1318bd(this.f5038A, this.f5047j, j);
        } else {
            c1318bd = new C1318bd(this.f5038A, this.f5047j);
        }
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1220cu(c1318bd.m5681b(), str, j3, enumC1455w, enumC1450r, strArr, str4, enumC1751k));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public boolean m5875a(EnumC1450r enumC1450r, String str, Long l, String str2, String str3, long j) {
        return m5876a(enumC1450r, str, l, str2, str3, j, false);
    }

    /* renamed from: a */
    public boolean m5876a(EnumC1450r enumC1450r, String str, Long l, String str2, String str3, long j, boolean z) {
        if (!z && C1596x.m6756b(this.f5047j)) {
            if (enumC1450r == EnumC1450r.GROUPCHAT) {
                C1335m.m5784a(this.f5061z, str3, str2, j);
            }
            return false;
        }
        Long lValueOf = Long.valueOf(C3193bh.m11148a());
        C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1270i(c1318bd.m5681b(), enumC1450r, str3, str, lValueOf.longValue(), str2));
        if (enumC1450r == EnumC1450r.GROUPCHAT) {
            C1335m.m5784a(this.f5061z, str3, str2, j);
        }
        c1318bd.m5683d();
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        return true;
    }

    /* renamed from: a */
    public void m5868a(C0307bd c0307bd) {
        C3250y.m11450b("makeDeliveryChatReply", getClass().getSimpleName());
        C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1162aq(c1318bd.m5681b(), this.f5046i, c0307bd, this));
        c1318bd.m5683d();
    }

    /* renamed from: a */
    public void m5871a(EnumC1450r enumC1450r, String str) {
        C3250y.m11450b("sendDeliveryChatReply", getClass().getSimpleName());
        C1077es c1077esM5329b = C1077es.m5329b(this.f5046i);
        if (!C1596x.m6753a(this.f5047j)) {
            c1077esM5329b.m5330a();
        } else if (!c1077esM5329b.m5333b()) {
            new C1161ap(this.f5044g, this.f5046i, enumC1450r, str).m5540a(this.f5047j);
        }
    }

    /* renamed from: a */
    public void m5869a(C0394i c0394i) {
        if (c0394i != null) {
            C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
            c1318bd.m5680a(EnumC1322bh.NetTask, new C1276o(c1318bd.m5681b(), c0394i, this.f5046i));
            c1318bd.m5683d();
        }
    }

    /* renamed from: a */
    public long m5845a(EnumC1450r enumC1450r, String str, String[] strArr, ArrayList<ChatONMsgEntity> arrayList) {
        return m5846a(enumC1450r, str, strArr, arrayList, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5846a(EnumC1450r enumC1450r, String str, String[] strArr, ArrayList<ChatONMsgEntity> arrayList, EnumC1751k enumC1751k) {
        if (arrayList == null || arrayList.isEmpty()) {
            return -1L;
        }
        C3250y.m11450b("doSendBulkMessage", getClass().getSimpleName());
        C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
        C1740a c1740aM7151a = C1740a.m7151a();
        Iterator<ChatONMsgEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            c1740aM7151a.m7153a(it.next());
        }
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1240dn(c1318bd.m5681b(), C3193bh.m11148a(), this.f5046i, enumC1450r, str, strArr, c1740aM7151a, enumC1751k));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        C1373q.m6154a(GlobalApplication.m11493l().getContentResolver(), c1740aM7151a, EnumC1741aa.SENDING);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public long m5853a(EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3) {
        return m5855a(enumC1455w, enumC1450r, str, strArr, str2, str3, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5855a(EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3, EnumC1751k enumC1751k) {
        return m5854a(enumC1455w, enumC1450r, str, strArr, str2, str3, -1L, enumC1751k);
    }

    /* renamed from: a */
    public long m5854a(EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3, long j, EnumC1751k enumC1751k) {
        String str4 = !TextUtils.isEmpty(str3) ? str3 : str2;
        C3250y.m11450b("requestSendMessage", getClass().getSimpleName());
        long jM11148a = C3193bh.m11148a();
        int i = 0;
        if (!enumC1751k.m7198a() && C1757q.m7251b()) {
            i = 6;
        }
        C1373q.m6169a(GlobalApplication.m11493l().getContentResolver(), String.valueOf(jM11148a), this.f5046i, enumC1455w, str2, str3, strArr.length, i);
        if (enumC1751k.m7198a() || !C1757q.m7251b()) {
            return m5793a(jM11148a, enumC1455w, enumC1450r, str, strArr, str4, j, enumC1751k);
        }
        C1756p.m7236a(this.f5046i, this.f5057u, jM11148a, enumC1455w, str4, null, EnumC1741aa.m7156a(i), strArr);
        return jM11148a;
    }

    /* renamed from: a */
    private long m5793a(long j, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str, String[] strArr, String str2, long j2, EnumC1751k enumC1751k) {
        C1318bd c1318bd;
        C3250y.m11450b("doSendMessage", getClass().getSimpleName());
        if (j2 != -1) {
            c1318bd = new C1318bd(this.f5038A, this.f5047j, j2);
        } else {
            c1318bd = new C1318bd(this.f5038A, this.f5047j);
        }
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1147ab(c1318bd.m5681b(), j, this.f5046i, enumC1455w, enumC1450r, str, str2, strArr, enumC1751k));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public boolean m5877a(ChatONMsgEntity chatONMsgEntity, String[] strArr) {
        return m5803a(chatONMsgEntity.m7143e().longValue(), chatONMsgEntity.m7145g(), chatONMsgEntity.m7146h(), chatONMsgEntity.m7147i(), chatONMsgEntity.m7144f(), chatONMsgEntity.m7148j(), chatONMsgEntity.m7149k(), strArr);
    }

    /* renamed from: a */
    private boolean m5803a(long j, String str, String str2, String str3, EnumC1455w enumC1455w, String str4, int i, String[] strArr) {
        File file;
        String str5;
        String strNextToken = "";
        String str6 = this.f5046i;
        if (enumC1455w == EnumC1455w.TEXT || enumC1455w == EnumC1455w.GEO || enumC1455w == EnumC1455w.ANICON || enumC1455w == EnumC1455w.POLL || enumC1455w == EnumC1455w.APPLINK || enumC1455w == EnumC1455w.LIVERECOMMEND || enumC1455w == EnumC1455w.LIVESHARE || enumC1455w == EnumC1455w.LIVECONTENTS) {
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
        if (!m5816f(this.f5055s)) {
            if (this.f5057u != EnumC1450r.BROADCAST) {
            }
            z = true;
        }
        if (enumC1455w == EnumC1455w.TEXT || enumC1455w == EnumC1455w.LIVERECOMMEND || enumC1455w == EnumC1455w.LIVESHARE || enumC1455w == EnumC1455w.LIVECONTENTS) {
            m5834a(j, str6, enumC1455w, this.f5057u, this.f5055s, strArr, str, z);
        } else if (enumC1455w == EnumC1455w.GEO) {
            m5822a(j, this.f5057u, this.f5055s, strArr, z, str);
        } else if (enumC1455w == EnumC1455w.ANICON) {
            String[] strArr2 = new String[0];
            String[] strArrSplit = str.split("\n");
            String strM9664c = C2646u.m9664c(strArrSplit[2]);
            if (strArrSplit.length > 6 && Query.MIXED.equals(strArrSplit[0])) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 6; i2 < strArrSplit.length; i2++) {
                    stringBuffer.append(strArrSplit[i2] + "\n");
                }
                m5883b(j, this.f5057u, this.f5055s, strArr, z, strM9664c, -1L, stringBuffer.toString().substring(0, stringBuffer.length() - 1));
            } else {
                m5883b(j, this.f5057u, this.f5055s, strArr, z, strM9664c, -1L, null);
            }
        } else if (enumC1455w == EnumC1455w.APPLINK) {
            m5881b(j, this.f5057u, this.f5055s, strArr, str);
        } else if (enumC1455w == EnumC1455w.POLL) {
            m5820a(j, this.f5057u, this.f5055s, strArr, str);
        } else if (i == 1) {
            m5818a(j, this.f5057u, str, this.f5055s, strArr, z, str4, str5, enumC1455w);
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
            m5831a(j, file, (String) null, enumC1455w, this.f5057u, this.f5055s, strArr, z, str4, strSubstring);
        }
        return true;
    }

    /* renamed from: a */
    public long m5839a(EnumC1450r enumC1450r, String str, String[] strArr, long j, String str2, String str3) {
        return m5841a(enumC1450r, str, strArr, j, str2, str3, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5841a(EnumC1450r enumC1450r, String str, String[] strArr, long j, String str2, String str3, EnumC1751k enumC1751k) {
        return m5840a(enumC1450r, str, strArr, j, str2, str3, -1L, enumC1751k);
    }

    /* renamed from: a */
    public long m5840a(EnumC1450r enumC1450r, String str, String[] strArr, long j, String str2, String str3, long j2, EnumC1751k enumC1751k) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.put(PrefFragmentChats.TYPE, "poll");
            jSONObject.put("format", Renren.RESPONSE_FORMAT_JSON);
            jSONObject3.put(PrefFragmentChats.TYPE, "poll");
            jSONObject3.put("id", j);
            jSONObject3.put("content_type", "question");
            jSONObject.put("push_message", jSONObject3);
            jSONObject2.put(PrefFragmentChats.TYPE, "question");
            jSONObject2.put("id", j);
            jSONObject2.put("content", new JSONObject(str3));
            jSONObject.put("content", jSONObject2);
            String string = jSONObject.toString();
            if (TextUtils.isEmpty(str) && (!C1757q.m7251b() || enumC1751k.m7198a())) {
                return m5863a(this.f5046i, EnumC1455w.POLL, enumC1450r, strArr, string, (String) null, j2, -1L, enumC1751k);
            }
            return m5854a(EnumC1455w.POLL, enumC1450r, str, strArr, string, (String) null, j2, enumC1751k);
        } catch (JSONException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: a */
    public long m5842a(EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3) {
        return m5844a(enumC1450r, str, strArr, str2, str3, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5844a(EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3, EnumC1751k enumC1751k) {
        return m5843a(enumC1450r, str, strArr, str2, str3, -1L, enumC1751k);
    }

    /* renamed from: a */
    public long m5843a(EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3, long j, EnumC1751k enumC1751k) {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C3250y.f11734b) {
                C3250y.m11442a("chatMsg is null or recipients is null", "MessageControl");
            }
            return -1L;
        }
        try {
            String string = ApplinkMsgEntry.createJson(str2, str3).toString();
            if (TextUtils.isEmpty(str) && (enumC1751k.m7198a() || !C1757q.m7251b())) {
                return m5863a(this.f5046i, EnumC1455w.APPLINK, enumC1450r, strArr, string, (String) null, j, -1L, enumC1751k);
            }
            return m5854a(EnumC1455w.APPLINK, enumC1450r, str, strArr, string, (String) null, j, enumC1751k);
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, "MessageControl");
            }
            return -1L;
        }
    }

    /* renamed from: b */
    public long m5884b(EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3) {
        return m5885b(enumC1450r, str, strArr, str2, str3, -1L, EnumC1751k.f6455d);
    }

    /* renamed from: b */
    public long m5885b(EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3, long j, EnumC1751k enumC1751k) throws JSONException {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C3250y.f11734b) {
                C3250y.m11442a("requestSendLiveShare(), chatMsg is null or recipients is null", "MessageControl");
            }
            return -1L;
        }
        String strM10158b = C2930k.m10158b(str2);
        if (TextUtils.isEmpty(strM10158b)) {
            C3250y.m11442a("requestSendLiveShare(), failed in converting chat msg : " + str2, "MessageControl");
            return -1L;
        }
        if (TextUtils.isEmpty(str) && (enumC1751k.m7198a() || !C1757q.m7251b())) {
            return m5863a(this.f5046i, EnumC1455w.LIVESHARE, enumC1450r, strArr, strM10158b, (String) null, j, -1L, enumC1751k);
        }
        return m5854a(EnumC1455w.LIVESHARE, enumC1450r, str, strArr, strM10158b, (String) null, j, enumC1751k);
    }

    /* renamed from: c */
    public long m5890c(EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3) {
        return m5891c(enumC1450r, str, strArr, str2, str3, -1L, EnumC1751k.f6455d);
    }

    /* renamed from: c */
    public long m5891c(EnumC1450r enumC1450r, String str, String[] strArr, String str2, String str3, long j, EnumC1751k enumC1751k) throws JSONException {
        if (TextUtils.isEmpty(str2) || strArr == null) {
            if (C3250y.f11734b) {
                C3250y.m11442a("requestSendLiveRecommend(), chatMsg is null or recipients is null", "MessageControl");
            }
            return -1L;
        }
        String strM10161e = C2930k.m10161e(str2);
        if (TextUtils.isEmpty(strM10161e)) {
            C3250y.m11442a("requestSendLiveRecommend(), failed in converting chat msg : " + str2, "MessageControl");
            return -1L;
        }
        if (TextUtils.isEmpty(str) && (enumC1751k.m7198a() || !C1757q.m7251b())) {
            return m5863a(this.f5046i, EnumC1455w.LIVERECOMMEND, enumC1450r, strArr, strM10161e, (String) null, j, -1L, enumC1751k);
        }
        return m5854a(EnumC1455w.LIVERECOMMEND, enumC1450r, str, strArr, strM10161e, (String) null, j, enumC1751k);
    }

    /* renamed from: a */
    public long m5850a(EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, EnumC1751k enumC1751k) {
        return m5847a(enumC1450r, str, strArr, z, str2, -1L, (String) null, enumC1751k);
    }

    /* renamed from: a */
    public long m5851a(EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, String str3) {
        return m5852a(enumC1450r, str, strArr, z, str2, str3, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5852a(EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, String str3, EnumC1751k enumC1751k) {
        return m5847a(enumC1450r, str, strArr, z, str2, -1L, str3, enumC1751k);
    }

    /* renamed from: a */
    public long m5847a(EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, long j, String str3, EnumC1751k enumC1751k) {
        String str4;
        if (TextUtils.isEmpty(str2) || str2.startsWith("geo") || str2.startsWith(Query.MIXED)) {
            str4 = str2;
        } else if (TextUtils.isEmpty(str3)) {
            str4 = "geo\n\n\n\n\n" + str2;
        } else {
            str4 = "mixed\ngeo\n\n\n\n" + str2 + "\n" + str3;
        }
        long jM11148a = C3193bh.m11148a();
        int i = 0;
        if (C1757q.m7251b() && !enumC1751k.m7198a()) {
            i = 6;
        }
        C1373q.m6169a(GlobalApplication.m11493l().getContentResolver(), String.valueOf(jM11148a), this.f5046i, EnumC1455w.GEO, str4, (String) null, strArr.length, i);
        if (C1757q.m7251b() && !enumC1751k.m7198a()) {
            C1756p.m7236a(this.f5046i, this.f5057u, jM11148a, EnumC1455w.GEO, str4, null, EnumC1741aa.m7156a(i), strArr);
            return jM11148a;
        }
        return m5827a(jM11148a, enumC1450r, str, strArr, z, str2, j, str3, str4, enumC1751k);
    }

    /* renamed from: a */
    public long m5827a(long j, EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, long j2, String str3, String str4, EnumC1751k enumC1751k) {
        C1318bd c1318bd;
        if (z && enumC1450r != EnumC1450r.BROADCAST) {
            synchronized (this.f5041d) {
                if (this.f5054r) {
                    C0975i c0975i = new C0975i();
                    c0975i.m5224a(strArr).m5220a(enumC1450r.m6342a()).m5225b(EnumC1455w.GEO.m6364a()).m5227b(str2).m5232f(str3);
                    if (j2 != -1) {
                        c0975i.m5228c(j2);
                    } else {
                        c0975i.m5228c(C3193bh.m11148a());
                    }
                    C0974h c0974hMo5219a = c0975i.mo5219a();
                    this.f5053q.add(c0974hMo5219a);
                    return c0974hMo5219a.m5213i();
                }
                this.f5054r = true;
            }
        }
        if (j2 != -1) {
            c1318bd = new C1318bd(this.f5038A, this.f5047j, j2);
        } else {
            c1318bd = new C1318bd(this.f5038A, this.f5047j);
        }
        if (!TextUtils.isEmpty(str4) && !str4.startsWith("geo") && !str4.startsWith(Query.MIXED)) {
            C1759s.m7260a("MessageControl", "doSendGeoTag(), ERROR : SEND GEO", str4);
            C1759s.m7260a("MessageControl", "doSendGeoTag(), ERROR : SEND GEO", str4);
            C1759s.m7260a("MessageControl", "doSendGeoTag(), ERROR : SEND GEO", str4);
            return -1L;
        }
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1228db(c1318bd.m5681b(), this.f5046i, j, "", EnumC1455w.GEO, enumC1450r, str, strArr, "", z, str4, null, enumC1751k));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public long m5822a(long j, EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2) {
        return m5828a(j, enumC1450r, str, strArr, z, str2, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5828a(long j, EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, EnumC1751k enumC1751k) {
        return m5824a(j, enumC1450r, str, strArr, z, str2, -1L, enumC1751k);
    }

    /* renamed from: a */
    public long m5823a(long j, EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, long j2) {
        return m5824a(j, enumC1450r, str, strArr, z, str2, j2, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5824a(long j, EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, long j2, EnumC1751k enumC1751k) {
        C1318bd c1318bd;
        if (z && enumC1450r != EnumC1450r.BROADCAST) {
            synchronized (this.f5041d) {
                if (this.f5054r) {
                    C0975i c0975i = new C0975i();
                    c0975i.m5224a(strArr).m5220a(enumC1450r.m6342a()).m5225b(EnumC1455w.GEO.m6364a()).m5227b(str2).m5226b(j).m5222a(enumC1751k);
                    if (j2 != -1) {
                        c0975i.m5228c(j2);
                    } else {
                        c0975i.m5228c(C3193bh.m11148a());
                    }
                    C0974h c0974hMo5219a = c0975i.mo5219a();
                    this.f5053q.add(c0974hMo5219a);
                    return c0974hMo5219a.m5213i();
                }
                this.f5054r = true;
            }
        }
        if (j2 != -1) {
            c1318bd = new C1318bd(this.f5038A, this.f5047j, j2);
        } else {
            c1318bd = new C1318bd(this.f5038A, this.f5047j);
        }
        C1318bd c1318bd2 = c1318bd;
        c1318bd2.m5680a(EnumC1322bh.NetTask, new C1228db(c1318bd.m5681b(), this.f5046i, j, "", EnumC1455w.GEO, enumC1450r, str, strArr, "", z, str2, null, enumC1751k));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        C1373q.m6196e(GlobalApplication.m11493l().getContentResolver(), Long.valueOf(j));
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public long m5834a(long j, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, String str3, boolean z) {
        return m5837a(j, str, enumC1455w, enumC1450r, str2, strArr, str3, z, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5837a(long j, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, String str3, boolean z, EnumC1751k enumC1751k) {
        return m5836a(j, str, enumC1455w, enumC1450r, str2, strArr, str3, z, -1L, enumC1751k);
    }

    /* renamed from: a */
    public long m5835a(long j, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, String str3, boolean z, long j2) {
        return m5836a(j, str, enumC1455w, enumC1450r, str2, strArr, str3, z, j2, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5836a(long j, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, String str3, boolean z, long j2, EnumC1751k enumC1751k) {
        C1318bd c1318bd;
        if (C3250y.f11734b) {
            C3250y.m11450b("reSend", getClass().getSimpleName());
        }
        if (z && enumC1450r != EnumC1450r.BROADCAST) {
            synchronized (this.f5041d) {
                if (this.f5054r) {
                    C0975i c0975i = new C0975i();
                    c0975i.m5224a(strArr).m5220a(enumC1450r.m6342a()).m5225b(enumC1455w.m6364a()).m5227b(str3).m5226b(j).m5222a(enumC1751k);
                    if (j2 != -1) {
                        c0975i.m5228c(j2);
                    } else {
                        c0975i.m5228c(C3193bh.m11148a());
                    }
                    C0974h c0974hMo5219a = c0975i.mo5219a();
                    this.f5053q.add(c0974hMo5219a);
                    return c0974hMo5219a.m5213i();
                }
                this.f5054r = true;
            }
        }
        if (j2 != -1) {
            c1318bd = new C1318bd(this.f5038A, this.f5047j, j2);
        } else {
            c1318bd = new C1318bd(this.f5038A, this.f5047j);
        }
        if (z) {
            switch (C1341s.f5065a[enumC1450r.ordinal()]) {
                case 1:
                case 2:
                    C1373q.m6196e(CommonApplication.m11493l().getContentResolver(), Long.valueOf(j));
                    break;
            }
            c1318bd.m5680a(EnumC1322bh.NetTask, new C1220cu(c1318bd.m5681b(), str, j, enumC1455w, enumC1450r, strArr, str3, enumC1751k));
        } else {
            switch (C1341s.f5065a[enumC1450r.ordinal()]) {
                case 1:
                case 2:
                    C1373q.m6196e(CommonApplication.m11493l().getContentResolver(), Long.valueOf(j));
                    break;
            }
            c1318bd.m5680a(EnumC1322bh.NetTask, new C1147ab(c1318bd.m5681b(), j, this.f5046i, enumC1455w, enumC1450r, str2, str3, strArr, enumC1751k));
        }
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public long m5820a(long j, EnumC1450r enumC1450r, String str, String[] strArr, String str2) {
        return m5821a(j, enumC1450r, str, strArr, str2, -1L);
    }

    /* renamed from: a */
    public long m5821a(long j, EnumC1450r enumC1450r, String str, String[] strArr, String str2, long j2) {
        return m5835a(j, this.f5046i, EnumC1455w.POLL, enumC1450r, str, strArr, str2, TextUtils.isEmpty(str), j2);
    }

    /* renamed from: b */
    public long m5881b(long j, EnumC1450r enumC1450r, String str, String[] strArr, String str2) {
        return m5882b(j, enumC1450r, str, strArr, str2, -1L);
    }

    /* renamed from: b */
    public long m5882b(long j, EnumC1450r enumC1450r, String str, String[] strArr, String str2, long j2) {
        return m5835a(j, this.f5046i, EnumC1455w.APPLINK, enumC1450r, str, strArr, str2, TextUtils.isEmpty(str), j2);
    }

    /* renamed from: a */
    public long m5857a(File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3) {
        return m5858a(file, str, enumC1455w, enumC1450r, str2, strArr, z, str3, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5858a(File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, EnumC1751k enumC1751k) {
        return m5860a(file, str, enumC1455w, enumC1450r, str2, strArr, z, str3, (String) null, (String) null, enumC1751k);
    }

    /* renamed from: a */
    public long m5859a(File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4, String str5) {
        return m5860a(file, str, enumC1455w, enumC1450r, str2, strArr, z, str3, str4, str5, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5860a(File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC1751k enumC1751k) throws Throwable {
        File file2;
        String strSubstring;
        long jM11148a = C3193bh.m11148a();
        String strDecode = Uri.decode(Uri.fromFile(file).toString());
        String strM6643a = RunnableC1563i.m6643a(file, enumC1455w);
        if (strM6643a == null) {
            C1759s.m7260a("MessageControl", "requestSendFile(), FILE Extention : forced to be '%s' with parameter", str);
            strM6643a = str;
        }
        if (!C3243r.m11421a(enumC1455w, strM6643a) || file.length() > 10485760) {
            C1759s.m7260a("MessageControl", "requestSendFile(), not support ext. or excess limited size", new Object[0]);
            return -1L;
        }
        String strM11415a = null;
        if (C3223ck.m11327a()) {
            String str6 = GlobalApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f5046i;
            if (!file.getAbsolutePath().contains(str6)) {
                String strValueOf = String.valueOf(System.currentTimeMillis());
                if (file.getName().indexOf(".") > -1) {
                    strSubstring = file.getName().substring(file.getName().lastIndexOf("."));
                } else if (strM6643a == null) {
                    strSubstring = "";
                } else {
                    strSubstring = "." + strM6643a;
                }
                strM11415a = C3243r.m11415a(file.getAbsolutePath(), str6, strValueOf + strSubstring);
            }
        }
        if (strM11415a != null) {
            file2 = new File(Uri.parse(strM11415a).getPath());
        } else {
            strM11415a = strDecode;
            file2 = file;
        }
        if (TextUtils.isEmpty(strM11415a)) {
            C1759s.m7260a("MessageControl", "requestSendFile(), invalid Local File URI", new Object[0]);
            return -1L;
        }
        String str7 = "\n\n\n\n\n\n";
        if (!TextUtils.isEmpty(str4)) {
            str7 = "mixed\n\n\n\n\n\n" + str4;
        }
        int i = 0;
        if (!enumC1751k.m7198a() && C1757q.m7251b()) {
            i = 6;
        }
        C1373q.m6168a(GlobalApplication.m11493l().getContentResolver(), String.valueOf(jM11148a), this.f5046i, enumC1455w, strM11415a, strArr.length, str7, i, str5);
        String strM11423b = enumC1455w == EnumC1455w.AUDIO ? C3243r.m11423b(strM11415a) : str3;
        switch (C1341s.f5066b[enumC1455w.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (TextUtils.isEmpty(strM11423b)) {
                    return -1L;
                }
                C1373q.m6178a(GlobalApplication.m11493l().getContentResolver(), this.f5046i, Long.valueOf(jM11148a), strM11423b);
                break;
        }
        if (!enumC1751k.m7198a() && C1757q.m7251b()) {
            return m5794a(jM11148a, file2, str, enumC1455w, enumC1450r, str2, strArr, z, strM11423b, str4, str5, str7);
        }
        return m5833a(jM11148a, file2, str, enumC1455w, enumC1450r, str2, strArr, z, strM11423b, str4, str5, true, enumC1751k);
    }

    /* renamed from: a */
    private long m5794a(long j, File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4, String str5, String str6) {
        int i;
        if (!C1757q.m7251b()) {
            i = 0;
        } else {
            i = 6;
        }
        C1756p.m7237a(this.f5046i, enumC1450r, j, enumC1455w, str6, str5, EnumC1741aa.m7156a(i), strArr, str3, 0, Uri.decode(Uri.fromFile(file).toString()));
        return j;
    }

    /* renamed from: a */
    public long m5833a(long j, File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4, String str5, boolean z2, EnumC1751k enumC1751k) {
        C1561g.m6628a().m6632a(this.f5060y, str2, file, j, this.f5046i, enumC1450r, enumC1455w, str, strArr, str3, false, str4, str5, z2, enumC1751k);
        return j;
    }

    /* renamed from: a */
    private boolean m5801a(long j, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4, String str5, String str6) {
        return m5802a(j, str, enumC1455w, enumC1450r, str2, strArr, z, str3, str4, str5, str6, EnumC1751k.f6455d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5802a(long j, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4, String str5, String str6, EnumC1751k enumC1751k) {
        C1759s.m7260a("MessageControl", "doSendFileInternal(), msgId(%d), extension(%s), msgType(%s), chatType(%s), sessionId(%s), isInit(%s), message(%s), result(%s), extraChat(%s), ignoreAutoResend(%s)", Long.valueOf(j), str, enumC1455w, enumC1450r, str2, Boolean.valueOf(z), str3, str4, str5, enumC1751k);
        if (TextUtils.isEmpty(str4)) {
            if (C3250y.f11734b) {
                C3250y.m11450b("result is null", "MessageControl");
            }
            return false;
        }
        if (z && enumC1450r != EnumC1450r.BROADCAST) {
            synchronized (this.f5041d) {
                if (this.f5054r) {
                    C0975i c0975i = new C0975i();
                    c0975i.m5224a(strArr).m5220a(enumC1450r.m6342a()).m5225b(enumC1455w.m6364a()).m5227b(str3).m5226b(j).m5228c(j).m5231e(str4).m5230d(str).m5232f(str5).m5233g(str6).m5222a(enumC1751k);
                    this.f5053q.add(c0975i.mo5219a());
                    return true;
                }
                this.f5054r = true;
            }
        }
        C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1228db(c1318bd.m5681b(), this.f5046i, j, str, enumC1455w, enumC1450r, str2, strArr, str4, z, str3, str5, str6, enumC1751k));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return true;
    }

    /* renamed from: a */
    public long m5830a(long j, File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, EnumC1751k enumC1751k) {
        return m5832a(j, file, str, enumC1455w, enumC1450r, str2, strArr, z, str3, (String) null, (String) null, enumC1751k);
    }

    /* renamed from: a */
    public long m5831a(long j, File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4) {
        return m5832a(j, file, str, enumC1455w, enumC1450r, str2, strArr, z, str3, str4, (String) null, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5832a(long j, File file, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String[] strArr, boolean z, String str3, String str4, String str5, EnumC1751k enumC1751k) {
        C1561g.m6628a().m6631a(this.f5060y, str2, file, j, this.f5046i, enumC1450r, enumC1455w, str, strArr, str3, true, str4, str5, enumC1751k);
        return j;
    }

    /* renamed from: a */
    public long m5818a(long j, EnumC1450r enumC1450r, String str, String str2, String[] strArr, boolean z, String str3, String str4, EnumC1455w enumC1455w) {
        return m5819a(j, enumC1450r, str, str2, strArr, z, str3, str4, enumC1455w, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5819a(long j, EnumC1450r enumC1450r, String str, String str2, String[] strArr, boolean z, String str3, String str4, EnumC1455w enumC1455w, EnumC1751k enumC1751k) {
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
                C1373q.m6196e(CommonApplication.m11493l().getContentResolver(), Long.valueOf(j));
                return m5829a(j, this.f5057u, this.f5055s, strArr, z, str3, (File) null, str4, strArrSplit[2] + "\n" + strArrSplit[3] + "\n" + strArrSplit[4], enumC1455w, strSubstring, enumC1751k);
            }
        }
        return -1L;
    }

    /* renamed from: a */
    public boolean m5878a(File file, boolean z, String str, String str2, String str3, EnumC1455w enumC1455w, ArrayList<String> arrayList) {
        return m5879a(file, z, str, str2, str3, enumC1455w, arrayList, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public boolean m5879a(File file, boolean z, String str, String str2, String str3, EnumC1455w enumC1455w, ArrayList<String> arrayList, EnumC1751k enumC1751k) throws Throwable {
        String string;
        String strM11415a = C3243r.m11415a(file.getAbsolutePath(), GlobalApplication.m6447a().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f5046i, file.getName());
        Long lValueOf = Long.valueOf(C3193bh.m11148a());
        String[] strArrSplit = str.split("\n");
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        int length = strArrSplit.length;
        if (length < 5) {
            C1759s.m7260a("MessageControl", "requestSendMediaChatForward(), token length is too short (%d)", Integer.valueOf(length));
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
        if (!enumC1751k.m7198a() && C1757q.m7251b()) {
            i3 = 6;
        }
        C1373q.m6168a(GlobalApplication.m11493l().getContentResolver(), String.valueOf(lValueOf), this.f5046i, enumC1455w, strM11415a, arrayList.size(), string, i3, null);
        C1373q.m6195d(GlobalApplication.m11493l().getContentResolver(), lValueOf);
        if (enumC1455w == EnumC1455w.CONTACT || enumC1455w == EnumC1455w.CALENDAR || enumC1455w == EnumC1455w.DOCUMENT || enumC1455w == EnumC1455w.FILE) {
            C1373q.m6178a(GlobalApplication.m11493l().getContentResolver(), this.f5046i, lValueOf, str4);
        }
        if (!enumC1751k.m7198a() && C1757q.m7251b()) {
            C1756p.m7237a(this.f5046i, this.f5057u, lValueOf.longValue(), enumC1455w, string, (String) null, EnumC1741aa.PENDING, strArr, str4, 1, Uri.decode(Uri.fromFile(file).toString()));
            C1756p.m7233a(this.f5046i, lValueOf.longValue(), EnumC1741aa.SENDING, (Integer) 1);
            if (enumC1455w == EnumC1455w.CONTACT || enumC1455w == EnumC1455w.CALENDAR || enumC1455w == EnumC1455w.DOCUMENT || enumC1455w == EnumC1455w.FILE) {
                C1756p.m7235a(this.f5046i, lValueOf.longValue(), str4);
            }
        } else {
            m5829a(lValueOf.longValue(), this.f5057u, this.f5055s, strArr, z, str4, file, str2, str5, enumC1455w, str3, enumC1751k);
        }
        return true;
    }

    /* renamed from: a */
    public long m5829a(long j, EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, File file, String str3, String str4, EnumC1455w enumC1455w, String str5, EnumC1751k enumC1751k) {
        if (z && enumC1450r != EnumC1450r.BROADCAST) {
            synchronized (this.f5041d) {
                if (this.f5054r) {
                    C0975i c0975i = new C0975i();
                    c0975i.m5224a(strArr).m5220a(enumC1450r.m6342a()).m5225b(enumC1455w.m6364a()).m5227b(str2).m5226b(j).m5228c(j).m5231e(str4).m5232f(str5).m5222a(enumC1751k);
                    this.f5053q.add(c0975i.mo5219a());
                } else {
                    this.f5054r = true;
                    C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
                    c1318bd.m5680a(EnumC1322bh.NetTask, new C1228db(c1318bd.m5681b(), this.f5046i, j, str3, enumC1455w, enumC1450r, str, strArr, str4, z, str2, str5, enumC1751k));
                    this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
                    c1318bd.m5683d();
                }
            }
        } else {
            C1318bd c1318bd2 = new C1318bd(this.f5038A, this.f5047j);
            c1318bd2.m5680a(EnumC1322bh.NetTask, new C1228db(c1318bd2.m5681b(), this.f5046i, j, str3, enumC1455w, enumC1450r, str, strArr, str4, z, str2, str5, enumC1751k));
            this.f5052p.put(Long.valueOf(c1318bd2.m5678a()), c1318bd2);
            c1318bd2.m5683d();
        }
        return j;
    }

    /* renamed from: a */
    public long m5848a(EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, long j, String str3, String str4) {
        return m5849a(enumC1450r, str, strArr, z, str2, j, str3, str4, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5849a(EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, long j, String str3, String str4, EnumC1751k enumC1751k) {
        String str5 = !TextUtils.isEmpty(str4) ? str4 : str3;
        String strM5580a = C1275n.m5580a(str2, str5);
        long jM11148a = C3193bh.m11148a();
        int i = 0;
        if (!enumC1751k.m7198a() && C1757q.m7251b()) {
            i = 6;
        }
        C1373q.m6169a(GlobalApplication.m11493l().getContentResolver(), String.valueOf(jM11148a), this.f5046i, EnumC1455w.ANICON, C1275n.m5580a(str2, str3), str4, strArr.length, i);
        if (enumC1751k.m7198a() || !C1757q.m7251b()) {
            return m5826a(jM11148a, enumC1450r, str, strArr, z, str2, j, str5, enumC1751k);
        }
        C1756p.m7236a(this.f5046i, this.f5057u, jM11148a, EnumC1455w.ANICON, strM5580a, null, EnumC1741aa.m7156a(i), strArr);
        return jM11148a;
    }

    /* renamed from: a */
    public long m5825a(long j, EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, long j2, String str3) {
        return m5826a(j, enumC1450r, str, strArr, z, str2, j2, str3, EnumC1751k.f6455d);
    }

    /* renamed from: a */
    public long m5826a(long j, EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, long j2, String str3, EnumC1751k enumC1751k) {
        C1318bd c1318bd;
        if (z && enumC1450r != EnumC1450r.BROADCAST) {
            synchronized (this.f5041d) {
                if (this.f5054r) {
                    C0975i c0975i = new C0975i();
                    c0975i.m5224a(strArr).m5220a(enumC1450r.m6342a()).m5225b(EnumC1455w.ANICON.m6364a()).m5226b(j).m5227b(str2).m5232f(str3);
                    if (j2 != -1) {
                        c0975i.m5228c(j2);
                    } else {
                        c0975i.m5228c(C3193bh.m11148a());
                    }
                    C0974h c0974hMo5219a = c0975i.mo5219a();
                    this.f5053q.add(c0974hMo5219a);
                    return c0974hMo5219a.m5213i();
                }
                this.f5054r = true;
            }
        }
        if (j2 != -1) {
            c1318bd = new C1318bd(this.f5038A, this.f5047j, j2);
        } else {
            c1318bd = new C1318bd(this.f5038A, this.f5047j);
        }
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1275n(c1318bd.m5681b(), this.f5046i, j, enumC1450r, str, strArr, z, str2, str3, enumC1751k));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: b */
    public long m5883b(long j, EnumC1450r enumC1450r, String str, String[] strArr, boolean z, String str2, long j2, String str3) {
        C1318bd c1318bd;
        if (z && enumC1450r != EnumC1450r.BROADCAST) {
            synchronized (this.f5041d) {
                if (this.f5054r) {
                    C0975i c0975i = new C0975i();
                    c0975i.m5224a(strArr).m5220a(enumC1450r.m6342a()).m5225b(EnumC1455w.ANICON.m6364a()).m5226b(j).m5227b(str2).m5226b(j);
                    if (j2 != -1) {
                        c0975i.m5228c(j2);
                    } else {
                        c0975i.m5228c(C3193bh.m11148a());
                    }
                    C0974h c0974hMo5219a = c0975i.mo5219a();
                    this.f5053q.add(c0974hMo5219a);
                    return c0974hMo5219a.m5213i();
                }
                this.f5054r = true;
            }
        }
        if (j2 != -1) {
            c1318bd = new C1318bd(this.f5038A, this.f5047j, j2);
        } else {
            c1318bd = new C1318bd(this.f5038A, this.f5047j);
        }
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1275n(c1318bd.m5681b(), this.f5046i, j, enumC1450r, str, strArr, z, str2, str3));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        C1373q.m6196e(CommonApplication.m11493l().getContentResolver(), Long.valueOf(j));
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public void m5870a(C0400o c0400o) {
        new C1277p(this.f5044g, c0400o).m5540a(this.f5047j);
    }

    /* renamed from: a */
    public long m5856a(EnumC1455w enumC1455w, String str, String[] strArr, String[] strArr2) {
        C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1225cz(c1318bd.m5681b(), enumC1455w, str, strArr, strArr2, this.f5046i));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public long m5865a(String str, String[] strArr, String[] strArr2, boolean z) {
        C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1286y(c1318bd.m5681b(), str, strArr, strArr2, z, this.f5046i));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: i */
    public void m5900i() {
        C1759s.m7260a("MessageControl", "------------------- Message Control CLEARED (%s ) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ---------------------", this.f5046i);
        if (this.f5047j != null) {
            C1596x.m6761e(this.f5047j);
            f5036o.remove(this.f5046i);
        }
    }

    /* renamed from: a */
    public long m5838a(EnumC1450r enumC1450r, String str, String str2) {
        C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
        c1318bd.m5680a(EnumC1322bh.NetTask, new C1168aw(c1318bd.m5681b(), enumC1450r, str, str2));
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public long m5866a(ArrayList<String> arrayList, ArrayList<C0280ad> arrayList2) {
        C1318bd c1318bd = new C1318bd(this.f5038A, this.f5047j);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            if (i > 0 && i % f5037x == 0) {
                c1318bd.m5680a(EnumC1322bh.NetTask, new C1278q(c1318bd.m5681b(), arrayList3, arrayList4));
                arrayList3.clear();
                arrayList4.clear();
            }
            arrayList3.add(arrayList.get(i));
            arrayList4.add(arrayList2.get(i));
        }
        if (arrayList4.size() > 0) {
            c1318bd.m5680a(EnumC1322bh.NetTask, new C1278q(c1318bd.m5681b(), arrayList3, arrayList4));
            arrayList3.clear();
            arrayList4.clear();
        }
        this.f5052p.put(Long.valueOf(c1318bd.m5678a()), c1318bd);
        c1318bd.m5683d();
        return c1318bd.m5678a();
    }

    /* renamed from: a */
    public boolean m5880a(String str, String str2, int i) {
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
        C1547af c1547af = new C1547af();
        this.f5046i = str;
        try {
            c1547af.m6566a(str).m6567b(str2).m6564a(i).m6565a((C3158a) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f5047j = c1547af.m6563a();
            m5899h();
            return true;
        } catch (NoSuchFieldException e2) {
            C3250y.m11442a("TCP Context buiilder" + e2, toString());
            this.f5047j = null;
            return false;
        } finally {
            C3250y.m11456e("ChatRoom Info : InboxNO = " + this.f5046i + " SERVER = " + str2, getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m5893c(long j) {
        if (this.f5047j != null) {
            this.f5047j.m6552a(j);
        }
    }

    /* renamed from: j */
    public void m5901j() {
        C1077es.m5328a(this.f5046i);
        if (this.f5047j != null && C1596x.m6753a(this.f5047j)) {
            C1596x.m6760d(this.f5047j);
        }
    }

    /* renamed from: k */
    public void m5902k() {
        C1077es.m5328a(this.f5046i);
        if (this.f5047j != null) {
            C1596x.m6757c(this.f5047j);
        }
    }

    /* renamed from: l */
    public boolean m5903l() {
        if (this.f5047j != null) {
            return C1596x.m6753a(this.f5047j);
        }
        return false;
    }

    /* renamed from: a */
    public void m5873a(boolean z) {
        this.f5048k = z;
    }

    /* renamed from: m */
    public boolean m5904m() {
        return this.f5048k;
    }

    /* renamed from: b */
    public void m5887b(boolean z) {
        this.f5051n = z;
    }

    /* renamed from: n */
    public boolean m5905n() {
        return this.f5051n;
    }

    /* renamed from: e */
    public void m5897e(String str) {
        this.f5049l = str;
    }

    /* renamed from: o */
    public String m5906o() {
        return this.f5049l;
    }

    /* renamed from: p */
    public boolean m5907p() {
        boolean z;
        synchronized (this.f5041d) {
            z = this.f5054r;
        }
        return z;
    }

    @Override // com.sec.chaton.p037j.InterfaceC1592t
    /* renamed from: a */
    public void mo5552a(int i, Object obj) {
    }

    @Override // com.sec.chaton.p037j.InterfaceC1592t
    /* renamed from: a */
    public void mo5553a(int i, Object obj, Object obj2) {
        if (obj2 != null) {
            C1548ag c1548ag = (C1548ag) obj2;
            if (c1548ag.m6575c() != null) {
                switch (c1548ag.m6574b()) {
                    case 6:
                        C0307bd c0307bd = (C0307bd) c1548ag.m6575c();
                        C3250y.m11450b("DeliveryChat From Server : Session ID = " + c0307bd.m1726d(), getClass().getSimpleName());
                        m5868a(c0307bd);
                        break;
                    case 10:
                        C0400o c0400o = (C0400o) c1548ag.m6575c();
                        C3250y.m11450b("AnswerBack From Server", getClass().getSimpleName());
                        m5870a(c0400o);
                        break;
                    case 16:
                        C0394i c0394i = (C0394i) c1548ag.m6575c();
                        C3250y.m11450b("AnnounceChange From Server", getClass().getSimpleName());
                        m5869a(c0394i);
                        break;
                }
            }
        }
    }

    /* renamed from: f */
    public static boolean m5816f(String str) {
        return (TextUtils.isEmpty(str) || "null".equals(str) || "".equals(str)) ? false : true;
    }

    /* renamed from: q */
    public boolean m5908q() {
        return (this.f5057u == EnumC1450r.BROADCAST || m5816f(this.f5055s)) ? false : true;
    }
}
