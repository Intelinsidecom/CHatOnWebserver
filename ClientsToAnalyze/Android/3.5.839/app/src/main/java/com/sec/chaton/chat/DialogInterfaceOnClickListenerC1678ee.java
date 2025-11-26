package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.net.Uri;
import com.sec.chaton.p057e.EnumC2214ab;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ee */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1678ee implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f6254a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC1677ed f6255b;

    DialogInterfaceOnClickListenerC1678ee(AsyncTaskC1677ed asyncTaskC1677ed, File file) {
        this.f6255b = asyncTaskC1677ed;
        this.f6254a = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6255b.f6252m.m8229a(EnumC2214ab.FILE, this.f6254a.getName(), Uri.fromFile(this.f6254a).toString(), (String) null);
    }
}
