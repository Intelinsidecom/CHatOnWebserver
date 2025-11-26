package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.net.Uri;
import com.sec.chaton.p027e.EnumC1455w;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1034dc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f4140a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC1033db f4141b;

    DialogInterfaceOnClickListenerC1034dc(AsyncTaskC1033db asyncTaskC1033db, File file) {
        this.f4141b = asyncTaskC1033db;
        this.f4140a = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4141b.f4138m.m4973a(EnumC1455w.FILE, this.f4140a.getName(), Uri.fromFile(this.f4140a).toString(), (String) null);
    }
}
