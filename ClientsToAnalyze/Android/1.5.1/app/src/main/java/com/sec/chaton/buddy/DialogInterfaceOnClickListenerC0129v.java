package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.ContactControl;

/* renamed from: com.sec.chaton.buddy.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0129v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0113f f715a;

    DialogInterfaceOnClickListenerC0129v(HandlerC0113f handlerC0113f) {
        this.f715a = handlerC0113f;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f715a.f657a.f435Z = ProgressDialog.show(this.f715a.f657a.f453i, null, this.f715a.f657a.getResources().getString(C0062R.string.buddy_list_progress_dialog_message), true);
        new ContactControl(this.f715a.f657a.f448d).m1996b(this.f715a.f657a.f428S.m673b());
    }
}
