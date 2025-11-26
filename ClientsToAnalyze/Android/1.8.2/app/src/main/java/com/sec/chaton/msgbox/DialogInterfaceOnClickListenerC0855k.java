package com.sec.chaton.msgbox;

import android.content.DialogInterface;
import com.sec.chaton.p017e.EnumC0695j;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0855k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f3174a;

    /* renamed from: b */
    final /* synthetic */ EnumC0695j f3175b;

    /* renamed from: c */
    final /* synthetic */ String f3176c;

    /* renamed from: d */
    final /* synthetic */ String f3177d;

    /* renamed from: e */
    final /* synthetic */ int f3178e;

    /* renamed from: f */
    final /* synthetic */ MsgboxFragment f3179f;

    DialogInterfaceOnClickListenerC0855k(MsgboxFragment msgboxFragment, String str, EnumC0695j enumC0695j, String str2, String str3, int i) {
        this.f3179f = msgboxFragment;
        this.f3174a = str;
        this.f3175b = enumC0695j;
        this.f3176c = str2;
        this.f3177d = str3;
        this.f3178e = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3179f.m3534a(this.f3174a, this.f3175b, this.f3176c, this.f3177d, this.f3178e);
    }
}
