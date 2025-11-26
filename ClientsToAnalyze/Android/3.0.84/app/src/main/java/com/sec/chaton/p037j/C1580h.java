package com.sec.chaton.p037j;

import android.os.Handler;
import android.util.Log;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3216cd;
import com.sec.chaton.util.C3247v;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.common.p066d.p067a.AbstractC3314a;
import com.sec.common.p066d.p067a.EnumC3320d;
import com.sec.common.p066d.p067a.p068a.C3316b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: HttpEnvelope.java */
/* renamed from: com.sec.chaton.j.h */
/* loaded from: classes.dex */
public class C1580h extends C3316b {

    /* renamed from: c */
    private EnumC3219cg f5865c;

    /* renamed from: d */
    private String f5866d;

    /* renamed from: e */
    private Class<?> f5867e;

    /* renamed from: f */
    private int f5868f;

    /* renamed from: g */
    private Handler f5869g;

    /* renamed from: b */
    private static final String f5864b = C1580h.class.getSimpleName();

    /* renamed from: a */
    public static final String f5863a = String.valueOf(400);

    /* synthetic */ C1580h(C1582j c1582j, C1581i c1581i) {
        this(c1582j);
    }

    /* renamed from: a */
    public EnumC3219cg m6698a() {
        return this.f5865c;
    }

    /* renamed from: b */
    public String m6702b() {
        return this.f5866d;
    }

    @Override // com.sec.common.p066d.p067a.C3319c
    /* renamed from: c */
    public String mo6703c() {
        if (this.f5865c == EnumC3219cg.BYPASS) {
            try {
                URL url = new URL(m6702b());
                return (url.getProtocol() + "://" + url.getHost()) + url.getFile();
            } catch (MalformedURLException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f5864b);
                }
                return "";
            }
        }
        return C3216cd.m11283b(this.f5865c) + m6702b();
    }

    /* renamed from: d */
    public int m6704d() {
        return this.f5868f;
    }

    /* renamed from: a */
    public void m6699a(int i) {
        this.f5868f = i;
    }

    /* renamed from: e */
    public Handler m6705e() {
        return this.f5869g;
    }

    /* renamed from: a */
    public void m6700a(Handler handler) {
        this.f5869g = handler;
    }

    /* renamed from: f */
    public List<NameValuePair> m6706f() {
        ArrayList arrayList = new ArrayList();
        Map<String, String> mapO = m11696o();
        if (mapO != null) {
            for (Map.Entry<String, String> entry : mapO.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    public String m6707g() {
        return m11691j().get("Content-Type");
    }

    /* renamed from: a */
    public void m6701a(Class<?> cls) {
        try {
            if (this.f5867e != null) {
                AbstractC3314a abstractC3314a = (AbstractC3314a) cls.newInstance();
                if (abstractC3314a instanceof C3164af) {
                    ((C3164af) abstractC3314a).m11027a(this.f5867e);
                } else if (abstractC3314a instanceof C1537b) {
                    ((C1537b) abstractC3314a).m6534a(this.f5867e);
                } else if (abstractC3314a instanceof C3247v) {
                    ((C3247v) abstractC3314a).m11431a(this.f5867e);
                }
                m11662b(abstractC3314a);
                return;
            }
            m11662b((AbstractC3314a) null);
        } catch (Exception e) {
            Log.e(f5864b, e.getMessage(), e);
        }
    }

    private C1580h(C1582j c1582j) {
        this.f5866d = c1582j.f5872a;
        switch (C1581i.f5871b[c1582j.f5874c.ordinal()]) {
            case 1:
                m11682a(EnumC3320d.GET);
                break;
            case 2:
                m11682a(EnumC3320d.POST);
                break;
            case 3:
                m11682a(EnumC3320d.PUT);
                break;
            case 4:
                m11682a(EnumC3320d.DELETE);
                break;
        }
        m11683a(c1582j.f5879h);
        if (c1582j.f5875d == null) {
            c1582j.f5875d.put("r", String.valueOf(System.currentTimeMillis()));
            c1582j.f5875d.put("unauth", f5863a);
        } else {
            if (!c1582j.f5875d.containsKey("r")) {
                c1582j.f5875d.put("r", String.valueOf(System.currentTimeMillis()));
            }
            if (!c1582j.f5875d.containsKey("unauth")) {
                c1582j.f5875d.put("unauth", f5863a);
            }
        }
        m11686b(c1582j.f5875d);
        this.f5867e = c1582j.f5876e;
        m6699a(c1582j.f5877f);
        this.f5865c = c1582j.f5873b;
        m11691j().put("Content-Type", c1582j.f5878g);
        m6701a(c1582j.f5883l);
        m11681a(c1582j.f5884m);
        m11684a(c1582j.f5880i);
        m11687b(c1582j.f5881j);
        m11685b(c1582j.f5882k);
        m11688c(c1582j.f5882k);
    }
}
