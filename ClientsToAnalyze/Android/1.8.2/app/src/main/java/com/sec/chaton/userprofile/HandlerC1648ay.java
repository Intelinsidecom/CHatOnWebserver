package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: PhoneNumberPrivacyFragment.java */
/* renamed from: com.sec.chaton.userprofile.ay */
/* loaded from: classes.dex */
class HandlerC1648ay extends Handler {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberPrivacyFragment f6139a;

    HandlerC1648ay(PhoneNumberPrivacyFragment phoneNumberPrivacyFragment) {
        this.f6139a = phoneNumberPrivacyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (!this.f6139a.getActivity().isFinishing()) {
            if (this.f6139a.f5949c != null) {
                this.f6139a.f5949c.dismiss();
            }
            C0101b c0101b = (C0101b) message.obj;
            if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
                C1789u.m6076a("show_phone_number_to_all", Boolean.valueOf(this.f6139a.f5948b.isChecked()));
                if (this.f6139a.getActivity() != null) {
                    this.f6139a.getActivity().finish();
                    return;
                }
                return;
            }
            if (this.f6139a.getActivity() != null) {
                this.f6139a.f5948b.setChecked(C1789u.m6075a().getBoolean("show_phone_number_to_all", false));
                Toast.makeText(this.f6139a.getActivity(), this.f6139a.getResources().getString(R.string.dev_network_error), 0).show();
                return;
            }
            return;
        }
        C1786r.m6066e("is Finishing : " + this.f6139a.getActivity().isFinishing(), getClass().getSimpleName());
    }
}
