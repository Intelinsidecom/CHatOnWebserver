package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.dr */
/* loaded from: classes.dex */
class ViewOnClickListenerC1049dr implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f4160a;

    ViewOnClickListenerC1049dr(ChatInfoFragment chatInfoFragment) {
        this.f4160a = chatInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4160a.f3746n.setChecked(!this.f4160a.f3746n.isChecked());
        C1370n.m6109a(CommonApplication.m11493l().getContentResolver(), this.f4160a.f3742j, this.f4160a.f3746n.isChecked());
        C3250y.m11453c("InboxNO : " + this.f4160a.f3742j + " Enable Noti : " + this.f4160a.f3746n.isChecked(), getClass().getSimpleName());
    }
}
