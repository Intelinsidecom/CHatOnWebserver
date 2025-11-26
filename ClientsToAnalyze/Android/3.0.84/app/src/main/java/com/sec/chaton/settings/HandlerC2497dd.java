package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.settings.DeleteAccountPreference;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: DeleteAccountPreference.java */
/* renamed from: com.sec.chaton.settings.dd */
/* loaded from: classes.dex */
class HandlerC2497dd extends Handler {

    /* renamed from: a */
    final /* synthetic */ DeleteAccountPreference.DeleteWorkFragment f9387a;

    HandlerC2497dd(DeleteAccountPreference.DeleteWorkFragment deleteWorkFragment) {
        this.f9387a = deleteWorkFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (((Boolean) message.obj).booleanValue()) {
            C3250y.m11450b("Push deregistration is success. execute chaton deregistration.", DeleteAccountPreference.f9103b);
            if (!C3223ck.m11330d()) {
                if (this.f9387a.getActivity() != null) {
                    DeleteAccountPreference.f9102a.beginTransaction().detach(this.f9387a.f9108e).commitAllowingStateLoss();
                    DeleteAccountPreference.f9102a.executePendingTransactions();
                }
                Toast.makeText(CommonApplication.m11493l(), R.string.popup_not_enough_memory, 0).show();
                return;
            }
            this.f9387a.f9109f = this.f9387a.f9107d.m5596a();
            return;
        }
        C3250y.m11442a("Push deregistration is fail.", DeleteAccountPreference.f9103b);
        if (this.f9387a.getActivity() != null) {
            DeleteAccountPreference.f9102a.beginTransaction().detach(this.f9387a.f9108e).commitAllowingStateLoss();
            DeleteAccountPreference.f9102a.executePendingTransactions();
        }
        DeleteAccountPreference.f9102a.beginTransaction().add(DeleteAccountPreference.ErrorDialogFragment.m9080a(R.string.toast_error, R.string.toast_dereg_failed, R.string.dialog_ok), "error_dialog").commitAllowingStateLoss();
    }
}
