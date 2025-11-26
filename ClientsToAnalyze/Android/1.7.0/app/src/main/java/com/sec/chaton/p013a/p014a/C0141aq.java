package com.sec.chaton.p013a.p014a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.C0658k;
import com.sec.chaton.p025d.p026a.C0625e;
import com.sec.chaton.p033io.entry.GetInteractionList;
import com.sec.chaton.p033io.entry.inner.InteractionEntry;
import com.sec.chaton.p033io.entry.inner.InteractionListEntry;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetInteractionTask.java */
/* renamed from: com.sec.chaton.a.a.aq */
/* loaded from: classes.dex */
public class C0141aq extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private ContentResolver f345a;

    public C0141aq(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
        this.f345a = GlobalApplication.m3100a().getContentResolver();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1341p.m4662e("beforeRequest", "GetInteractionListTask");
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) throws RemoteException, OperationApplicationException {
        ArrayList arrayList;
        C1341p.m4662e("afterRequest", "GetInteractionListTask");
        if (c0259g.m927a() && c0259g.m932d() != null && c0259g.m928b() != EnumC0518y.ERROR && (arrayList = ((GetInteractionList) c0259g.m932d()).interaction) != null && arrayList.size() > 0) {
            C1341p.m4662e("InteractionList size=" + arrayList.size(), "GetInteractionListTask");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                InteractionListEntry interactionListEntry = (InteractionListEntry) it.next();
                C1341p.m4662e("InteractionList:week: " + interactionListEntry.week + " totalcount: " + interactionListEntry.totalcount + " start: " + interactionListEntry.start + " end: " + interactionListEntry.end, "GetInteractionListTask");
            }
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            arrayList2.add(m683b());
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                InteractionListEntry interactionListEntry2 = (InteractionListEntry) it2.next();
                Iterator it3 = interactionListEntry2.buddyid.iterator();
                while (it3.hasNext()) {
                    InteractionEntry interactionEntry = (InteractionEntry) it3.next();
                    arrayList2.add(C0625e.m2854a(this.f345a, interactionEntry.value, interactionListEntry2.week, interactionEntry.total, interactionEntry.send, interactionEntry.receive, interactionEntry.rank));
                }
            }
            GlobalApplication.m3100a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
        }
    }

    /* renamed from: b */
    private static ContentProviderOperation m683b() {
        return ContentProviderOperation.newDelete(C0658k.f2285a).build();
    }
}
