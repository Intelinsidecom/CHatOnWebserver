package com.sec.chaton.smsplugin.multimedia.geotag;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.widget.InterfaceC4909b;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.b */
/* loaded from: classes.dex */
class C3924b implements InterfaceC4909b {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14152a;

    C3924b(MmsGeotagActivity mmsGeotagActivity) {
        this.f14152a = mmsGeotagActivity;
    }

    @Override // com.sec.chaton.widget.InterfaceC4909b
    /* renamed from: a */
    public void mo15183a() {
        Toast.makeText(this.f14152a.f14125c, R.string.toast_text_max_Length, 0).show();
    }
}
