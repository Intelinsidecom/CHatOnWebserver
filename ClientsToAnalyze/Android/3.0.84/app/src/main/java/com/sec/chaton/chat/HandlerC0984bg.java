package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import com.sec.chaton.R;
import com.sec.chaton.p027e.EnumC1455w;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bg */
/* loaded from: classes.dex */
class HandlerC0984bg extends Handler {

    /* renamed from: a */
    final /* synthetic */ EnumC1455w f4052a;

    /* renamed from: b */
    final /* synthetic */ View f4053b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f4054c;

    HandlerC0984bg(ChatFragment chatFragment, EnumC1455w enumC1455w, View view) {
        this.f4054c = chatFragment;
        this.f4052a = enumC1455w;
        this.f4053b = view;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if ((this.f4052a == EnumC1455w.IMAGE || this.f4052a == EnumC1455w.VIDEO) && this.f4053b != null && message != null) {
            ((ProgressBar) this.f4053b.findViewById(R.id.progressbarDown)).setProgress(message.arg1);
        }
    }
}
