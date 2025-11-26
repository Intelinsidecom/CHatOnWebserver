package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.specialbuddy.LivepartnerLikesCountEntry;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import java.util.LinkedHashMap;

/* compiled from: SpecialBuddyStuffTask.java */
/* renamed from: com.sec.chaton.d.a.dv */
/* loaded from: classes.dex */
public class C1248dv extends AbstractC1145a {

    /* renamed from: b */
    private String f4815b;

    /* renamed from: c */
    private long f4816c;

    public C1248dv(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4815b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("specialuserid", this.f4815b);
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            if (c0267d.m1354e() != null) {
                if (((LivepartnerLikesCountEntry) c0267d.m1354e()).count != null) {
                    this.f4816c = Integer.parseInt(r0.count);
                }
            }
            C3250y.m11450b("SpecialBuddyStuffTask Special Buddy NO : " + this.f4815b, getClass().getSimpleName());
            return;
        }
        C3250y.m11450b("SpecialBuddyStuffTask : UnFollow Special Buddy NO : " + this.f4815b, getClass().getSimpleName());
    }
}
