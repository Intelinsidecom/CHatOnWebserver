package com.sec.chaton.buddy.dialog;

import android.database.Cursor;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2246g;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.widget.C5179v;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.g */
/* loaded from: classes.dex */
class C1229g implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f4729a;

    C1229g(BuddyDialog buddyDialog) {
        this.f4729a = buddyDialog;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        if (!z) {
            this.f4729a.m7136A();
            return;
        }
        if (i == 1) {
            if (obj instanceof Cursor) {
                Cursor cursor = (Cursor) obj;
                if (cursor.getCount() > 0) {
                    cursor.close();
                    C2212z.m10068a(C2212z.m10066a(), 2, new C2246g(this.f4729a.f4517l, this.f4729a.f4524s, 2, true));
                    return;
                } else {
                    C2212z.m10068a(C2212z.m10066a(), 2, new C2246g(this.f4729a.f4517l, this.f4729a.f4524s, 2, false));
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            this.f4729a.m7136A();
            C5179v.m19811a(this.f4729a.getApplicationContext(), this.f4729a.getApplicationContext().getResources().getString(R.string.buddy_profile_block_toast_success, this.f4729a.f4510e), 0).show();
            this.f4729a.setResult(-1);
            this.f4729a.finish();
        }
    }
}
