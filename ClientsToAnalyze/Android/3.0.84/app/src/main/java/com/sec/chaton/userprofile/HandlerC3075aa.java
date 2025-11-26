package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.common.p063a.AbstractC3271a;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: EditProfileFragment.java */
/* renamed from: com.sec.chaton.userprofile.aa */
/* loaded from: classes.dex */
class HandlerC3075aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ EditProfileFragment f11287a;

    HandlerC3075aa(EditProfileFragment editProfileFragment) {
        this.f11287a = editProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f11287a.getActivity() != null && !this.f11287a.getActivity().isFinishing()) {
            switch (message.what) {
                case HttpResponseCode.UNAUTHORIZED /* 401 */:
                    C0267d c0267d = (C0267d) message.obj;
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        if (this.f11287a.f11071e.isShowing()) {
                            this.f11287a.f11071e.dismiss();
                        }
                        AbstractC3271a.m11494a(this.f11287a.f11067a).mo11500a(this.f11287a.getResources().getString(R.string.toast_error)).mo11509b(this.f11287a.getResources().getString(R.string.setting_profile_update_status_failed)).mo11510b(this.f11287a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC3076ab(this)).mo11501a(this.f11287a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                        break;
                    } else {
                        C3159aa.m10962a().m10986b("Push Name", this.f11287a.f11068b.getText().toString());
                        C3159aa.m10962a().m10986b("status_message", this.f11287a.f11069c.getText().toString());
                        this.f11287a.getActivity().finish();
                        break;
                    }
                    break;
            }
        }
    }
}
