package com.sec.chaton.userprofile;

import android.widget.CompoundButton;
import com.sec.chaton.R;

/* compiled from: UserProfileDetail.java */
/* renamed from: com.sec.chaton.userprofile.cf */
/* loaded from: classes.dex */
class C1683cf implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileDetail f6180a;

    C1683cf(UserProfileDetail userProfileDetail) {
        this.f6180a = userProfileDetail;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.f6180a.f6032O != this.f6180a.f6037T.isChecked()) {
            this.f6180a.f6048ae = true;
        } else {
            this.f6180a.f6048ae = false;
        }
        this.f6180a.invalidateOptionsMenu();
        if (z) {
            this.f6180a.f6038U.setText(this.f6180a.getResources().getString(R.string.phone_number_privacy_guide));
        } else {
            this.f6180a.f6038U.setText(this.f6180a.getResources().getString(R.string.phone_number_privacy_guide_off));
        }
    }
}
