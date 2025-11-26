package com.sec.chaton.buddy;

import com.sec.chaton.R;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.widget.C3641ai;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dj */
/* loaded from: classes.dex */
class C0645dj implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0599dc f2865a;

    C0645dj(AlertDialogC0599dc alertDialogC0599dc) {
        this.f2865a = alertDialogC0599dc;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (this.f2865a.f2581d != null && z) {
            this.f2865a.f2584g.m3435b(this.f2865a.f2583f);
            this.f2865a.m4076e();
            C3641ai.m13211a(this.f2865a.f2581d, this.f2865a.f2581d.getResources().getString(R.string.buddy_new_group_created), 0).show();
        }
    }
}
