package com.sec.chaton;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.sec.chaton.msgsend.C1757q;
import com.sec.common.util.C3367r;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.d */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1143d implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f4568a;

    DialogInterfaceOnClickListenerC1143d(AdminMenu adminMenu) {
        this.f4568a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        String str;
        Uri uriM11852a;
        String string = this.f4568a.f638K.getText().toString();
        if (TextUtils.isEmpty(string)) {
            str = "ChatON DB Backup File";
        } else {
            str = string + " - ChatON DB Backup File";
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        String str2 = Environment.getExternalStorageDirectory() + File.separator + "chatondb.db";
        try {
            uriM11852a = C3367r.m11852a(this.f4568a.f630C, new File[]{new File(str2), new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/chaton.xml"), new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + C1757q.m7256f())}, new File(str2 + ".zip"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            uriM11852a = null;
        } catch (IOException e2) {
            e2.printStackTrace();
            uriM11852a = null;
        }
        if (uriM11852a == null) {
            C3641ai.m13211a(this.f4568a.f630C, "There is no file to send", 0).show();
            return;
        }
        intent.putExtra("android.intent.extra.STREAM", uriM11852a);
        intent.putExtra("android.intent.extra.TEXT", "chat on database back up file...");
        intent.putExtra("android.intent.extra.EMAIL", AdminMenu.f627b);
        intent.setType("plain/text");
        intent.setFlags(268435456);
        this.f4568a.f630C.startActivity(intent);
    }
}
