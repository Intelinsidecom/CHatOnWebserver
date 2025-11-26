package com.sec.chaton.buddy.dialog;

import android.database.Cursor;
import com.sec.chaton.R;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1416g;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.widget.C3641ai;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.f */
/* loaded from: classes.dex */
class C0624f implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f2844a;

    C0624f(BuddyDialog buddyDialog) {
        this.f2844a = buddyDialog;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (!z) {
            this.f2844a.m4186v();
            return;
        }
        if (i == 1) {
            if (obj instanceof Cursor) {
                Cursor cursor = (Cursor) obj;
                if (cursor.getCount() > 0) {
                    cursor.close();
                    C1379w.m6203a(new C1379w(), 2, new C1416g(this.f2844a.f2672j, this.f2844a.f2679q, 2, true));
                    return;
                } else {
                    C1379w.m6203a(new C1379w(), 2, new C1416g(this.f2844a.f2672j, this.f2844a.f2679q, 2, false));
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            this.f2844a.m4186v();
            C3641ai.m13211a(this.f2844a.getApplicationContext(), this.f2844a.getApplicationContext().getResources().getString(R.string.buddy_profile_block_toast_success, this.f2844a.f2667e), 0).show();
            this.f2844a.setResult(-1);
            this.f2844a.finish();
        }
    }
}
