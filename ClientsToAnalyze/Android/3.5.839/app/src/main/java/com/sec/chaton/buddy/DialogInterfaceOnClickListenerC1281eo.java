package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.eo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1281eo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1280en f4814a;

    DialogInterfaceOnClickListenerC1281eo(HandlerC1280en handlerC1280en) {
        this.f4814a = handlerC1280en;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4814a.f4813a.f3801P, R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C2128i(this.f4814a.f4813a.f3803R).m9489a("group", false, this.f4814a.f4813a.f3820q.getText().toString().trim(), (String) null, this.f4814a.f4813a.m6633d().m6606i(), 327);
        C2134o.m9568a((Handler) null, this.f4814a.f4813a.f3820q.getText().toString().trim());
        if (this.f4814a.f4813a.f3796K != null && !this.f4814a.f4813a.f3796K.isShowing()) {
            this.f4814a.f4813a.f3796K.show();
        }
    }
}
