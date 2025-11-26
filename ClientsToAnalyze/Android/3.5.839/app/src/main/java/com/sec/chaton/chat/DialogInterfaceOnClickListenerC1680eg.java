package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.net.Uri;
import com.sec.chaton.p057e.EnumC2214ab;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.eg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1680eg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f6257a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC1677ed f6258b;

    DialogInterfaceOnClickListenerC1680eg(AsyncTaskC1677ed asyncTaskC1677ed, File file) {
        this.f6258b = asyncTaskC1677ed;
        this.f6257a = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6258b.f6252m.m8229a(EnumC2214ab.FILE, this.f6257a.getName(), Uri.fromFile(this.f6257a).toString(), (String) null);
    }
}
