package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2471v;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.ed */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1270ed implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4803a;

    /* renamed from: b */
    final /* synthetic */ HandlerC1269ec f4804b;

    DialogInterfaceOnClickListenerC1270ed(HandlerC1269ec handlerC1269ec, String str) {
        this.f4804b = handlerC1269ec;
        this.f4803a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(GlobalApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4804b.f4802a.f4785d, R.string.popup_no_network_connection, 0).show();
        } else {
            new C2128i(this.f4804b.f4802a.f4794m).m9489a("group", false, (String) null, this.f4803a, this.f4804b.f4802a.f4787f, 325);
            this.f4804b.f4802a.m7424d();
        }
    }
}
