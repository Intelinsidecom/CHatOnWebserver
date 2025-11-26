package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.widget.C5179v;

/* compiled from: CountryWrite.java */
/* renamed from: com.sec.chaton.registration.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC3133ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CountryWrite f11864a;

    ViewOnClickListenerC3133ab(CountryWrite countryWrite) {
        this.f11864a = countryWrite;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11864a.f11612o = this.f11864a.f11613p.getText().toString();
        if (this.f11864a.f11612o.length() == 0) {
            C5179v.m19811a(this.f11864a.f11611n, this.f11864a.getResources().getString(R.string.enter_your_country_code), 1).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("PARAMS_COUNTRY_CODE", this.f11864a.f11612o);
        this.f11864a.setResult(-1, intent);
        this.f11864a.finish();
    }
}
