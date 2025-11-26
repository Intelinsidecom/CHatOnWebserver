package com.sec.chaton.chat.p054a;

import android.view.View;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: SystemBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.am */
/* loaded from: classes.dex */
class ViewOnClickListenerC1519am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f5908a;

    /* renamed from: b */
    final /* synthetic */ String[] f5909b;

    /* renamed from: c */
    final /* synthetic */ C1517ak f5910c;

    ViewOnClickListenerC1519am(C1517ak c1517ak, String str, String[] strArr) {
        this.f5910c = c1517ak;
        this.f5908a = str;
        this.f5909b = strArr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f5910c.f5856c);
        abstractC4932aM18733a.mo18734a(R.string.chat_view_menu_invite);
        abstractC4932aM18733a.mo18749b(this.f5908a).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1521ao(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1520an(this));
        abstractC4932aM18733a.mo18752b();
    }
}
