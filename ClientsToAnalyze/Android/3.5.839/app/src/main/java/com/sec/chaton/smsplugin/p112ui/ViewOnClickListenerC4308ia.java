package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.view.View;

/* compiled from: SlideEditorActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ia */
/* loaded from: classes.dex */
class ViewOnClickListenerC4308ia implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SlideEditorActivity f15701a;

    ViewOnClickListenerC4308ia(SlideEditorActivity slideEditorActivity) {
        this.f15701a = slideEditorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("done", true);
        this.f15701a.setResult(-1, intent);
        this.f15701a.finish();
    }
}
