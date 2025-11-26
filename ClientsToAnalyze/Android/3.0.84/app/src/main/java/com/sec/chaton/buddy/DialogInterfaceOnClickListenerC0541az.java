package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.az */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0541az implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0540ay f2500a;

    DialogInterfaceOnClickListenerC0541az(HandlerC0540ay handlerC0540ay) {
        this.f2500a = handlerC0540ay;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 != iM6733a && -2 != iM6733a) {
            this.f2500a.f2499a.f1708a.m5715a("update", false, this.f2500a.f2499a.f1712e.getText().toString().trim(), "+" + this.f2500a.f2499a.f1714g);
            if (!this.f2500a.f2499a.f1720m.isFinishing()) {
                this.f2500a.f2499a.f1717j.show();
                return;
            }
            return;
        }
        C3641ai.m13210a(this.f2500a.f2499a.f1709b, R.string.popup_no_network_connection, 0).show();
    }
}
