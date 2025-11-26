package com.sec.chaton.smsplugin.p112ui;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.C3856b;
import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;

/* compiled from: SlideshowPresenter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.iu */
/* loaded from: classes.dex */
class RunnableC4328iu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC4315ih f15736a;

    /* renamed from: b */
    final /* synthetic */ C3866l f15737b;

    /* renamed from: c */
    final /* synthetic */ boolean f15738c;

    /* renamed from: d */
    final /* synthetic */ SlideshowPresenter f15739d;

    RunnableC4328iu(SlideshowPresenter slideshowPresenter, InterfaceC4315ih interfaceC4315ih, C3866l c3866l, boolean z) {
        this.f15739d = slideshowPresenter;
        this.f15736a = interfaceC4315ih;
        this.f15737b = c3866l;
        this.f15738c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f15739d.presentAudio(this.f15736a, (C3856b) this.f15737b, this.f15738c);
        } catch (IOException e) {
            C3890m.m14995a("SlideshowPresenter", e.getMessage(), e);
            Toast.makeText(this.f15739d.mContext, this.f15739d.mContext.getString(R.string.insufficient_drm_rights), 0).show();
        }
    }
}
