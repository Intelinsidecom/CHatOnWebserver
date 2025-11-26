package com.sec.chaton.smsplugin.p112ui;

import android.view.View;

/* compiled from: SlideEditorActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hz */
/* loaded from: classes.dex */
class ViewOnClickListenerC4306hz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SlideEditorActivity f15700a;

    ViewOnClickListenerC4306hz(SlideEditorActivity slideEditorActivity) {
        this.f15700a = slideEditorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15700a.f15114m < this.f15700a.f15110i.size() - 1) {
            SlideEditorActivity.m16202g(this.f15700a);
            this.f15700a.m16199e();
        }
    }
}
