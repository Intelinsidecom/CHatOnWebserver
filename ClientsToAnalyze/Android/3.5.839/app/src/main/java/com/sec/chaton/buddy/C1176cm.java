package com.sec.chaton.buddy;

import android.database.Cursor;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2246g;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cm */
/* loaded from: classes.dex */
class C1176cm implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4403a;

    C1176cm(BuddyFragment buddyFragment) {
        this.f4403a = buddyFragment;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        if (!z) {
            this.f4403a.m6327W();
            return;
        }
        if (i == 1) {
            if (obj instanceof Cursor) {
                Cursor cursor = (Cursor) obj;
                if (cursor.getCount() > 0) {
                    cursor.close();
                    C2212z.m10068a(new C2212z(), 2, new C2246g(this.f4403a.f3770w, this.f4403a.f3671az, 2, true));
                    return;
                } else {
                    C2212z.m10068a(new C2212z(), 2, new C2246g(this.f4403a.f3770w, this.f4403a.f3671az, 2, false));
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            this.f4403a.m6327W();
            this.f4403a.f3621aB.m7403b();
        } else {
            if (i == 3) {
                this.f4403a.m6327W();
                this.f4403a.f3621aB.m7403b();
                return;
            }
            if (i != 3 || !(obj instanceof Integer) || ((Integer) obj).intValue() != 0 || this.f4403a.f3660ao == 10 || this.f4403a.f3660ao == 11) {
            }
        }
    }
}
