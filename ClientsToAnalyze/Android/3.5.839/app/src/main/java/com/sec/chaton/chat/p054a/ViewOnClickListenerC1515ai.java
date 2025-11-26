package com.sec.chaton.chat.p054a;

import android.view.View;
import com.sec.chaton.chat.translate.C1856i;
import com.sec.chaton.util.C4904y;

/* compiled from: MessageBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ai */
/* loaded from: classes.dex */
class ViewOnClickListenerC1515ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AbstractViewOnClickListenerC1514ah f5906a;

    ViewOnClickListenerC1515ai(AbstractViewOnClickListenerC1514ah abstractViewOnClickListenerC1514ah) {
        this.f5906a = abstractViewOnClickListenerC1514ah;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C4904y.f17873c) {
            C4904y.m18641c("TTS click - addMessageForPlayback()", AbstractViewOnClickListenerC1514ah.class.getSimpleName());
        }
        C1856i.m9047a(this.f5906a.f5868o, this.f5906a.f5870q, this.f5906a.f5872s);
    }
}
