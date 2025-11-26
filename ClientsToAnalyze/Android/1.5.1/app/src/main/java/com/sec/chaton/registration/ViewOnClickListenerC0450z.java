package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.registration.z */
/* loaded from: classes.dex */
class ViewOnClickListenerC0450z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CountryWrite f2962a;

    ViewOnClickListenerC0450z(CountryWrite countryWrite) {
        this.f2962a = countryWrite;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2962a.f2908b = this.f2962a.f2909c.getText().toString();
        if (this.f2962a.f2908b.length() == 0) {
            Toast.makeText(this.f2962a.f2907a, this.f2962a.getResources().getString(C0062R.string.enter_your_country_code), 1).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("PARAMS_COUNTRY_CODE", this.f2962a.f2908b);
        this.f2962a.setResult(-1, intent);
        this.f2962a.finish();
    }
}
