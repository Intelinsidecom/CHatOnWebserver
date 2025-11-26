package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityWebView;

/* compiled from: FragmentDisclaimer.java */
/* renamed from: com.sec.chaton.registration.bv */
/* loaded from: classes.dex */
class ViewOnClickListenerC2171bv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimer f8456a;

    ViewOnClickListenerC2171bv(FragmentDisclaimer fragmentDisclaimer) {
        this.f8456a = fragmentDisclaimer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f8456a.f8210e, (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "TERMS_AND_CONDITION");
        intent.putExtra("FROM_ABOUT_CHATON", true);
        this.f8456a.startActivity(intent);
    }
}
