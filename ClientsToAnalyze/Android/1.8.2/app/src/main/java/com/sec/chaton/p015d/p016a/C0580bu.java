package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1793y;
import java.util.LinkedHashMap;

/* compiled from: SpecialBuddyStuffTask.java */
/* renamed from: com.sec.chaton.d.a.bu */
/* loaded from: classes.dex */
public class C0580bu extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2309d;

    /* renamed from: e */
    private long f2310e;

    public C0580bu(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2309d = str;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1793y c1793y = new C1793y();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("specialuserid", this.f2309d);
        String strM6112a = c1793y.m6112a((Object) linkedHashMap);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            if (c0101b.m671d() != null) {
                this.f2310e = Integer.parseInt(c0101b.m671d().toString());
            }
            C1786r.m6061b("SpecialBuddyStuffTask Special Buddy NO : " + this.f2309d, getClass().getSimpleName());
            return;
        }
        C1786r.m6061b("SpecialBuddyStuffTask : UnFollow Special Buddy NO : " + this.f2309d, getClass().getSimpleName());
    }
}
