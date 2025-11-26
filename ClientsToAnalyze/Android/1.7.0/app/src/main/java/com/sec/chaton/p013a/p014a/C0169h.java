package com.sec.chaton.p013a.p014a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.account.C0239h;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p025d.p026a.C0633m;
import com.sec.chaton.p033io.entry.GetBuddyList;
import com.sec.chaton.p033io.entry.inner.Address;
import com.sec.chaton.p033io.entry.inner.Buddy;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.util.C1349x;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AddBuddyTask.java */
/* renamed from: com.sec.chaton.a.a.h */
/* loaded from: classes.dex */
public class C0169h extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private String f399a;

    /* renamed from: b */
    private ContentResolver f400b;

    public C0169h(Handler handler, C0503j c0503j, String str) {
        super(handler, c0503j);
        this.f399a = str;
        this.f400b = GlobalApplication.m3100a().getContentResolver();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        ArrayList arrayList = new ArrayList();
        Address address = new Address();
        address.value = this.f399a;
        arrayList.add(address);
        String strM4714a = new C1349x().m4714a(arrayList);
        C1341p.m4662e("\n" + strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws RemoteException, OperationApplicationException {
        if (c0259g.m932d() != null) {
            Iterator it = ((GetBuddyList) c0259g.m932d()).buddy.iterator();
            while (it.hasNext()) {
                Buddy buddy = (Buddy) it.next();
                C1341p.m4658b("Buddy NO : " + buddy.value + ", Name : " + buddy.name + ", StatusMessage : " + buddy.status + ", orgnum : " + buddy.orgnum + ", showphonenumber : " + buddy.showphonenumber + ", einfo : " + buddy.einfo, getClass().getSimpleName());
                C1348w.m4685a(GlobalApplication.m3100a()).m4701a(buddy.value);
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                arrayList.add(C0633m.m2879a(buddy));
                arrayList.add(C0165d.m706a(buddy.value));
                this.f400b.applyBatch("com.sec.chaton.provider", arrayList);
            }
            C0239h.m907a(GlobalApplication.m3100a(), ((GetBuddyList) c0259g.m932d()).buddy);
            new C0202ao(null).m762a(true);
        }
    }
}
