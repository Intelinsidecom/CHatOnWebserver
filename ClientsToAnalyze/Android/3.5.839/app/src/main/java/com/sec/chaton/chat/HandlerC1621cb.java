package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2214ab;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cb */
/* loaded from: classes.dex */
class HandlerC1621cb extends Handler {

    /* renamed from: a */
    final /* synthetic */ EnumC2214ab f6146a;

    /* renamed from: b */
    final /* synthetic */ View f6147b;

    /* renamed from: c */
    final /* synthetic */ ChatFragment f6148c;

    HandlerC1621cb(ChatFragment chatFragment, EnumC2214ab enumC2214ab, View view) {
        this.f6148c = chatFragment;
        this.f6146a = enumC2214ab;
        this.f6147b = view;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if ((this.f6146a == EnumC2214ab.IMAGE || this.f6146a == EnumC2214ab.VIDEO) && this.f6147b != null && message != null) {
            ((ProgressBar) this.f6147b.findViewById(R.id.progressbarDown)).setProgress(message.arg1);
        }
    }
}
