package com.sec.chaton.chat;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ei */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1682ei implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f6260a;

    /* renamed from: b */
    final /* synthetic */ String f6261b;

    /* renamed from: c */
    final /* synthetic */ AsyncTaskC1677ed f6262c;

    DialogInterfaceOnClickListenerC1682ei(AsyncTaskC1677ed asyncTaskC1677ed, File file, String str) {
        this.f6262c = asyncTaskC1677ed;
        this.f6260a = file;
        this.f6261b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        long length = 0;
        for (int i2 = 0; i2 < this.f6262c.f6247h.length; i2++) {
            if (this.f6262c.f6247h[i2].isFile()) {
                length += this.f6262c.f6247h[i2].length();
                if (this.f6260a.length() + length < 10485760) {
                    this.f6262c.f6248i.add(Uri.fromFile(this.f6262c.f6247h[i2]));
                }
            }
        }
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.SUBJECT", this.f6261b);
        intent.putExtra("android.intent.extra.TEXT", this.f6262c.f6252m.getString(R.string.attach_email_body, this.f6262c.f6241b));
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f6262c.f6248i);
        try {
            this.f6262c.f6252m.startActivityForResult(intent, 23);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, ChatFragment.f5461a);
            }
        }
    }
}
