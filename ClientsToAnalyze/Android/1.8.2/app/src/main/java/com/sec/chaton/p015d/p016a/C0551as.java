package com.sec.chaton.p015d.p016a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.C0703r;
import com.sec.chaton.p017e.p018a.C0671o;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetInteractionList;
import com.sec.chaton.p028io.entry.inner.InteractionEntry;
import com.sec.chaton.p028io.entry.inner.InteractionListEntry;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetInteractionTask.java */
/* renamed from: com.sec.chaton.d.a.as */
/* loaded from: classes.dex */
public class C0551as extends AbstractRunnableC0532a {

    /* renamed from: d */
    private ContentResolver f2227d;

    public C0551as(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
        this.f2227d = GlobalApplication.m3260b().getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1786r.m6066e("beforeRequest", "GetInteractionListTask");
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) throws RemoteException, OperationApplicationException {
        ArrayList arrayList;
        C1786r.m6066e("afterRequest", "GetInteractionListTask");
        if (c0101b.m664a() && c0101b.m671d() != null && c0101b.m665b() != EnumC0803m.ERROR && (arrayList = ((GetInteractionList) c0101b.m671d()).interaction) != null && arrayList.size() > 0) {
            C1786r.m6066e("InteractionList size=" + arrayList.size(), "GetInteractionListTask");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                InteractionListEntry interactionListEntry = (InteractionListEntry) it.next();
                C1786r.m6066e("InteractionList:week: " + interactionListEntry.week + " totalcount: " + interactionListEntry.totalcount + " start: " + interactionListEntry.start + " end: " + interactionListEntry.end, "GetInteractionListTask");
            }
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            arrayList2.add(m2750f());
            GlobalApplication.m3260b().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
            ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                InteractionListEntry interactionListEntry2 = (InteractionListEntry) it2.next();
                Iterator it3 = interactionListEntry2.buddyid.iterator();
                while (it3.hasNext()) {
                    InteractionEntry interactionEntry = (InteractionEntry) it3.next();
                    arrayList3.add(C0671o.m3093a(this.f2227d, interactionEntry.value, interactionListEntry2.week, interactionEntry.total, interactionEntry.send, interactionEntry.receive, interactionEntry.rank));
                }
            }
            GlobalApplication.m3260b().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList3);
        }
    }

    /* renamed from: f */
    private static ContentProviderOperation m2750f() {
        return ContentProviderOperation.newDelete(C0703r.f2646a).build();
    }
}
