package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C3197bl;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC1095g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4358a;

    ViewOnClickListenerC1095g(ChatFragment chatFragment) {
        this.f4358a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.voice_info_message, 0).show();
        }
    }
}
