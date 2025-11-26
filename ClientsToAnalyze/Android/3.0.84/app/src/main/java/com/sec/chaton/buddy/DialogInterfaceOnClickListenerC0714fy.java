package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.fy */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0714fy implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0711fv f2955a;

    DialogInterfaceOnClickListenerC0714fy(HandlerC0711fv handlerC0711fv) {
        this.f2955a = handlerC0711fv;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2955a.f2952a.f2178J, R.string.popup_no_network_connection, 0).show();
        } else {
            this.f2955a.f2952a.m3778a(this.f2955a.f2952a.f2197j, this.f2955a.f2952a.f2198k);
        }
    }
}
