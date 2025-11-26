package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.widget.C1619g;

/* compiled from: CountryWrite.java */
/* renamed from: com.sec.chaton.registration.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC0986r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CountryWrite f3382a;

    ViewOnClickListenerC0986r(CountryWrite countryWrite) {
        this.f3382a = countryWrite;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3382a.f3302b = this.f3382a.f3303c.getText().toString();
        if (this.f3382a.f3302b.length() == 0) {
            C1619g.m5889a(this.f3382a.f3301a, this.f3382a.getResources().getString(R.string.enter_your_country_code), 1).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("PARAMS_COUNTRY_CODE", this.f3382a.f3302b);
        this.f3382a.setResult(-1, intent);
        this.f3382a.finish();
    }
}
