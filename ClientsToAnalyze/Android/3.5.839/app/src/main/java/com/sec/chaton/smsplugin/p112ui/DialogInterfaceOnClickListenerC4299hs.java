package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: SlideEditorActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4299hs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SlideEditorActivity f15693a;

    DialogInterfaceOnClickListenerC4299hs(SlideEditorActivity slideEditorActivity) {
        this.f15693a = slideEditorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f15693a.f15111j.m16502h(1);
                break;
            case 1:
                this.f15693a.f15111j.m16502h(0);
                break;
        }
        dialogInterface.dismiss();
    }
}
