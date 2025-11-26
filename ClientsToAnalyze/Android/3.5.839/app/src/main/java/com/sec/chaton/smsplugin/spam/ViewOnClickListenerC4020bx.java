package com.sec.chaton.smsplugin.spam;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;

/* compiled from: SpamMessageListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bx */
/* loaded from: classes.dex */
class ViewOnClickListenerC4020bx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f14499a;

    /* renamed from: b */
    final /* synthetic */ C4018bv f14500b;

    ViewOnClickListenerC4020bx(C4018bv c4018bv, CheckBox checkBox) {
        this.f14500b = c4018bv;
        this.f14499a = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((((Activity) this.f14500b.mContext) instanceof ManageSpamMessages) && this.f14500b.f14496h == 0) {
            ((ManageSpamMessages) this.f14500b.mContext).m15315a(false, view);
        }
        if (this.f14500b.f14496h != 0) {
            this.f14499a.performClick();
        }
    }
}
