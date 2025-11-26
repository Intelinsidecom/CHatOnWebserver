package com.sec.chaton.buddy;

import android.database.Cursor;
import com.sec.chaton.R;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0643f;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.widget.C1619g;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.bg */
/* loaded from: classes.dex */
class C0399bg implements InterfaceC0641d {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1373a;

    C0399bg(BuddyProfileActivity buddyProfileActivity) {
        this.f1373a = buddyProfileActivity;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0641d
    /* renamed from: a */
    public void mo2364a(int i, boolean z, Object obj) {
        if (!z) {
            this.f1373a.m2272g();
            return;
        }
        if (i == 1) {
            if (obj instanceof Cursor) {
                Cursor cursor = (Cursor) obj;
                if (cursor.getCount() > 0) {
                    cursor.close();
                    C0627g.m2858a(new C0627g(), 2, new C0643f(this.f1373a.f1235e, this.f1373a.f1241l, 2, true));
                    return;
                } else {
                    C0627g.m2858a(new C0627g(), 2, new C0643f(this.f1373a.f1235e, this.f1373a.f1241l, 2, false));
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            this.f1373a.m2272g();
            C1619g.m5889a(this.f1373a.f1240k, this.f1373a.getResources().getString(R.string.buddy_profile_block_toast_success, this.f1373a.f1241l.m2314b()), 0).show();
            this.f1373a.setResult(-1);
            this.f1373a.finish();
        }
    }
}
