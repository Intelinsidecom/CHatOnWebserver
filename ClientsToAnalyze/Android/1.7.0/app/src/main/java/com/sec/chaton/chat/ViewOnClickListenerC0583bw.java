package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.p025d.EnumC0651d;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.bw */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0583bw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0603t f2004a;

    /* renamed from: b */
    private long f2005b;

    /* renamed from: c */
    private EnumC0651d f2006c;

    public ViewOnClickListenerC0583bw(ViewOnClickListenerC0603t viewOnClickListenerC0603t, long j, EnumC0651d enumC0651d) {
        this.f2004a = viewOnClickListenerC0603t;
        this.f2005b = j;
        this.f2006c = enumC0651d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2004a.f2085y.mo2690a(view, this.f2005b, this.f2006c);
    }
}
