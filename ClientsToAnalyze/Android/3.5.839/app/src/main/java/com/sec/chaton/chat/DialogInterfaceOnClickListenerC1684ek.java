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
/* renamed from: com.sec.chaton.chat.ek */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1684ek implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6264a;

    /* renamed from: b */
    final /* synthetic */ File f6265b;

    /* renamed from: c */
    final /* synthetic */ AsyncTaskC1677ed f6266c;

    DialogInterfaceOnClickListenerC1684ek(AsyncTaskC1677ed asyncTaskC1677ed, String str, File file) {
        this.f6266c = asyncTaskC1677ed;
        this.f6264a = str;
        this.f6265b = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.SUBJECT", this.f6264a);
        intent.putExtra("android.intent.extra.TEXT", this.f6266c.f6252m.getString(R.string.attach_email_body, this.f6266c.f6241b));
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(this.f6265b));
        try {
            this.f6266c.f6252m.startActivityForResult(intent, 23);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, ChatFragment.f5461a);
            }
        }
    }
}
