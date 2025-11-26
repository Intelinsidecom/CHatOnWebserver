package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.util.C4904y;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ik */
/* loaded from: classes.dex */
class ViewOnClickListenerC1385ik implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f4989a;

    ViewOnClickListenerC1385ik(SpecialBuddyFragment specialBuddyFragment) {
        this.f4989a = specialBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.f4989a.startActivityForResult(new Intent("android.intent.action.CALL", Uri.parse("tel:" + C3789h.m14307c((String) this.f4989a.f4163v.getText()))), 0);
        } catch (ActivityNotFoundException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
    }
}
