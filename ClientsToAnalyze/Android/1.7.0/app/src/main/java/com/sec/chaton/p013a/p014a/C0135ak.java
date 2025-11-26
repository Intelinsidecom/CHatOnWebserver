package com.sec.chaton.p013a.p014a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.p026a.C0625e;
import com.sec.chaton.p033io.entry.GetInteractionHideList;
import com.sec.chaton.p033io.entry.inner.InteractionHideEntry;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetInteractionHideListTask.java */
/* renamed from: com.sec.chaton.a.a.ak */
/* loaded from: classes.dex */
public class C0135ak extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private ArrayList f321a;

    public C0135ak(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1341p.m4662e("beforeRequest", "GetInteractionHideListTask");
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws RemoteException, OperationApplicationException {
        C1341p.m4662e("afterRequest", "GetInteractionHideListTask");
        if (c0259g.m927a() && c0259g.m932d() != null && c0259g.m928b() != EnumC0518y.ERROR) {
            m680a(((GetInteractionHideList) c0259g.m932d()).buddyid);
        }
        GetInteractionHideList getInteractionHideList = (GetInteractionHideList) c0259g.m932d();
        ArrayList arrayList = getInteractionHideList.buddyid;
        if (arrayList != null && arrayList.size() > 0) {
            InteractionHideEntry interactionHideEntry = (InteractionHideEntry) arrayList.get(0);
            if (interactionHideEntry == null) {
                C1341p.m4662e("entry is null", "GetInteractionHideListTask");
                return;
            }
            C1341p.m4662e("GetInteractionHideList:totalcount: " + getInteractionHideList.totalcount + " buddyid: " + interactionHideEntry, "GetInteractionHideListTask");
        }
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        arrayList2.add(C0625e.m2856a(GlobalApplication.m3100a().getContentResolver(), false));
        C1341p.m4662e("GetInteractionHideList Set buddyTable InitHideInformation", getClass().getSimpleName());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InteractionHideEntry interactionHideEntry2 = (InteractionHideEntry) it.next();
            arrayList2.add(C0625e.m2855a(GlobalApplication.m3100a().getContentResolver(), interactionHideEntry2.value, true));
            C1341p.m4662e("GetInteractionHideList Set buddyTable InteractionBlock :" + interactionHideEntry2.value, getClass().getSimpleName());
        }
        GlobalApplication.m3100a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
    }

    /* renamed from: a */
    public void m680a(ArrayList arrayList) {
        this.f321a = arrayList;
    }
}
