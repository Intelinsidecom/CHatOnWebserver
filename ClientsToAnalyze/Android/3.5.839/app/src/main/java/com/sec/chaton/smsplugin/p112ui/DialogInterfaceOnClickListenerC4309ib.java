package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: SlideEditorActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ib */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4309ib implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SlideEditorActivity f15702a;

    DialogInterfaceOnClickListenerC4309ib(SlideEditorActivity slideEditorActivity) {
        this.f15702a = slideEditorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0 && i < 10) {
            this.f15702a.f15111j.m16488a(this.f15702a.f15114m, (i + 1) * 1000);
        } else {
            Intent intent = new Intent(this.f15702a, (Class<?>) EditSlideDurationActivity.class);
            intent.putExtra("slide_index", this.f15702a.f15114m);
            intent.putExtra("slide_total", this.f15702a.f15110i.size());
            intent.putExtra("dur", this.f15702a.f15110i.get(this.f15702a.f15114m).m14849a() / 1000);
            this.f15702a.startActivityForResult(intent, 6);
        }
        dialogInterface.dismiss();
    }
}
