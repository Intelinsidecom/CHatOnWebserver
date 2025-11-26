package com.sec.chaton.userprofile;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.util.C1739av;

/* compiled from: PhoneNumberPrivacyFragment.java */
/* renamed from: com.sec.chaton.userprofile.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC1649az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PhoneNumberPrivacyFragment f6140a;

    ViewOnClickListenerC1649az(PhoneNumberPrivacyFragment phoneNumberPrivacyFragment) {
        this.f6140a = phoneNumberPrivacyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1739av.m5927a()) {
            switch (view.getId()) {
                case R.id.btnCancel /* 2131493037 */:
                    if (this.f6140a.f5950d != null) {
                        this.f6140a.f5950d.m2879e();
                    }
                    this.f6140a.getActivity().finish();
                    break;
                case R.id.btnSave /* 2131493782 */:
                    this.f6140a.f5950d = new C0633e(this.f6140a.f5953g);
                    this.f6140a.f5950d.m2870b(this.f6140a.f5948b.isChecked());
                    this.f6140a.f5949c.show();
                    FragmentActivity activity = this.f6140a.getActivity();
                    this.f6140a.getActivity();
                    activity.setResult(-1);
                    break;
            }
        }
    }
}
