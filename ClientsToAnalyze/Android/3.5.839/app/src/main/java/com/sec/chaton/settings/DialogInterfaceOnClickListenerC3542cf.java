package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.cf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3542cf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f13030a;

    DialogInterfaceOnClickListenerC3542cf(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f13030a = activityPasswordLockSet;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f13030a.f12611x != null) {
            this.f13030a.f12612y = ProgressDialogC4926s.m18728a(this.f13030a.f12611x, null, this.f13030a.getResources().getString(R.string.settings_deleting_account), true);
            C4892m.m18582e(false);
            if (!C4859bx.m18386a(this.f13030a.f12611x) || !this.f13030a.f12584G.m1495d(this.f13030a.f12611x)) {
                this.f13030a.f12586I.mo9079b(this.f13030a.f12587K);
                this.f13030a.f12587K.m18263a(1002, 30000);
            } else if (C4859bx.m18388b(this.f13030a.f12611x, this.f13030a.f12584G) != 0) {
                this.f13030a.f12586I.mo9079b(this.f13030a.f12587K);
                this.f13030a.f12587K.m18263a(1002, 30000);
            }
        }
    }
}
