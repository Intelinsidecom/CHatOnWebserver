package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: CountryWrite.java */
/* renamed from: com.sec.chaton.registration.bh */
/* loaded from: classes.dex */
class ViewOnClickListenerC1181bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CountryWrite f4391a;

    ViewOnClickListenerC1181bh(CountryWrite countryWrite) {
        this.f4391a = countryWrite;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4391a.f4325b = this.f4391a.f4326c.getText().toString();
        if (this.f4391a.f4325b.length() == 0) {
            Toast.makeText(this.f4391a.f4324a, this.f4391a.getResources().getString(R.string.enter_your_country_code), 1).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("PARAMS_COUNTRY_CODE", this.f4391a.f4325b);
        this.f4391a.setResult(-1, intent);
        this.f4391a.finish();
    }
}
