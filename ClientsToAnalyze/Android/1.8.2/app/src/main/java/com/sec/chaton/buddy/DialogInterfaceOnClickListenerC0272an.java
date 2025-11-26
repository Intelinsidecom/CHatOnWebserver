package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0272an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0271am f1367a;

    DialogInterfaceOnClickListenerC0272an(HandlerC0271am handlerC0271am) {
        this.f1367a = handlerC0271am;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1367a.f1366a.f989az = ProgressDialogC1806j.m6141a(this.f1367a.f1366a.f1018t, null, this.f1367a.f1366a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        new C0633e(this.f1367a.f1366a.f1004f).m2868b(this.f1367a.f1366a.f978ao.m2324b());
    }
}
