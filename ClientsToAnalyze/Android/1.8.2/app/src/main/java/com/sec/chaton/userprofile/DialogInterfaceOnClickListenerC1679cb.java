package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.p007a.p008a.C0107h;
import com.sec.chaton.util.C1789u;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.cb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1679cb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1676bz f6176a;

    DialogInterfaceOnClickListenerC1679cb(HandlerC1676bz handlerC1676bz) {
        this.f6176a = handlerC1676bz;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0107h c0107h = new C0107h();
        c0107h.m683a(this.f6176a.f6173a.f6019B.getText().toString());
        c0107h.m685b(this.f6176a.f6173a.f6020C.getText().toString());
        this.f6176a.f6173a.f6079z.m2963a(c0107h, C1789u.m6075a().getString("birthday_type", ""));
        if (!this.f6176a.f6173a.isFinishing()) {
            this.f6176a.f6173a.f6022E.show();
        }
        this.f6176a.f6173a.f6071r = false;
    }
}
