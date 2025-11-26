package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1323bs;
import com.sec.widget.C1619g;

/* compiled from: PhoneNumberPrivacyFragment.java */
/* renamed from: com.sec.chaton.userprofile.ai */
/* loaded from: classes.dex */
class HandlerC1212ai extends Handler {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberPrivacyFragment f4289a;

    HandlerC1212ai(PhoneNumberPrivacyFragment phoneNumberPrivacyFragment) {
        this.f4289a = phoneNumberPrivacyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4289a.getActivity() != null) {
            if (this.f4289a.f4168d != null) {
                this.f4289a.f4168d.dismiss();
            }
            C0259g c0259g = (C0259g) message.obj;
            if (!c0259g.m927a() || c0259g.m928b() == EnumC0518y.ERROR) {
                this.f4289a.f4167c.setChecked(C1323bs.m4575a().getBoolean("show_phone_number_to_all", false));
                C1619g.m5889a(this.f4289a.getActivity(), this.f4289a.getResources().getString(R.string.dev_network_error), 0).show();
            } else {
                C1619g.m5889a(this.f4289a.getActivity(), this.f4289a.getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
                this.f4289a.getActivity().finish();
            }
        }
    }
}
