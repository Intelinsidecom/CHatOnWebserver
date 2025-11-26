package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1381y;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetAllBuddySyncTask.java */
/* renamed from: com.sec.chaton.d.a.bc */
/* loaded from: classes.dex */
public class C1175bc extends AbstractC1145a {
    public C1175bc(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) throws RemoteException, OperationApplicationException {
        if (c0267d.m11704n() && c0267d.m1354e() != null) {
            GetBuddyList getBuddyList = (GetBuddyList) c0267d.m1354e();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            new ArrayList();
            if (C3250y.f11735c) {
                C3250y.m11453c("the number of buddy from Server : " + getBuddyList.buddy.size(), "GetAllBuddySyncTask");
            }
            Iterator<Buddy> it = getBuddyList.buddy.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                if (C3250y.f11733a) {
                    C3250y.m11456e("NO : " + next.value + ", OrgNumber : " + next.orgnum + ", Name : " + next.name + ", Deleted : " + next.deleted + ", OrgName : " + next.orgname, "GetAllBuddySyncTask");
                    C3250y.m11456e("StatusMsg : " + next.status + ", ImageStatus : " + next.imgstatus + ", BIRTHDAY : " + next.birthday + ", showphonenumber=" + next.showphonenumber + ", extra info : " + next.einfo, "GetAllBuddySyncTask");
                    C3250y.m11456e("OrgNumbers : " + next.orgnums + ", Msisdns : " + next.msisdns, "GetAllBuddySyncTask");
                    C3250y.m11456e("Group : " + next.group, "GetAllBuddySyncTask");
                    C3250y.m11456e("SEmail : " + next.samsungemail, "GetAllBuddySyncTask");
                    C3250y.m11456e("SAInfo : " + next.sainfo, "GetAllBuddySyncTask");
                    C3250y.m11456e("DeviceType : " + next.devicetype, "GetAllBuddySyncTask");
                }
                if (!next.value.startsWith("0999")) {
                    arrayList.add(C1360d.m6019a(next));
                    arrayList.add(C1381y.m6205a(next.value, 0));
                    C1362f.m6064a(arrayList, next);
                    arrayList.add(C1206cg.m5544a(next.value));
                }
                if (next.getImagestatus() != Buddy.BuddyImageStatus.NOT_CHANGE) {
                    C3205bt.m11182a(GlobalApplication.m11493l()).m11227b(next.value);
                    C3231f.m11361a(GlobalApplication.m11493l()).m11386b(next.value);
                }
                if (next.value != null && !next.value.startsWith("0999")) {
                    arrayList2.add(next.value);
                }
            }
            GlobalApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            if (C3250y.f11735c) {
                C3250y.m11453c("the number of buddy from Server : " + getBuddyList.buddy.size() + " written in db.", "GetAllBuddySyncTask");
            }
            BuddyFragment.f1732k = C1360d.m6051e(GlobalApplication.m11493l().getContentResolver());
            C0423i.m3037a(GlobalApplication.m11493l(), getBuddyList.buddy);
            C1360d.m6031a(C1360d.m6026a(), (ArrayList<String>) arrayList2);
        }
    }
}
