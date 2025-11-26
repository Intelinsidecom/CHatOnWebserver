package com.sec.chaton;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4892m;
import com.sec.common.util.C5033j;

/* compiled from: ExitAppDialogActivity.java */
/* renamed from: com.sec.chaton.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1068bh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExitAppDialogActivity f3363a;

    DialogInterfaceOnClickListenerC1068bh(ExitAppDialogActivity exitAppDialogActivity) {
        this.f3363a = exitAppDialogActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3363a.f1931a == 0 || 2 == this.f3363a.f1931a || 3 == this.f3363a.f1931a || 4 == this.f3363a.f1931a || 5 == this.f3363a.f1931a) {
            SharedPreferences.Editor editorEdit = this.f3363a.getSharedPreferences("PASSWORD_LOCK", 0).edit();
            editorEdit.putString("LOCK_STATE", C4892m.m18588h());
            editorEdit.putString("PASSWORD", "0000");
            editorEdit.putString("PASSWORD_HINT", "");
            C5033j.m19087a(editorEdit);
            new AsyncTaskC1069bi(this.f3363a, null).execute(new Void[0]);
            return;
        }
        C4809aa.m18104a().m18123a("exit_app_done");
        this.f3363a.finish();
        C0991aa.m6037a().m18962d(new C1058ba());
    }
}
