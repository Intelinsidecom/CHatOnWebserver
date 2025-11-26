package com.sec.chaton.msgbox;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.EnumC3297gd;
import com.sec.chaton.registration.RegisterSMSActivity;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC2634az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9483a;

    ViewOnClickListenerC2634az(MsgboxFragment msgboxFragment) {
        this.f9483a = msgboxFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f9483a.getActivity(), (Class<?>) RegisterSMSActivity.class);
        intent.putExtra("request_register", EnumC3297gd.reigster);
        intent.putExtra(RegisterSMSActivity.f11832n, true);
        this.f9483a.startActivity(intent);
    }
}
