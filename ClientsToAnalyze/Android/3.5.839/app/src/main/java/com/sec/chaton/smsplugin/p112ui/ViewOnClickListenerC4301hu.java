package com.sec.chaton.smsplugin.p112ui;

import android.view.View;

/* compiled from: SlideEditorActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hu */
/* loaded from: classes.dex */
class ViewOnClickListenerC4301hu implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SlideEditorActivity f15695a;

    ViewOnClickListenerC4301hu(SlideEditorActivity slideEditorActivity) {
        this.f15695a = slideEditorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15695a.f15114m >= 0 && this.f15695a.f15114m < this.f15695a.f15110i.size()) {
            this.f15695a.f15111j.m16494b(this.f15695a.f15114m);
            int size = this.f15695a.f15110i.size();
            if (size > 0) {
                if (this.f15695a.f15114m >= size) {
                    SlideEditorActivity.m16197d(this.f15695a);
                }
                this.f15695a.m16199e();
                return;
            }
            this.f15695a.finish();
        }
    }
}
