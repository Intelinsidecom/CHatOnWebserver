package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.av */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1131av implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1130au f4349a;

    DialogInterfaceOnClickListenerC1131av(HandlerC1130au handlerC1130au) {
        this.f4349a = handlerC1130au;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 != iM10677a && -2 != iM10677a) {
            this.f4349a.f4348a.f3558a.m9488a("update", false, this.f4349a.f4348a.f3562e.getText().toString().trim(), "+" + this.f4349a.f4348a.f3565h);
            if (!this.f4349a.f4348a.f3571n.isFinishing()) {
                this.f4349a.f4348a.f3568k.show();
                return;
            }
            return;
        }
        C5179v.m19810a(this.f4349a.f4348a.f3559b, R.string.popup_no_network_connection, 0).show();
    }
}
