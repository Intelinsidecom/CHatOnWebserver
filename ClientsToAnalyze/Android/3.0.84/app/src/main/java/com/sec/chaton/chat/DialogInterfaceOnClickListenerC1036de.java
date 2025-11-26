package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.net.Uri;
import com.sec.chaton.p027e.EnumC1455w;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.de */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1036de implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f4143a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC1033db f4144b;

    DialogInterfaceOnClickListenerC1036de(AsyncTaskC1033db asyncTaskC1033db, File file) {
        this.f4144b = asyncTaskC1033db;
        this.f4143a = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4144b.f4138m.m4973a(EnumC1455w.FILE, this.f4143a.getName(), Uri.fromFile(this.f4143a).toString(), (String) null);
    }
}
