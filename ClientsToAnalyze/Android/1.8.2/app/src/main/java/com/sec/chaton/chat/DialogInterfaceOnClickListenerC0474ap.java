package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.R;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0474ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f1955a;

    /* renamed from: b */
    final /* synthetic */ String f1956b;

    /* renamed from: c */
    final /* synthetic */ AsyncTaskC0473ao f1957c;

    DialogInterfaceOnClickListenerC0474ap(AsyncTaskC0473ao asyncTaskC0473ao, File file, String str) {
        this.f1957c = asyncTaskC0473ao;
        this.f1955a = file;
        this.f1956b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        long length = 0;
        for (int i2 = 0; i2 < this.f1957c.f1948h.length; i2++) {
            if (this.f1957c.f1948h[i2].isFile()) {
                length += this.f1957c.f1948h[i2].length();
                if (this.f1955a.length() + length < 10485760) {
                    this.f1957c.f1949i.add(Uri.fromFile(this.f1957c.f1948h[i2]));
                }
            }
        }
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.SUBJECT", this.f1956b);
        intent.putExtra("android.intent.extra.TEXT", this.f1957c.f1953m.getString(R.string.attach_email_body, this.f1957c.f1942b));
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f1957c.f1949i);
        this.f1957c.f1953m.startActivity(Intent.createChooser(intent, this.f1957c.f1953m.getString(R.string.choose_email_app)));
    }
}
