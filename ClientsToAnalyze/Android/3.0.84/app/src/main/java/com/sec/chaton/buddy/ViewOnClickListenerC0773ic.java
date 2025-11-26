package com.sec.chaton.buddy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ic */
/* loaded from: classes.dex */
class ViewOnClickListenerC0773ic implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3044a;

    ViewOnClickListenerC0773ic(SpecialBuddyFragment specialBuddyFragment) {
        this.f3044a = specialBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.f3044a.startActivityForResult(new Intent("android.intent.action.CALL", Uri.parse("tel:" + ((Object) this.f3044a.f2278O.getText()))), 0);
        } catch (ActivityNotFoundException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
    }
}
