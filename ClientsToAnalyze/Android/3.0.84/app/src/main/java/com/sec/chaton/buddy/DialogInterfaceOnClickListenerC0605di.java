package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p037j.C1594v;
import com.sec.widget.C3641ai;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.di */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0605di implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2597a;

    /* renamed from: b */
    final /* synthetic */ HandlerC0604dh f2598b;

    DialogInterfaceOnClickListenerC0605di(HandlerC0604dh handlerC0604dh, String str) {
        this.f2598b = handlerC0604dh;
        this.f2597a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(GlobalApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2598b.f2596a.f2581d, R.string.popup_no_network_connection, 0).show();
        } else {
            new C1330h(this.f2598b.f2596a.f2590m).m5716a("group", false, (String) null, this.f2597a, this.f2598b.f2596a.f2583f, 325);
            this.f2598b.f2596a.m4074d();
        }
    }
}
