package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: CountryWrite.java */
/* renamed from: com.sec.chaton.registration.bn */
/* loaded from: classes.dex */
class ViewOnClickListenerC2163bn implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CountryWrite f8448a;

    ViewOnClickListenerC2163bn(CountryWrite countryWrite) {
        this.f8448a = countryWrite;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f8448a.f8192b = this.f8448a.f8193c.getText().toString();
        if (this.f8448a.f8192b.length() == 0) {
            C3641ai.m13211a(this.f8448a.f8191a, this.f8448a.getResources().getString(R.string.enter_your_country_code), 1).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("PARAMS_COUNTRY_CODE", this.f8448a.f8192b);
        this.f8448a.setResult(-1, intent);
        this.f8448a.finish();
    }
}
