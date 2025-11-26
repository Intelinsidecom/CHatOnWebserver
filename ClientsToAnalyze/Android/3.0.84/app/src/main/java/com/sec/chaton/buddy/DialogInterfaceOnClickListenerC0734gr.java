package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.gr */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0734gr implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0731go f2988a;

    DialogInterfaceOnClickListenerC0734gr(HandlerC0731go handlerC0731go) {
        this.f2988a = handlerC0731go;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 != iM6733a && -2 != iM6733a) {
            this.f2988a.f2985a.m3814a(this.f2988a.f2985a.f2224j, this.f2988a.f2985a.f2225k);
        } else {
            C3641ai.m13210a(this.f2988a.f2985a.getActivity(), R.string.popup_no_network_connection, 0).show();
        }
    }
}
