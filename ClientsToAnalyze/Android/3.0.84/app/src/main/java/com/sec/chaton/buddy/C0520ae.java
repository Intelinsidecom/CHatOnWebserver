package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3159aa;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ae */
/* loaded from: classes.dex */
public class C0520ae implements InterfaceC1378v {

    /* renamed from: a */
    public int f2422a = 1;

    /* renamed from: b */
    public int f2423b = 2;

    /* renamed from: c */
    public int f2424c = 3;

    /* renamed from: d */
    C1377u f2425d;

    /* renamed from: e */
    final /* synthetic */ AddBuddyFragment f2426e;

    public C0520ae(AddBuddyFragment addBuddyFragment) {
        this.f2426e = addBuddyFragment;
        this.f2425d = null;
        this.f2425d = new C1377u(addBuddyFragment.f1676X.getContentResolver(), this);
    }

    /* renamed from: a */
    public void m4014a() {
        this.f2425d.startQuery(this.f2422a, null, C1388af.m6243a(), null, null, new String[]{String.valueOf(C3159aa.m10962a().m10976a("recommend_timestamp", 0L))}, null);
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == this.f2422a) {
            boolean zBooleanValue = C3159aa.m10962a().m10977a("recomned_receive", (Boolean) true).booleanValue();
            int unused = AddBuddyFragment.f1652f = 0;
            if (cursor != null) {
                try {
                    cursor.moveToFirst();
                    int unused2 = AddBuddyFragment.f1652f = cursor.getInt(cursor.getColumnIndex("count"));
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (zBooleanValue) {
                this.f2426e.m3198a(AddBuddyFragment.f1652f);
            } else {
                this.f2426e.m3198a(0);
            }
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
