package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4809aa;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ac */
/* loaded from: classes.dex */
public class C1112ac implements InterfaceC2211y {

    /* renamed from: a */
    public int f4278a = 1;

    /* renamed from: b */
    public int f4279b = 2;

    /* renamed from: c */
    public int f4280c = 3;

    /* renamed from: d */
    C2210x f4281d;

    /* renamed from: e */
    final /* synthetic */ AddBuddyFragment f4282e;

    public C1112ac(AddBuddyFragment addBuddyFragment) {
        this.f4282e = addBuddyFragment;
        this.f4281d = null;
        this.f4281d = new C2210x(addBuddyFragment.f3528V.getContentResolver(), this);
    }

    /* renamed from: a */
    public void m7098a() {
        this.f4281d.startQuery(this.f4278a, null, C2228ap.m10094a(), null, null, new String[]{String.valueOf(C4809aa.m18104a().m18118a("recommend_timestamp", 0L))}, null);
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (i == this.f4278a) {
            boolean zBooleanValue = C4809aa.m18104a().m18119a("recomned_receive", (Boolean) true).booleanValue();
            int unused = AddBuddyFragment.f3506e = 0;
            if (cursor != null) {
                try {
                    cursor.moveToFirst();
                    int unused2 = AddBuddyFragment.f3506e = cursor.getInt(cursor.getColumnIndex(VKApiConst.COUNT));
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (zBooleanValue) {
                this.f4282e.m6268a(AddBuddyFragment.f3506e);
            } else {
                this.f4282e.m6268a(0);
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
