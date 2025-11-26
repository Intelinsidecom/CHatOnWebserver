package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4847bl;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC1838o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6960a;

    ViewOnClickListenerC1838o(ChatFragment chatFragment) {
        this.f6960a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.voice_info_message, 0).show();
        }
    }
}
