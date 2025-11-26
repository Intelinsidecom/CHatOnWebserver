package com.sec.chaton.smsplugin.spam;

import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.w */
/* loaded from: classes.dex */
class RunnableC4045w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC4044v f14559a;

    RunnableC4045w(DialogInterfaceOnClickListenerC4044v dialogInterfaceOnClickListenerC4044v) {
        this.f14559a = dialogInterfaceOnClickListenerC4044v;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z = false;
        for (int count = this.f14559a.f14558a.f14308i.getCount() - this.f14559a.f14558a.f14311l; count > 0; count--) {
            if (this.f14559a.f14558a.f14308i.isItemChecked(count)) {
                this.f14559a.f14558a.m15317a(((C4017bu) this.f14559a.f14558a.f14301b.get(count - this.f14559a.f14558a.f14311l)).m15454a());
                this.f14559a.f14558a.f14301b.remove(count - this.f14559a.f14558a.f14311l);
                z = true;
            }
        }
        if (z) {
            this.f14559a.f14558a.f14305f = 0;
            this.f14559a.f14558a.m15322a(this.f14559a.f14558a.getString(R.string.delete_complete));
            this.f14559a.f14558a.m15332c();
            return;
        }
        C3890m.m14999e("Mms/SetupSpamKeywordList", "softkeyLeftRun - no item");
    }
}
