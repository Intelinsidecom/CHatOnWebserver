package com.sec.chaton.buddy;

import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.ee */
/* loaded from: classes.dex */
class C1271ee implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1262dw f4805a;

    C1271ee(AlertDialogC1262dw alertDialogC1262dw) {
        this.f4805a = alertDialogC1262dw;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) throws Resources.NotFoundException {
        if (this.f4805a.f4785d != null && z) {
            this.f4805a.f4788g.m6596b(this.f4805a.f4787f);
            this.f4805a.m7426e();
            C5179v.m19811a(this.f4805a.f4785d, this.f4805a.f4785d.getResources().getString(R.string.buddy_new_group_created), 0).show();
        }
    }
}
