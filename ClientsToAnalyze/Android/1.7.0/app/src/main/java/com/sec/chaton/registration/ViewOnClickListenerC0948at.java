package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivitySelectLanguage;

/* compiled from: ActivitySelectLanguage.java */
/* renamed from: com.sec.chaton.registration.at */
/* loaded from: classes.dex */
class ViewOnClickListenerC0948at implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySelectLanguage.SelectLanguageFragment f3339a;

    ViewOnClickListenerC0948at(ActivitySelectLanguage.SelectLanguageFragment selectLanguageFragment) {
        this.f3339a = selectLanguageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3339a.getActivity(), (Class<?>) SelectLanguage.class);
        intent.setFlags(67108864);
        this.f3339a.startActivityForResult(intent, 0);
    }
}
