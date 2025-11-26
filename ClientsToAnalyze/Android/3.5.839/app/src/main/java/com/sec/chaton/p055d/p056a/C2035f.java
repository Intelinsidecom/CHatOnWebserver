package com.sec.chaton.p055d.p056a;

import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.EnumC2129j;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p065io.entry.inner.Address;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AddBuddyPreviewTask.java */
/* renamed from: com.sec.chaton.d.a.f */
/* loaded from: classes.dex */
public class C2035f extends AbstractC1900a {

    /* renamed from: b */
    EnumC2129j f7439b;

    /* renamed from: c */
    private String f7440c;

    public C2035f(C2454e c2454e, String str) {
        super(c2454e);
        this.f7439b = EnumC2129j.NONE;
        this.f7440c = str;
    }

    public C2035f(C2454e c2454e, String str, EnumC2129j enumC2129j) {
        this(c2454e, str);
        this.f7439b = enumC2129j;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        ArrayList arrayList = new ArrayList();
        Address address = new Address();
        if (this.f7439b != EnumC2129j.NONE) {
            address.idtype = String.valueOf(this.f7439b.m9536a());
        }
        address.value = this.f7440c;
        arrayList.add(address);
        String strM18172a = new C4815ag().m18172a(arrayList);
        C4904y.m18646e("\n" + strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3110e() != null) {
            GetBuddyList getBuddyList = (GetBuddyList) c0778b.m3110e();
            ArrayList arrayList = new ArrayList();
            Iterator<Buddy> it = getBuddyList.buddy.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                if (next.getImagestatus() == Buddy.BuddyImageStatus.PROFILE_UPDATED) {
                    arrayList.add(next.value);
                }
            }
            C2496n.m10761a(GlobalApplication.m18732r(), arrayList);
        }
    }
}
