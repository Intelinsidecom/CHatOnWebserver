package com.sec.chaton.p013a.p014a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.account.C0239h;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p025d.p026a.C0622b;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0633m;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p033io.entry.GetBuddyList;
import com.sec.chaton.p033io.entry.inner.Buddy;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetAllBuddiesTask.java */
/* renamed from: com.sec.chaton.a.a.az */
/* loaded from: classes.dex */
public class C0150az extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private Long f362a;

    public C0150az(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws RemoteException, OperationApplicationException {
        if (c0259g.m927a() && c0259g.m932d() != null) {
            GetBuddyList getBuddyList = (GetBuddyList) c0259g.m932d();
            this.f362a = getBuddyList.timestamp;
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            C1341p.m4660c("the number of buddy from Server : " + getBuddyList.buddy.size(), getClass().getSimpleName());
            Iterator it = getBuddyList.buddy.iterator();
            while (it.hasNext()) {
                Buddy buddy = (Buddy) it.next();
                C1341p.m4662e("NO : " + buddy.value + ", OrgNumber : " + buddy.orgnum + ", Name : " + buddy.name + ", Deleted : " + buddy.deleted + ", OrgName : " + buddy.orgname, getClass().getSimpleName());
                C1341p.m4662e("StatusMsg : " + buddy.status + ", ImageStatus : " + buddy.getImagestatus().toString() + ", BIRTHDAY : " + buddy.birthday + ", showphonenumber=" + buddy.showphonenumber + ", extra info : " + buddy.einfo, getClass().getSimpleName());
                if (!buddy.deleted.booleanValue()) {
                    arrayList.add(C0633m.m2879a(buddy));
                    arrayList.add(C0165d.m706a(buddy.value));
                    if (buddy.getImagestatus() != Buddy.BuddyImageStatus.NOT_CHANGE) {
                        C1348w.m4685a(GlobalApplication.m3100a()).m4701a(buddy.value);
                    }
                } else {
                    arrayList.add(C0633m.m2886b(buddy));
                    arrayList.add(C0622b.m2842a(buddy.value));
                    arrayList.add(C0634n.m2896a(buddy.value));
                    if (buddy.blocked.booleanValue()) {
                        C1341p.m4662e("Deleted NO : " + buddy.value + "is just blocked.", getClass().getSimpleName());
                    } else {
                        C1341p.m4662e("Deleted NO : " + buddy.value + "is deleted account.", getClass().getSimpleName());
                        arrayList.add(C0634n.m2897a(buddy.value, C0631k.m2870d(GlobalApplication.m3100a().getContentResolver(), buddy.value), this.f362a.longValue() * 1000));
                    }
                    C1348w.m4685a(GlobalApplication.m3100a()).m4701a(buddy.value);
                }
            }
            GlobalApplication.m3100a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            C1341p.m4660c("the number of buddy from Server : " + getBuddyList.buddy.size() + " written in db.", getClass().getSimpleName());
            C0239h.m907a(GlobalApplication.m3100a(), getBuddyList.buddy);
            C1323bs.m4578a("get_all_buddies_timestamp", this.f362a);
            this.f362a = null;
            C0634n.m2906a(GlobalApplication.m3100a());
        }
    }
}
