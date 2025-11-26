package com.sec.chaton.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

/* compiled from: AboutFragment.java */
/* renamed from: com.sec.chaton.settings.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC1302d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1275c f4869a;

    ViewOnClickListenerC1302d(HandlerC1275c handlerC1275c) {
        this.f4869a = handlerC1275c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4869a.f4822a.f4447e != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f4869a.f4822a.f4447e));
            this.f4869a.f4822a.startActivity(intent);
            return;
        }
        Toast.makeText(this.f4869a.f4822a.getActivity(), "No download URL", 0).show();
    }
}
