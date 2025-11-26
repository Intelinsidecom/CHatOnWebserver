package com.sec.chaton.samsungaccount;

import android.content.res.Resources;
import android.view.View;
import com.sec.chaton.global.C1493a;
import java.io.UnsupportedEncodingException;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC2316ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8739a;

    ViewOnClickListenerC2316ae(MainActivity mainActivity) {
        this.f8739a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (!C1493a.m6463a("mum_enable_feature")) {
            this.f8739a.m8777f();
        } else {
            this.f8739a.m8744a(true);
        }
    }
}
