package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p065io.entry.inner.BuddyProfileNew;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.util.C4904y;

/* compiled from: GetHideBuddyProfileTask.java */
/* renamed from: com.sec.chaton.d.a.bv */
/* loaded from: classes.dex */
public class C1949bv extends AbstractC1900a {
    public C1949bv(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4904y.m18646e("beforeRequest", "GetHideBuddyProfileTask");
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        BuddyProfileNew buddyProfileNew;
        if (c0778b.m18954n() && c0778b.m3110e() != null && (buddyProfileNew = (BuddyProfileNew) c0778b.m3110e()) != null && buddyProfileNew.buddy != null && buddyProfileNew.buddy.size() > 0) {
            Buddy buddy = buddyProfileNew.buddy.get(0);
            C4904y.m18646e("Name : " + buddy.name + ", Status : " + buddy.status + ", Birthday : " + buddy.birthday + ", Samsungemail : " + buddy.samsungemail + ", Sainfo : " + buddy.sainfo + ", Imgstatus : " + buddy.imgstatus + ", Orgnum : " + buddy.orgnum + ", Orgnums: " + buddy.orgnums + ", Einfo : " + buddy.einfo + ", Orgname : " + buddy.orgname + ", Msisdns : " + buddy.msisdns + ", Devicetype : " + buddy.imgstatus, getClass().getSimpleName());
        }
    }
}
