package com.sec.chaton.multimedia.geotag;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.widget.C2153y;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.e */
/* loaded from: classes.dex */
class C0975e implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f3594a;

    C0975e(GeotagActivity geotagActivity) {
        this.f3594a = geotagActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() >= 1024) {
            C2153y.m7535a((Context) this.f3594a, R.string.toast_text_max_Length, 0).show();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
