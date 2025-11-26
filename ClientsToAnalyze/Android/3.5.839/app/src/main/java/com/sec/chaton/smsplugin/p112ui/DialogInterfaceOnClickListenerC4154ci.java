package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.content.DialogInterface;
import com.sec.chaton.smsplugin.transaction.C4081q;
import java.util.Map;

/* compiled from: MessageUtils.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ci */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC4154ci implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Map f15457a;

    /* renamed from: b */
    final /* synthetic */ Context f15458b;

    /* renamed from: c */
    final /* synthetic */ int f15459c;

    /* renamed from: d */
    final /* synthetic */ Runnable f15460d;

    DialogInterfaceOnClickListenerC4154ci(Map map, Context context, int i, Runnable runnable) {
        this.f15457a = map;
        this.f15458b = context;
        this.f15459c = i;
        this.f15460d = runnable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        for (Map.Entry entry : this.f15457a.entrySet()) {
            C4081q.m15691a(this.f15458b, (String) entry.getValue(), (String) entry.getKey(), this.f15459c);
        }
        if (this.f15460d != null) {
            this.f15460d.run();
        }
        dialogInterface.dismiss();
    }
}
