package com.sec.chaton;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.p051c.C1427a;
import com.sec.common.util.C5055u;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2478l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f8885a;

    DialogInterfaceOnClickListenerC2478l(AdminMenu adminMenu) {
        this.f8885a = adminMenu;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        Uri uriM19202a;
        String str = "[" + C1427a.f5064b + "_DBdump] " + this.f8885a.f1893ad.getText().toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        String str2 = Environment.getExternalStorageDirectory() + File.separator + "chatondb.db";
        try {
            uriM19202a = C5055u.m19202a(this.f8885a.f1884U, new File[]{new File(str2), new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON.xml"), new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + C2717y.m11405h())}, new File(str2 + ".zip"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            uriM19202a = null;
        } catch (IOException e2) {
            e2.printStackTrace();
            uriM19202a = null;
        }
        if (uriM19202a == null) {
            C5179v.m19811a(this.f8885a.f1884U, "There is no file to send", 0).show();
            return;
        }
        intent.putExtra("android.intent.extra.STREAM", uriM19202a);
        intent.putExtra("android.intent.extra.TEXT", "chat on database back up file...");
        intent.putExtra("android.intent.extra.EMAIL", AdminMenu.f1863p);
        intent.setType("plain/text");
        intent.setFlags(268435456);
        this.f8885a.f1884U.startActivity(intent);
    }
}
