package com.sec.chaton.buddy;

import android.content.Intent;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.bv */
/* loaded from: classes.dex */
class C0310bv implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0307bs f1429a;

    C0310bv(AlertDialogC0307bs alertDialogC0307bs) {
        this.f1429a = alertDialogC0307bs;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (z && i == 3) {
            if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                if (this.f1429a.f1425h == null) {
                    this.f1429a.f1425h = Toast.makeText(this.f1429a.f1424g, this.f1429a.f1421d.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0);
                }
                this.f1429a.f1425h.show();
                return;
            }
            if (this.f1429a.f1422e == 101) {
                this.f1429a.f1419a.m2046d(this.f1429a.f1423f.getText().toString());
                return;
            }
            Intent intent = new Intent(this.f1429a.f1424g, (Class<?>) BuddySelectActivity.class);
            intent.putExtra("ACTIVITY_PURPOSE", 10);
            intent.putExtra("BUDDY_SORT_STYLE", 11);
            intent.putExtra("ACTIVITY_PURPOSE_ARG2", this.f1429a.f1423f.getText().toString());
            this.f1429a.f1421d.startActivity(intent);
        }
    }
}
