package com.sec.chaton.smsplugin.p112ui;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.content.DialogInterface;
import java.util.Collection;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gt */
/* loaded from: classes.dex */
public class DialogInterfaceOnClickListenerC4273gt implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final Collection<Long> f15646a;

    /* renamed from: b */
    private final AsyncQueryHandler f15647b;

    /* renamed from: c */
    private final Context f15648c;

    /* renamed from: d */
    private boolean f15649d;

    public DialogInterfaceOnClickListenerC4273gt(Collection<Long> collection, AsyncQueryHandler asyncQueryHandler, Context context) {
        this.f15646a = collection;
        this.f15647b = asyncQueryHandler;
        this.f15648c = context;
    }

    /* renamed from: a */
    public void m16479a(boolean z) {
        this.f15649d = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4149cd.m16412a(this.f15648c, this.f15646a, 129, new RunnableC4274gu(this));
        dialogInterface.dismiss();
    }
}
