package com.sec.chaton.smsplugin.p112ui;

import android.view.View;

/* compiled from: SlideEditorActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hy */
/* loaded from: classes.dex */
class ViewOnClickListenerC4305hy implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SlideEditorActivity f15699a;

    ViewOnClickListenerC4305hy(SlideEditorActivity slideEditorActivity) {
        this.f15699a = slideEditorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15699a.f15114m > 0) {
            SlideEditorActivity.m16197d(this.f15699a);
            this.f15699a.m16199e();
        }
    }
}
