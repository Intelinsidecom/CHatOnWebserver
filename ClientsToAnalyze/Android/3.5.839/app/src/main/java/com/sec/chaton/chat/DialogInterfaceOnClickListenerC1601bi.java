package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.p057e.EnumC2214ab;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1601bi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f6107a;

    /* renamed from: b */
    final /* synthetic */ String f6108b;

    /* renamed from: c */
    final /* synthetic */ String f6109c;

    /* renamed from: d */
    final /* synthetic */ EnumC2214ab f6110d;

    /* renamed from: e */
    final /* synthetic */ String f6111e;

    /* renamed from: f */
    final /* synthetic */ String f6112f;

    /* renamed from: g */
    final /* synthetic */ String f6113g;

    /* renamed from: h */
    final /* synthetic */ String f6114h;

    /* renamed from: i */
    final /* synthetic */ boolean f6115i;

    /* renamed from: j */
    final /* synthetic */ ChatFragment f6116j;

    DialogInterfaceOnClickListenerC1601bi(ChatFragment chatFragment, File file, String str, String str2, EnumC2214ab enumC2214ab, String str3, String str4, String str5, String str6, boolean z) {
        this.f6116j = chatFragment;
        this.f6107a = file;
        this.f6108b = str;
        this.f6109c = str2;
        this.f6110d = enumC2214ab;
        this.f6111e = str3;
        this.f6112f = str4;
        this.f6113g = str5;
        this.f6114h = str6;
        this.f6115i = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f6107a.length() > 31457280) {
            this.f6116j.m7933a(this.f6107a);
        } else {
            this.f6116j.m8073b(this.f6107a, this.f6108b, this.f6109c, this.f6110d, this.f6111e, this.f6112f, this.f6113g, this.f6114h, this.f6115i);
        }
    }
}
