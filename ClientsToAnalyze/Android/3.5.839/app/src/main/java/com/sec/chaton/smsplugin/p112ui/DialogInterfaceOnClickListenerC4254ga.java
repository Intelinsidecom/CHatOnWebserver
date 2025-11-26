package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import java.util.Collection;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ga */
/* loaded from: classes.dex */
public class DialogInterfaceOnClickListenerC4254ga implements DialogInterface.OnClickListener {

    /* renamed from: a */
    protected Handler f15614a;

    /* renamed from: b */
    private final Collection<Long> f15615b;

    /* renamed from: c */
    private final Context f15616c;

    /* renamed from: d */
    private boolean f15617d;

    public DialogInterfaceOnClickListenerC4254ga(Collection<Long> collection, Context context, Handler handler) {
        this.f15615b = collection;
        this.f15616c = context;
        this.f15614a = handler;
    }

    /* renamed from: a */
    public void m16469a(boolean z) {
        this.f15617d = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4149cd.m16412a(this.f15616c, this.f15615b, 129, new RunnableC4255gb(this));
        dialogInterface.dismiss();
    }
}
