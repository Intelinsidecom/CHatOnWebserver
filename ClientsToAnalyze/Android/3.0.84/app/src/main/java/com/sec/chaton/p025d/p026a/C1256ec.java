package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import java.util.LinkedHashMap;

/* compiled from: UnFollowSpecialBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.ec */
/* loaded from: classes.dex */
public class C1256ec extends AbstractC1145a {

    /* renamed from: b */
    private String f4824b;

    public C1256ec(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4824b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("specialuserid", this.f4824b);
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            new C1330h(null).m5736c();
            C3250y.m11450b("success - LIVEpatner unfollow, id = " + this.f4824b, getClass().getSimpleName());
        } else {
            C3250y.m11450b("fail - LIVEpatner unfollow, id = " + this.f4824b, getClass().getSimpleName());
        }
    }
}
