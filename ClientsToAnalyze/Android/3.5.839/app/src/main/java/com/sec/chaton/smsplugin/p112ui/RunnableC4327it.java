package com.sec.chaton.smsplugin.p112ui;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.AbstractC3867m;
import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;

/* compiled from: SlideshowPresenter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.it */
/* loaded from: classes.dex */
class RunnableC4327it implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC4315ih f15732a;

    /* renamed from: b */
    final /* synthetic */ C3866l f15733b;

    /* renamed from: c */
    final /* synthetic */ boolean f15734c;

    /* renamed from: d */
    final /* synthetic */ SlideshowPresenter f15735d;

    RunnableC4327it(SlideshowPresenter slideshowPresenter, InterfaceC4315ih interfaceC4315ih, C3866l c3866l, boolean z) {
        this.f15735d = slideshowPresenter;
        this.f15732a = interfaceC4315ih;
        this.f15733b = c3866l;
        this.f15734c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f15735d.presentRegionMedia(this.f15732a, (AbstractC3867m) this.f15733b, this.f15734c);
        } catch (IOException e) {
            C3890m.m14995a("SlideshowPresenter", e.getMessage(), e);
            Toast.makeText(this.f15735d.mContext, this.f15735d.mContext.getString(R.string.insufficient_drm_rights), 0).show();
        }
    }
}
