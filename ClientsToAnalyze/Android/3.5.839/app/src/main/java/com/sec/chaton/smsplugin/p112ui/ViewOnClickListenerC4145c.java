package com.sec.chaton.smsplugin.p112ui;

import android.os.Message;
import android.view.View;

/* compiled from: AttachmentEditor.java */
/* renamed from: com.sec.chaton.smsplugin.ui.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC4145c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AttachmentEditor f15427a;

    /* renamed from: b */
    private int f15428b;

    public ViewOnClickListenerC4145c(AttachmentEditor attachmentEditor, int i) {
        this.f15427a = attachmentEditor;
        this.f15428b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Message.obtain(this.f15427a.f14730b, this.f15428b).sendToTarget();
    }
}
