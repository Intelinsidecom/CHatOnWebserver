package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.os.Handler;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetAllBuddiesTask.java */
/* renamed from: com.sec.chaton.d.a.bb */
/* loaded from: classes.dex */
public class C1174bb extends AbstractC1145a {

    /* renamed from: b */
    private Long f4651b;

    /* renamed from: c */
    private boolean f4652c;

    public C1174bb(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    public C1174bb(Handler handler, C1580h c1580h, boolean z) {
        super(handler, c1580h);
        this.f4652c = z;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws Throwable {
        if (c0267d.m11704n() && c0267d.m1354e() != null) {
            GetBuddyList getBuddyList = (GetBuddyList) c0267d.m1354e();
            this.f4651b = getBuddyList.timestamp;
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            C3250y.m11453c("the number of buddy from Server : " + getBuddyList.buddy.size(), getClass().getSimpleName());
            Iterator<Buddy> it = getBuddyList.buddy.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                C3250y.m11456e("NO : " + next.value + ", OrgNumber : " + next.orgnum + ", Name : " + next.name + ", Deleted : " + next.deleted + ", OrgName : " + next.orgname, getClass().getSimpleName());
                C3250y.m11456e("StatusMsg : " + next.status + ", ImageStatus : " + next.getImagestatus().toString() + ", BIRTHDAY : " + next.birthday + ", showphonenumber=" + next.showphonenumber + ", extra info : " + next.einfo, getClass().getSimpleName());
                C3250y.m11456e("OrgNumbers : " + next.orgnums + ", Msisdns : " + next.msisdns, getClass().getSimpleName());
                C3250y.m11456e("Group : " + next.group, getClass().getSimpleName());
                C3250y.m11456e("SEmail : " + next.samsungemail + "SAInfo : " + next.sainfo, getClass().getSimpleName());
                C3250y.m11456e("Result : " + next.result, getClass().getSimpleName());
                C3250y.m11456e("DeviceType : " + next.devicetype, getClass().getSimpleName());
                if (!next.deleted.booleanValue()) {
                    if (!next.value.startsWith("0999")) {
                        arrayList.add(C1360d.m6019a(next));
                        arrayList.add(C1381y.m6205a(next.value, 0));
                        C1362f.m6064a(arrayList, next);
                        arrayList.add(C1206cg.m5544a(next.value));
                    }
                    if (next.getImagestatus() != Buddy.BuddyImageStatus.NOT_CHANGE) {
                        C3205bt.m11182a(CommonApplication.m11493l()).m11227b(next.value);
                        C3231f.m11361a(CommonApplication.m11493l()).m11386b(next.value);
                    }
                } else {
                    if (next.group != null && next.group.length() > 0) {
                        arrayList.add(C1362f.m6058a(next.group, next.value));
                    }
                    arrayList.add(C1360d.m6035b(next));
                    arrayList.add(C1362f.m6057a(next.value));
                    arrayList.add(C1360d.m6042c(next));
                    arrayList.add(C1370n.m6113a(next.value));
                    if (next.blocked.booleanValue()) {
                        C3250y.m11456e("Deleted NO : " + next.value + "is just blocked.", getClass().getSimpleName());
                    } else {
                        C3250y.m11456e("Deleted NO : " + next.value + "is deleted account.", getClass().getSimpleName());
                    }
                    C3205bt.m11182a(GlobalApplication.m6447a()).m11227b(next.value);
                    C3231f.m11361a(GlobalApplication.m6447a()).m11381a(next.value);
                }
            }
            GlobalApplication.m6447a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            C3250y.m11453c("the number of buddy from Server : " + getBuddyList.buddy.size() + " written in db.", getClass().getSimpleName());
            BuddyFragment.f1732k = C1360d.m6051e(GlobalApplication.m6447a().getContentResolver());
            C0423i.m3037a(GlobalApplication.m6447a(), getBuddyList.buddy);
            if (this.f4652c) {
                C0423i.m3050b(false);
            }
            C3159aa.m10965a("get_all_buddies_timestamp", this.f4651b);
            this.f4651b = null;
            return;
        }
        if (this.f4652c) {
            C3250y.m11453c("manualContactSync", getClass().getSimpleName());
            C0423i.m3050b(false);
        }
    }
}
