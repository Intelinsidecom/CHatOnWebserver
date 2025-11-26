package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1016ao;
import com.sec.chaton.EnumC1017ap;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: EditNameFragment.java */
/* renamed from: com.sec.chaton.userprofile.q */
/* loaded from: classes.dex */
class HandlerC4798q extends Handler {

    /* renamed from: a */
    final /* synthetic */ EditNameFragment f17530a;

    HandlerC4798q(EditNameFragment editNameFragment) {
        this.f17530a = editNameFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f17530a.getActivity() != null && !this.f17530a.getActivity().isFinishing()) {
            switch (message.what) {
                case 401:
                    C0778b c0778b = (C0778b) message.obj;
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        if (this.f17530a.f17122e.isShowing()) {
                            this.f17530a.f17122e.dismiss();
                        }
                        AbstractC4932a.m18733a(this.f17530a.f17119a).mo18740a(this.f17530a.getResources().getString(R.string.toast_error)).mo18749b(this.f17530a.getResources().getString(R.string.setting_profile_update_status_failed)).mo18755c(this.f17530a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC4799r(this)).mo18741a(this.f17530a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                        break;
                    } else {
                        C4809aa.m18104a().m18128b("Push Name", this.f17530a.f17120c.getText().toString().trim());
                        C0991aa.m6037a().m18962d(new C1016ao(EnumC1017ap.NAME_CHANGED));
                        this.f17530a.getActivity().finish();
                        break;
                    }
                    break;
            }
        }
    }
}
