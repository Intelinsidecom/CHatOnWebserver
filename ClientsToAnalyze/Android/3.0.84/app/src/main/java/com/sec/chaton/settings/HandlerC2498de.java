package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.DeleteAccountPreference;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: DeleteAccountPreference.java */
/* renamed from: com.sec.chaton.settings.de */
/* loaded from: classes.dex */
class HandlerC2498de extends Handler {

    /* renamed from: a */
    final /* synthetic */ DeleteAccountPreference.DeleteWorkFragment f9388a;

    HandlerC2498de(DeleteAccountPreference.DeleteWorkFragment deleteWorkFragment) {
        this.f9388a = deleteWorkFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0267d c0267d = (C0267d) message.obj;
        switch (message.what) {
            case 202:
                if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && this.f9388a.f9109f != null && this.f9388a.f9109f.m5508i()) {
                    C3250y.m11450b("ChatON deregistration is success.", DeleteAccountPreference.f9103b);
                    C3159aa.m10963a("delete_account", (Boolean) true);
                    if (this.f9388a.getActivity() != null) {
                        GlobalApplication.m6449a(this.f9388a.getActivity());
                        break;
                    }
                } else {
                    if (this.f9388a.getActivity() != null) {
                        DeleteAccountPreference.f9102a.beginTransaction().detach(this.f9388a.f9108e).commitAllowingStateLoss();
                        DeleteAccountPreference.f9102a.executePendingTransactions();
                    }
                    C3250y.m11442a("ChatON deregistration is fail.", DeleteAccountPreference.f9103b);
                    DeleteAccountPreference.f9102a.beginTransaction().add(DeleteAccountPreference.ErrorDialogFragment.m9080a(R.string.toast_error, R.string.toast_dereg_failed, R.string.dialog_ok), "error_dialog").commitAllowingStateLoss();
                    break;
                }
                break;
        }
    }
}
