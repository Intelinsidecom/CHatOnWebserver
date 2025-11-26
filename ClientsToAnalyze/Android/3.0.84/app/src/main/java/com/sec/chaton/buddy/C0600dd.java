package com.sec.chaton.buddy;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.InterfaceC3200bo;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dd */
/* loaded from: classes.dex */
class C0600dd implements InterfaceC3200bo {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0599dc f2592a;

    C0600dd(AlertDialogC0599dc alertDialogC0599dc) {
        this.f2592a = alertDialogC0599dc;
    }

    @Override // com.sec.chaton.util.InterfaceC3200bo
    /* renamed from: a */
    public void mo4085a(int i) {
        Toast.makeText(this.f2592a.f2588k, R.string.toast_text_max_Length, 0).show();
    }
}
