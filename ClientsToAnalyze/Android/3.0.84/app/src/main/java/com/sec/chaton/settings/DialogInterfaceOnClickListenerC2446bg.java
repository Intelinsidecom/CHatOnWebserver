package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.bg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2446bg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f9306a;

    DialogInterfaceOnClickListenerC2446bg(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f9306a = activityPasswordLockSet;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9306a.f9046u != null) {
            this.f9306a.f9047v = ProgressDialogC3265l.m11490a(this.f9306a.f9046u, null, this.f9306a.getResources().getString(R.string.settings_deleting_account), true);
            C3241p.m11405c(false);
            if (C3214cb.m11256a(this.f9306a.f9046u) && this.f9306a.f9024D.m55d(this.f9306a.f9046u)) {
                this.f9306a.f9024D.m54c(this.f9306a.f9046u);
                C3250y.m11450b("onCreate:mChatonV.removeAccountInDevice()", ActivityPasswordLockSet.class.getSimpleName());
            } else {
                new AsyncTaskC2453bn(this.f9306a, null).execute(new Void[0]);
            }
        }
    }
}
