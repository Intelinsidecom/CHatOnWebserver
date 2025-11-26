package com.sec.chaton.smsplugin.p112ui;

import android.widget.CompoundButton;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: MessagingInfoActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.co */
/* loaded from: classes.dex */
class C4160co implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ MessagingInfoActivity f15464a;

    C4160co(MessagingInfoActivity messagingInfoActivity) {
        this.f15464a = messagingInfoActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C2198l.m9913a(CommonApplication.m18732r().getContentResolver(), this.f15464a.f14883U, z);
        C4904y.m18641c("ThreadId : " + this.f15464a.f14883U + " Enable Noti : " + z, getClass().getSimpleName());
    }
}
