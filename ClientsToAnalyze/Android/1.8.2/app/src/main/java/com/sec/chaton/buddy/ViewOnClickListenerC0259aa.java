package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyChatInfoActivity.java */
/* renamed from: com.sec.chaton.buddy.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC0259aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyChatInfoActivity f1354a;

    ViewOnClickListenerC0259aa(BuddyChatInfoActivity buddyChatInfoActivity) {
        this.f1354a = buddyChatInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0660d.m3008a(GlobalApplication.m3260b().getContentResolver(), this.f1354a.f901n, this.f1354a.f900m.isChecked());
        C1786r.m6063c("InboxNO : " + this.f1354a.f901n + " Enable Noti : " + this.f1354a.f900m.isChecked(), getClass().getSimpleName());
    }
}
