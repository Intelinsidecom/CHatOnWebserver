package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: RegistrationUtil.java */
/* renamed from: com.sec.chaton.util.by */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC4860by implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f17688a;

    /* renamed from: b */
    final /* synthetic */ String f17689b;

    DialogInterfaceOnClickListenerC4860by(Context context, String str) {
        this.f17688a = context;
        this.f17689b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f17688a.startActivity(C4859bx.m18371a(this.f17688a, FragmentWebView.mode.voc, this.f17689b));
    }
}
