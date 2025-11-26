package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2187am;
import com.sec.chaton.p065io.entry.GetHideBuddyList;
import com.sec.chaton.p065io.entry.inner.HideBuddy;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetHideListTask.java */
/* renamed from: com.sec.chaton.d.a.bw */
/* loaded from: classes.dex */
public class C1950bw extends AbstractC1900a {
    public C1950bw(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
            arrayList.add(C2187am.m9781b());
            Iterator<HideBuddy> it = ((GetHideBuddyList) c0778b.m3110e()).buddy.iterator();
            while (it.hasNext()) {
                HideBuddy next = it.next();
                arrayList.add(C2187am.m9782b(next.value, next.name));
            }
        } else if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
            arrayList.add(C2187am.m9781b());
        }
        try {
            if (arrayList.size() != 0) {
                try {
                    try {
                        GlobalApplication.m10279a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                } catch (OperationApplicationException e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            arrayList.clear();
        }
    }
}
