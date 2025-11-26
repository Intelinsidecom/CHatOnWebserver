package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1789u;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.q */
/* loaded from: classes.dex */
public class C0441q implements InterfaceC0667k {

    /* renamed from: a */
    public int f1657a = 1;

    /* renamed from: b */
    public int f1658b = 2;

    /* renamed from: c */
    public int f1659c = 3;

    /* renamed from: d */
    C0666j f1660d;

    /* renamed from: e */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1661e;

    public C0441q(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1661e = addBuddyFragment;
        this.f1660d = null;
        this.f1660d = new C0666j(addBuddyFragment.getActivity().getContentResolver(), this);
    }

    /* renamed from: a */
    public void m2440a() {
        this.f1660d.startQuery(this.f1657a, null, C0702q.f2645a, new String[]{"buddy_no"}, "type='200'", null, null);
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == this.f1657a) {
            boolean z = C1789u.m6075a().getBoolean("recomned_receive", true);
            int unused = AddBuddyActivity.AddBuddyFragment.f844M = 0;
            if (cursor != null) {
                int unused2 = AddBuddyActivity.AddBuddyFragment.f844M = cursor.getCount();
                cursor.close();
            }
            if (z) {
                this.f1661e.m1891a(AddBuddyActivity.AddBuddyFragment.f844M);
            } else if (z) {
                this.f1661e.m1891a(AddBuddyActivity.AddBuddyFragment.f844M);
            } else {
                this.f1661e.m1891a(0);
            }
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
