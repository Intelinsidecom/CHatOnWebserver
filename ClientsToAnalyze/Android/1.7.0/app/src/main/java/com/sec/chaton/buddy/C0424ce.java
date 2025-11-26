package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.widget.C1619g;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.ce */
/* loaded from: classes.dex */
class C0424ce implements InterfaceC0641d {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0426cg f1409a;

    C0424ce(AlertDialogC0426cg alertDialogC0426cg) {
        this.f1409a = alertDialogC0426cg;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0641d
    /* renamed from: a */
    public void mo2364a(int i, boolean z, Object obj) {
        if (z && i == 3) {
            if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                if (this.f1409a.f1418h == null) {
                    this.f1409a.f1418h = C1619g.m5889a(this.f1409a.f1417g, this.f1409a.f1414d.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0);
                }
                this.f1409a.f1418h.show();
                return;
            }
            if (this.f1409a.f1415e == 101) {
                this.f1409a.f1412a.m2194a(this.f1409a.f1416f.getText().toString());
                return;
            }
            Intent intent = new Intent(this.f1409a.f1417g, (Class<?>) BuddyActivity2.class);
            intent.putExtra("ACTIVITY_PURPOSE", 10);
            intent.putExtra("BUDDY_SORT_STYLE", 11);
            intent.putExtra("ACTIVITY_PURPOSE_ARG2", this.f1409a.f1416f.getText().toString());
            this.f1409a.f1414d.startActivity(intent);
        }
    }
}
