package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.registration.CountryActivity;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: SelectCountry.java */
/* renamed from: com.sec.chaton.au */
/* loaded from: classes.dex */
class ViewOnClickListenerC0230au implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SelectCountry.RegisteFragment f762a;

    ViewOnClickListenerC0230au(SelectCountry.RegisteFragment registeFragment) {
        this.f762a = registeFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f762a.getActivity(), (Class<?>) CountryActivity.class);
        intent.putExtra(RtspHeaders.Values.MODE, 0);
        intent.setFlags(67108864);
        this.f762a.startActivityForResult(intent, 16);
    }
}
