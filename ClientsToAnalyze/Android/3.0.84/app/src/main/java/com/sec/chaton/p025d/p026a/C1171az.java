package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import java.util.LinkedHashMap;

/* compiled from: FollowSpecialBuddyTask.java */
/* renamed from: com.sec.chaton.d.a.az */
/* loaded from: classes.dex */
public class C1171az extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4643b = C1171az.class.getSimpleName();

    /* renamed from: c */
    private String f4644c;

    public C1171az(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4644c = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("specialuserid", this.f4644c);
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            C3250y.m11450b("success() Livepartner ID : " + this.f4644c, f4643b);
            new C1330h(null).m5736c();
        } else {
            C3250y.m11450b("fail() Livepartner ID  : " + this.f4644c, f4643b);
        }
    }
}
