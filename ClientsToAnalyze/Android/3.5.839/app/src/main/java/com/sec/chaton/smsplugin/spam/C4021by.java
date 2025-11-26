package com.sec.chaton.smsplugin.spam;

import android.app.Activity;
import android.widget.CompoundButton;

/* compiled from: SpamMessageListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.spam.by */
/* loaded from: classes.dex */
class C4021by implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ C4018bv f14501a;

    C4021by(C4018bv c4018bv) {
        this.f14501a = c4018bv;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (((Activity) this.f14501a.mContext) instanceof ManageSpamMessages) {
            ((ManageSpamMessages) this.f14501a.mContext).onCheckedChanged(compoundButton, z);
        }
    }
}
