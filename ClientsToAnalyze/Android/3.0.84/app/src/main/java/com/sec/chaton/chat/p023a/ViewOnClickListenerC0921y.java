package com.sec.chaton.chat.p023a;

import android.view.View;
import com.sec.chaton.chat.p024b.C0958i;
import com.sec.chaton.util.C3250y;

/* compiled from: MessageBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.y */
/* loaded from: classes.dex */
class ViewOnClickListenerC0921y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractViewOnClickListenerC0920x f3858a;

    ViewOnClickListenerC0921y(AbstractViewOnClickListenerC0920x abstractViewOnClickListenerC0920x) {
        this.f3858a = abstractViewOnClickListenerC0920x;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C3250y.f11735c) {
            C3250y.m11453c("TTS click - addMessageForPlayback()", AbstractViewOnClickListenerC0920x.class.getSimpleName());
        }
        C0958i.m5165a(this.f3858a.f3801o, this.f3858a.f3803q, this.f3858a.f3805s);
    }
}
