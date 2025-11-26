package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import com.sec.chaton.R;
import com.sec.chaton.p025d.EnumC0651d;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bx */
/* loaded from: classes.dex */
class HandlerC0584bx extends Handler {

    /* renamed from: a */
    final /* synthetic */ EnumC0651d f2007a;

    /* renamed from: b */
    final /* synthetic */ View f2008b;

    /* renamed from: c */
    final /* synthetic */ DialogInterfaceOnClickListenerC0579bs f2009c;

    HandlerC0584bx(DialogInterfaceOnClickListenerC0579bs dialogInterfaceOnClickListenerC0579bs, EnumC0651d enumC0651d, View view) {
        this.f2009c = dialogInterfaceOnClickListenerC0579bs;
        this.f2007a = enumC0651d;
        this.f2008b = view;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if ((this.f2007a == EnumC0651d.IMAGE || this.f2007a == EnumC0651d.VIDEO) && this.f2008b != null && message != null) {
            ((ProgressBar) this.f2008b.findViewById(R.id.progressbarDown)).setProgress(message.arg1);
        }
    }
}
