package com.sec.chaton.buddy;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.InterfaceC4850bo;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dx */
/* loaded from: classes.dex */
class C1263dx implements InterfaceC4850bo {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1262dw f4796a;

    C1263dx(AlertDialogC1262dw alertDialogC1262dw) {
        this.f4796a = alertDialogC1262dw;
    }

    @Override // com.sec.chaton.util.InterfaceC4850bo
    /* renamed from: a */
    public void mo7436a(int i) {
        Toast.makeText(this.f4796a.f4792k, R.string.toast_text_max_Length, 0).show();
    }
}
