package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1412r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f5046a;

    /* renamed from: b */
    final /* synthetic */ HandlerC1409o f5047b;

    DialogInterfaceOnClickListenerC1412r(HandlerC1409o handlerC1409o, boolean z) {
        this.f5047b = handlerC1409o;
        this.f5046a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f5047b.f5043a.f3528V, R.string.popup_no_network_connection, 0).show();
        } else {
            this.f5047b.f5043a.m6243a(this.f5046a);
        }
    }
}
