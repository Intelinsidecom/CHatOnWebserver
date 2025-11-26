package com.sec.chaton.smsplugin.p112ui;

import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p110g.InterfaceC3860f;

/* compiled from: SlideEditorActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hr */
/* loaded from: classes.dex */
class C4298hr implements InterfaceC3860f {

    /* renamed from: a */
    final /* synthetic */ SlideEditorActivity f15692a;

    C4298hr(SlideEditorActivity slideEditorActivity) {
        this.f15692a = slideEditorActivity;
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3860f
    public void onModelChanged(C3866l c3866l, boolean z) {
        synchronized (this.f15692a) {
            this.f15692a.f15113l = true;
        }
        this.f15692a.setResult(-1);
    }
}
