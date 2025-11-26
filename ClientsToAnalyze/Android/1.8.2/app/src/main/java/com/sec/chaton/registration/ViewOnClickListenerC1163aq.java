package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivitySelectLanguage;

/* compiled from: ActivitySelectLanguage.java */
/* renamed from: com.sec.chaton.registration.aq */
/* loaded from: classes.dex */
class ViewOnClickListenerC1163aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySelectLanguage.SelectLanguageFragment f4365a;

    ViewOnClickListenerC1163aq(ActivitySelectLanguage.SelectLanguageFragment selectLanguageFragment) {
        this.f4365a = selectLanguageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4365a.getActivity(), (Class<?>) SelectLanguage.class);
        intent.setFlags(67108864);
        intent.putExtra("extra_hide_language", this.f4365a.f4282j.getText().toString());
        this.f4365a.startActivityForResult(intent, 0);
    }
}
