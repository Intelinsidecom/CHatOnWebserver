package com.sec.chaton.chat;

import android.widget.CompoundButton;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.ey */
/* loaded from: classes.dex */
class C1698ey implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f6300a;

    C1698ey(ChatInfoFragment chatInfoFragment) {
        this.f6300a = chatInfoFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C2198l.m9913a(CommonApplication.m18732r().getContentResolver(), this.f6300a.f5799j, z);
        C4904y.m18641c("InboxNO : " + this.f6300a.f5799j + " Enable Noti : " + z, getClass().getSimpleName());
    }
}
