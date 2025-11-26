package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p017e.C0691f;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bm */
/* loaded from: classes.dex */
public class C0301bm implements InterfaceC0667k {

    /* renamed from: a */
    public int f1411a = 31;

    /* renamed from: b */
    C0666j f1412b;

    /* renamed from: c */
    final /* synthetic */ BuddyFragment f1413c;

    public C0301bm(BuddyFragment buddyFragment) {
        this.f1413c = buddyFragment;
        this.f1412b = null;
        this.f1412b = new C0666j(buddyFragment.getActivity().getContentResolver(), this);
    }

    /* renamed from: a */
    public void m2382a(String str) {
        C1786r.m6067f("DbRequest2.getGroupInfo() : " + str, BuddyFragment.f908a);
        this.f1412b.startQuery(this.f1411a, "GETGROUPINFO", C0691f.m3136b(), null, "_id = ? ", new String[]{str}, "buddy_name COLLATE LOCALIZED ASC");
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) throws NumberFormatException {
        C1786r.m6067f("*************** DbRequest2.onQueryComplete() : " + i, BuddyFragment.f908a);
        if (obj != null) {
            C1786r.m6067f("*************** cookie : " + String.valueOf(obj), BuddyFragment.f908a);
        }
        if (i == this.f1411a) {
            this.f1413c.m2004j(cursor);
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
