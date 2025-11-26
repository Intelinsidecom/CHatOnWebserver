package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.R;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1038dg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f4146a;

    /* renamed from: b */
    final /* synthetic */ String f4147b;

    /* renamed from: c */
    final /* synthetic */ AsyncTaskC1033db f4148c;

    DialogInterfaceOnClickListenerC1038dg(AsyncTaskC1033db asyncTaskC1033db, File file, String str) {
        this.f4148c = asyncTaskC1033db;
        this.f4146a = file;
        this.f4147b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        long length = 0;
        for (int i2 = 0; i2 < this.f4148c.f4133h.length; i2++) {
            if (this.f4148c.f4133h[i2].isFile()) {
                length += this.f4148c.f4133h[i2].length();
                if (this.f4146a.length() + length < 10485760) {
                    this.f4148c.f4134i.add(Uri.fromFile(this.f4148c.f4133h[i2]));
                }
            }
        }
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.SUBJECT", this.f4147b);
        intent.putExtra("android.intent.extra.TEXT", this.f4148c.f4138m.getString(R.string.attach_email_body, this.f4148c.f4127b));
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f4148c.f4134i);
        this.f4148c.f4138m.startActivityForResult(intent, 23);
    }
}
