package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import org.apache.http.NameValuePair;

/* compiled from: GetVersionTask.java */
/* renamed from: com.sec.chaton.d.a.bb */
/* loaded from: classes.dex */
public class C0561bb extends AbstractRunnableC0532a {
    public C0561bb(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            for (NameValuePair nameValuePair : c0101b.m669c().m3396d()) {
                if (nameValuePair.getName().equals("regid")) {
                    String value = nameValuePair.getValue();
                    C1786r.m6061b("Save get version push registration id to pref: " + value, C0561bb.class.getSimpleName());
                    C1789u.m6075a().edit().putString("get_version_push_reg_id", value).commit();
                }
            }
        }
    }
}
