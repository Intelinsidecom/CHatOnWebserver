package com.sec.chaton.smsplugin.p112ui;

import android.view.View;
import com.sec.chaton.chat.C1736gi;

/* compiled from: MessagingInfoAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cu */
/* loaded from: classes.dex */
class ViewOnClickListenerC4166cu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f15472a;

    /* renamed from: b */
    final /* synthetic */ String f15473b;

    /* renamed from: c */
    final /* synthetic */ C4164cs f15474c;

    ViewOnClickListenerC4166cu(C4164cs c4164cs, String str, String str2) {
        this.f15474c = c4164cs;
        this.f15472a = str;
        this.f15473b = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1736gi.m8651c(this.f15472a) == -1) {
            ((MessagingInfoActivity) this.f15474c.f15470o).m15853b(this.f15472a);
        } else {
            this.f15474c.m16452b(this.f15473b);
        }
    }
}
