package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import org.apache.http.NameValuePair;

/* compiled from: GetVersionTask.java */
/* renamed from: com.sec.chaton.a.a.ay */
/* loaded from: classes.dex */
public class C0149ay extends AbstractRunnableC0153bb {
    public C0149ay(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            for (NameValuePair nameValuePair : c0259g.m931c().m2531d()) {
                if (nameValuePair.getName().equals("regid")) {
                    String value = nameValuePair.getValue();
                    C1341p.m4658b("Save get version push registration id to pref: " + value, C0149ay.class.getSimpleName());
                    C1323bs.m4575a().edit().putString("get_version_push_reg_id", value).commit();
                }
            }
        }
    }
}
