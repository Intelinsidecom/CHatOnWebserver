package com.sec.chaton.p015d.p016a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.account.C0210g;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.p018a.C0657a;
import com.sec.chaton.p017e.p018a.C0658b;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p028io.entry.GetBuddyList;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetAllBuddiesTask.java */
/* renamed from: com.sec.chaton.d.a.ah */
/* loaded from: classes.dex */
public class C0540ah extends AbstractRunnableC0532a {

    /* renamed from: d */
    private Long f2203d;

    public C0540ah(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        if (c0101b.m664a() && c0101b.m671d() != null) {
            GetBuddyList getBuddyList = (GetBuddyList) c0101b.m671d();
            this.f2203d = getBuddyList.timestamp;
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            C1786r.m6063c("the number of buddy from Server : " + getBuddyList.buddy.size(), getClass().getSimpleName());
            Iterator it = getBuddyList.buddy.iterator();
            while (it.hasNext()) {
                Buddy buddy = (Buddy) it.next();
                C1786r.m6066e("NO : " + buddy.value + ", OrgNumber : " + buddy.orgnum + ", Name : " + buddy.name + ", Deleted : " + buddy.deleted + ", OrgName : " + buddy.orgname, getClass().getSimpleName());
                C1786r.m6066e("StatusMsg : " + buddy.status + ", ImageStatus : " + buddy.getImagestatus().toString() + ", BIRTHDAY : " + buddy.birthday + ", showphonenumber=" + buddy.showphonenumber + ", extra info : " + buddy.einfo, getClass().getSimpleName());
                if (!buddy.deleted.booleanValue()) {
                    if (!buddy.value.startsWith("0999")) {
                        arrayList.add(C0657a.m2982c(buddy));
                    } else if (!m2731a(buddy.value)) {
                        arrayList.add(C0657a.m2974a(buddy));
                    } else {
                        arrayList.add(C0657a.m2980b(buddy));
                    }
                    arrayList.add(C0555aw.m2754a(buddy.value));
                    if (buddy.getImagestatus() != Buddy.BuddyImageStatus.NOT_CHANGE) {
                        C1746bb.m5945a(GlobalApplication.m3260b()).m5961a(buddy.value);
                    }
                } else {
                    arrayList.add(C0657a.m2984d(buddy));
                    arrayList.add(C0658b.m2989a(buddy.value));
                    arrayList.add(C0657a.m2986e(buddy));
                    arrayList.add(C0660d.m3009a(buddy.value));
                    if (buddy.blocked.booleanValue()) {
                        C1786r.m6066e("Deleted NO : " + buddy.value + "is just blocked.", getClass().getSimpleName());
                    } else {
                        C1786r.m6066e("Deleted NO : " + buddy.value + "is deleted account.", getClass().getSimpleName());
                        arrayList.add(C0660d.m3010a(buddy.value, C0670n.m3089d(GlobalApplication.m3260b().getContentResolver(), buddy.value), this.f2203d.longValue() * 1000));
                    }
                    C1746bb.m5945a(GlobalApplication.m3260b()).m5961a(buddy.value);
                }
            }
            GlobalApplication.m3260b().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            C1786r.m6063c("the number of buddy from Server : " + getBuddyList.buddy.size() + " written in db.", getClass().getSimpleName());
            C0210g.m1810a(GlobalApplication.m3260b(), getBuddyList.buddy);
            C1789u.m6078a("get_all_buddies_timestamp", this.f2203d);
            this.f2203d = null;
            C0660d.m3021a(GlobalApplication.m3260b());
        }
    }

    /* renamed from: a */
    boolean m2731a(String str) {
        boolean z;
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0704s.f2647a, null, "buddy_no='" + str + "'", null, null);
        if (cursorQuery.getCount() <= 0) {
            z = false;
        } else {
            z = true;
        }
        cursorQuery.close();
        return z;
    }
}
