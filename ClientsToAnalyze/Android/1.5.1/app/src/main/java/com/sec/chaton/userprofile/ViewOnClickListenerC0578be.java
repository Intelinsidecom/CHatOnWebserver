package com.sec.chaton.userprofile;

import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.ContactControl;

/* renamed from: com.sec.chaton.userprofile.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC0578be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberPrivacyActivity f3560a;

    ViewOnClickListenerC0578be(PhoneNumberPrivacyActivity phoneNumberPrivacyActivity) {
        this.f3560a = phoneNumberPrivacyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btnCancel /* 2131427489 */:
                this.f3560a.finish();
                break;
            case C0062R.id.btnSave /* 2131427939 */:
                new ContactControl(this.f3560a.f3343e).m1998b(this.f3560a.f3341c.isChecked());
                this.f3560a.showDialog(0);
                break;
        }
    }
}
