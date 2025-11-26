package com.sec.chaton.trunk;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C3197bl;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.bt */
/* loaded from: classes.dex */
class ViewOnClickListenerC3012bt implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f10860a;

    ViewOnClickListenerC3012bt(TrunkPageActivity trunkPageActivity) {
        this.f10860a = trunkPageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a() && this.f10860a.f10642c.size() > this.f10860a.f10656r) {
            C3017by c3017by = this.f10860a.f10642c.get(this.f10860a.f10656r);
            Intent intent = new Intent(this.f10860a.f10660v, (Class<?>) TrunkDetailActivity.class);
            intent.putExtra("sessionId", this.f10860a.f10648j);
            intent.putExtra("inboxNo", this.f10860a.f10647i);
            intent.putExtra("itemId", c3017by.f10870f);
            intent.putExtra("downloadUrl", c3017by.f10872h);
            intent.putExtra("contentType", c3017by.f10873i);
            intent.putExtra("totalcomment", c3017by.f10874j);
            intent.putExtra("isvalid", this.f10860a.f10643d);
            this.f10860a.startActivityForResult(intent, 1);
        }
    }
}
