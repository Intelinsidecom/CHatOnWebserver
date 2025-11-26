package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1230ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1229ah f4770a;

    DialogInterfaceOnClickListenerC1230ai(ViewOnClickListenerC1229ah viewOnClickListenerC1229ah) {
        this.f4770a = viewOnClickListenerC1229ah;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        RunnableC1228ag runnableC1228ag = null;
        if (this.f4770a.f4769b.f4535q != null) {
            this.f4770a.f4769b.f4536r = ProgressDialogC1806j.m6141a(this.f4770a.f4769b.f4535q, null, this.f4770a.f4769b.getResources().getString(R.string.settings_deleting_account), true);
            C1781m.m6023b(false);
            new AsyncTaskC1233al(this.f4770a.f4769b, runnableC1228ag).execute(new Void[0]);
        }
    }
}
