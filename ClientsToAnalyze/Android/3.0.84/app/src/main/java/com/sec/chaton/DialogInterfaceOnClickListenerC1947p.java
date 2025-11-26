package com.sec.chaton;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3241p;

/* compiled from: ExitAppDialogActivity.java */
/* renamed from: com.sec.chaton.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1947p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExitAppDialogActivity f7461a;

    DialogInterfaceOnClickListenerC1947p(ExitAppDialogActivity exitAppDialogActivity) {
        this.f7461a = exitAppDialogActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f7461a.f677a == 0 || 2 == this.f7461a.f677a || 3 == this.f7461a.f677a || 4 == this.f7461a.f677a) {
            SharedPreferences.Editor editorEdit = this.f7461a.getSharedPreferences("PASSWORD_LOCK", 0).edit();
            editorEdit.putString("LOCK_STATE", C3241p.m11409e());
            editorEdit.putString("PASSWORD", "0000");
            editorEdit.putString("PASSWORD_HINT", "");
            editorEdit.commit();
            new AsyncTaskC2118q(this.f7461a, null).execute(new Void[0]);
            return;
        }
        C3159aa.m10962a().m10981a("exit_app_done");
        this.f7461a.finish();
        GlobalApplication.m6449a(this.f7461a);
    }
}
