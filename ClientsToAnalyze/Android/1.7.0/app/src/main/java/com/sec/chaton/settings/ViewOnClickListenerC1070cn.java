package com.sec.chaton.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.sec.widget.C1619g;

/* compiled from: AboutFragment.java */
/* renamed from: com.sec.chaton.settings.cn */
/* loaded from: classes.dex */
class ViewOnClickListenerC1070cn implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1009ag f3715a;

    ViewOnClickListenerC1070cn(HandlerC1009ag handlerC1009ag) {
        this.f3715a = handlerC1009ag;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3715a.f3613a.f3408e != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f3715a.f3613a.f3408e));
            this.f3715a.f3613a.startActivity(intent);
            return;
        }
        C1619g.m5889a(this.f3715a.f3613a.getActivity(), "No download URL", 0).show();
    }
}
