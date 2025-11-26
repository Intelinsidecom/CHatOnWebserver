package com.sec.chaton.smsplugin.p112ui;

import android.content.ContentUris;
import android.content.DialogInterface;
import android.net.Uri;
import android.provider.Telephony;
import com.sec.google.android.p134a.p136b.C5108d;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fy */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4251fy implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15608a;

    /* renamed from: b */
    private final Uri f15609b;

    /* renamed from: c */
    private final boolean f15610c;

    public DialogInterfaceOnClickListenerC4251fy(PluginComposeMessageActivity pluginComposeMessageActivity, Uri uri, boolean z) {
        this.f15608a = pluginComposeMessageActivity;
        this.f15609b = uri;
        this.f15610c = z;
    }

    public DialogInterfaceOnClickListenerC4251fy(PluginComposeMessageActivity pluginComposeMessageActivity, long j, String str, boolean z) {
        this.f15608a = pluginComposeMessageActivity;
        if ("mms".equals(str)) {
            this.f15609b = ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, j);
        } else {
            this.f15609b = ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, j);
        }
        this.f15610c = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C5108d.m19487b().mo19484b(this.f15609b);
        this.f15608a.f15013bH.m15240a(this.f15608a.f15019bQ, this.f15609b, 9700, (Object) null, this.f15610c);
        dialogInterface.dismiss();
    }
}
