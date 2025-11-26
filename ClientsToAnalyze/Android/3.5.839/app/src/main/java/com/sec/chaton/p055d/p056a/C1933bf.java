package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.text.TextUtils;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p057e.p058a.C2187am;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetAllBuddySyncTask.java */
/* renamed from: com.sec.chaton.d.a.bf */
/* loaded from: classes.dex */
public class C1933bf extends AbstractC1900a {
    public C1933bf(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws Throwable {
        if (c0778b.m18954n() && c0778b.m3110e() != null) {
            GetBuddyList getBuddyList = (GetBuddyList) c0778b.m3110e();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            new ArrayList();
            if (C4904y.f17873c) {
                C4904y.m18641c("the number of buddy from Server : " + getBuddyList.buddy.size(), "GetAllBuddySyncTask");
            }
            Iterator<Buddy> it = getBuddyList.buddy.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                if (next != null) {
                    if (C4904y.f17871a) {
                        C4904y.m18646e("NO : " + next.value + ", OrgNumber : " + next.orgnum + ", Name : " + next.name + ", Deleted : " + next.deleted + ", OrgName : " + next.orgname, "GetAllBuddySyncTask");
                        C4904y.m18646e("StatusMsg : " + next.status + ", ImageStatus : " + next.imgstatus + ", BIRTHDAY : " + next.birthday + ", showphonenumber=" + next.showphonenumber + ", extra info : " + next.einfo, "GetAllBuddySyncTask");
                        C4904y.m18646e("OrgNumbers : " + next.orgnums + ", Msisdns : " + next.msisdns, "GetAllBuddySyncTask");
                        C4904y.m18646e("Group : " + next.group, "GetAllBuddySyncTask");
                        C4904y.m18646e("SEmail : " + next.samsungemail, "GetAllBuddySyncTask");
                        C4904y.m18646e("SAInfo : " + next.sainfo, "GetAllBuddySyncTask");
                        C4904y.m18646e("DeviceType : " + next.devicetype, "GetAllBuddySyncTask");
                    }
                    if (!next.value.startsWith("0999")) {
                        arrayList.add(C2190d.m9801a(next));
                        arrayList.add(C2176ab.m9669a(next.value, 0));
                        C2191e.m9857a(arrayList, next);
                        arrayList.add(C2181ag.m9738a(next.value));
                        arrayList.add(C2187am.m9779a(next.value));
                    }
                    if (next.getImagestatus() != Buddy.BuddyImageStatus.NOT_CHANGE) {
                        C2496n.m10790e(CommonApplication.m18732r(), next.value);
                        C1331gk.m7453a(GlobalApplication.m18732r()).m7470b(next.value);
                    }
                    if (next.value != null && !next.value.startsWith("0999")) {
                        arrayList2.add(next.value);
                    }
                }
            }
            GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            if (C4904y.f17873c) {
                C4904y.m18641c("the number of buddy from Server : " + getBuddyList.buddy.size() + " written in db.", "GetAllBuddySyncTask");
            }
            BuddyFragment.f3584j = C2190d.m9837e(GlobalApplication.m18732r().getContentResolver());
            if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                C1002i.m6057a(GlobalApplication.m18732r(), getBuddyList.buddy);
            }
            C2190d.m9815a(C2190d.m9811a(), (ArrayList<String>) arrayList2);
            C2191e.m9853a();
        }
    }
}
