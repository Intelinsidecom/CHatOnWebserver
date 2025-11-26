package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import java.util.ArrayList;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4126bh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ArrayList f15365a;

    /* renamed from: b */
    final /* synthetic */ MessageListItem f15366b;

    DialogInterfaceOnClickListenerC4126bh(MessageListItem messageListItem, ArrayList arrayList) {
        this.f15366b = messageListItem;
        this.f15365a = arrayList;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i >= 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) this.f15365a.get(i)));
            intent.putExtra("com.android.browser.application_id", this.f15366b.mContext.getPackageName());
            intent.setFlags(MotionRecognitionManager.EVENT_SMART_SCROLL);
            this.f15366b.mContext.startActivity(intent);
        }
        dialogInterface.dismiss();
    }
}
