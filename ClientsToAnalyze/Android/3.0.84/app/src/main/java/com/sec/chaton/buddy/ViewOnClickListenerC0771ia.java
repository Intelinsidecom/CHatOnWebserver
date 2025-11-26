package com.sec.chaton.buddy;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.sec.chaton.buddy.p019a.C0514d;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ia */
/* loaded from: classes.dex */
class ViewOnClickListenerC0771ia implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0514d f3041a;

    /* renamed from: b */
    final /* synthetic */ SpecialBuddyFragment f3042b;

    ViewOnClickListenerC0771ia(SpecialBuddyFragment specialBuddyFragment, C0514d c0514d) {
        this.f3042b = specialBuddyFragment;
        this.f3041a = c0514d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String strReplace = this.f3041a.m4008i().replace(" ", "");
        if (!strReplace.startsWith("https://") && !strReplace.startsWith("http://")) {
            strReplace = "http://" + strReplace;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(strReplace));
        this.f3042b.startActivity(intent);
    }
}
