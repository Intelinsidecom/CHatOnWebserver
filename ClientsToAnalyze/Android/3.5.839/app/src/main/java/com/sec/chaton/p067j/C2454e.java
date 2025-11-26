package com.sec.chaton.p067j;

import android.util.Log;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4901v;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.p126d.p127a.AbstractC4976a;
import com.sec.common.p126d.p127a.EnumC4988d;
import com.sec.common.p126d.p127a.p129b.C4985b;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: ChatONHttpTextRequestEntry.java */
/* renamed from: com.sec.chaton.j.e */
/* loaded from: classes.dex */
public class C2454e extends C4985b {

    /* renamed from: c */
    private EnumC4868cf f8802c;

    /* renamed from: d */
    private String f8803d;

    /* renamed from: e */
    private Class<?> f8804e;

    /* renamed from: b */
    private static final String f8801b = C2454e.class.getSimpleName();

    /* renamed from: a */
    public static final String f8800a = String.valueOf(AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE);

    /* synthetic */ C2454e(C2456g c2456g, C2455f c2455f) {
        this(c2456g);
    }

    public C2454e() {
    }

    /* renamed from: a */
    public EnumC4868cf m10628a() {
        return this.f8802c;
    }

    /* renamed from: b */
    public String m10631b() {
        return this.f8803d;
    }

    @Override // com.sec.common.p126d.p127a.C4987c
    /* renamed from: c */
    public String mo10632c() {
        if (this.f8802c == EnumC4868cf.BYPASS) {
            try {
                URL url = new URL(m10631b());
                return (url.getProtocol() + "://" + url.getHost()) + url.getFile();
            } catch (MalformedURLException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f8801b);
                }
                return "";
            }
        }
        return C4865cc.m18450b(this.f8802c) + m10631b();
    }

    @Override // com.sec.common.p126d.p127a.C4987c
    /* renamed from: a */
    public void mo10630a(String str) {
        throw new IllegalAccessError("Can't execute setUrl directly.");
    }

    /* renamed from: d */
    public List<NameValuePair> m10633d() {
        ArrayList arrayList = new ArrayList();
        Map<String, String> mapM = m18946m();
        if (mapM != null) {
            for (Map.Entry<String, String> entry : mapM.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public String m10634e() {
        return m18941h().get("Content-Type");
    }

    /* renamed from: a */
    public void m10629a(Class<?> cls) {
        try {
            if (this.f8804e != null) {
                AbstractC4976a abstractC4976a = (AbstractC4976a) cls.newInstance();
                if (abstractC4976a instanceof C4815ag) {
                    ((C4815ag) abstractC4976a).m18173a(this.f8804e);
                } else if (abstractC4976a instanceof C2407b) {
                    ((C2407b) abstractC4976a).m10438a(this.f8804e);
                } else if (abstractC4976a instanceof C4901v) {
                    ((C4901v) abstractC4976a).m18627a(this.f8804e);
                } else if (abstractC4976a instanceof C2477a) {
                    ((C2477a) abstractC4976a).m10711b(this.f8804e);
                }
                m18923b(abstractC4976a);
                return;
            }
            m18923b((AbstractC4976a) null);
        } catch (Exception e) {
            Log.e(f8801b, e.getMessage(), e);
        }
    }

    private C2454e(C2456g c2456g) {
        this.f8803d = c2456g.f8807a;
        switch (C2455f.f8806b[c2456g.f8809c.ordinal()]) {
            case 1:
                m18930a(EnumC4988d.GET);
                break;
            case 2:
                m18930a(EnumC4988d.POST);
                break;
            case 3:
                m18930a(EnumC4988d.PUT);
                break;
            case 4:
                m18930a(EnumC4988d.DELETE);
                break;
        }
        m18932a(c2456g.f8813g);
        if (!c2456g.f8810d.containsKey("r")) {
            c2456g.f8810d.put("r", String.valueOf(System.currentTimeMillis()));
        }
        if (!c2456g.f8810d.containsKey("unauth")) {
            c2456g.f8810d.put("unauth", f8800a);
        }
        m18936b(c2456g.f8810d);
        this.f8804e = c2456g.f8811e;
        this.f8802c = c2456g.f8808b;
        m18941h().put("Content-Type", c2456g.f8812f);
        m10629a(c2456g.f8817k);
        m18929a(c2456g.f8818l);
        m18933a(c2456g.f8814h);
        m18937b(c2456g.f8815i);
        m18934b(c2456g.f8816j);
        m18938c(c2456g.f8816j);
    }
}
