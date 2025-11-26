package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.p017e.EnumC0699n;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.bc */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0489bc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0477as f2076a;

    /* renamed from: b */
    private long f2077b;

    /* renamed from: c */
    private EnumC0699n f2078c;

    public ViewOnClickListenerC0489bc(ViewOnClickListenerC0477as viewOnClickListenerC0477as, long j, EnumC0699n enumC0699n) {
        this.f2076a = viewOnClickListenerC0477as;
        this.f2077b = j;
        this.f2078c = enumC0699n;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2076a.f1968G.mo2591a(view, this.f2077b, this.f2078c);
    }
}
