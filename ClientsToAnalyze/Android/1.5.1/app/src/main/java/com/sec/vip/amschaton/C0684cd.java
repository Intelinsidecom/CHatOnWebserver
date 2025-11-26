package com.sec.vip.amschaton;

import android.content.SharedPreferences;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.amschaton.cd */
/* loaded from: classes.dex */
class C0684cd implements OnApplyListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4305a;

    C0684cd(AMSComposerActivity aMSComposerActivity) {
        this.f4305a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: a */
    public boolean mo4160a() {
        if (this.f4305a.f3831G.m3850h() != null) {
            return true;
        }
        if (this.f4305a.f3843S > AMSStampManager.m4056a().m4063b() && AMSStampManager.m4056a().m4064b(this.f4305a.f3843S - MsgResultCode.SUCCESS) == null) {
            this.f4305a.f3843S = 0;
        }
        this.f4305a.f3831G.m3833a(3, this.f4305a.f3843S, 0, 0);
        if (this.f4305a.f3843S < AMSStampManager.m4056a().m4063b()) {
            this.f4305a.f3863n.setImageBitmap(AMSStampManager.m4056a().m4058a(this.f4305a.f3843S));
        } else {
            this.f4305a.f3863n.setImageBitmap(AMSStampManager.m4056a().m4064b(this.f4305a.f3843S - MsgResultCode.SUCCESS));
        }
        this.f4305a.f3831G.invalidate();
        return true;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: b */
    public boolean mo4161b() {
        this.f4305a.f3843S = this.f4305a.f3850Z.m4082a();
        if ((this.f4305a.f3843S < 0 || this.f4305a.f3843S > AMSStampManager.m4056a().m4063b()) && AMSStampManager.m4056a().m4064b(this.f4305a.f3843S - MsgResultCode.SUCCESS) == null) {
            this.f4305a.f3843S = 0;
        }
        SharedPreferences sharedPreferences = this.f4305a.getSharedPreferences("AMSPref", 3);
        int[] iArr = {sharedPreferences.getInt("AMS_STAMP_PREF_00", -1), sharedPreferences.getInt("AMS_STAMP_PREF_01", -1), sharedPreferences.getInt("AMS_STAMP_PREF_02", -1), sharedPreferences.getInt("AMS_STAMP_PREF_03", -1), sharedPreferences.getInt("AMS_STAMP_PREF_04", -1)};
        int i = iArr[0];
        int i2 = 0;
        while (i2 < 5) {
            int i3 = iArr[i2];
            iArr[i2] = i;
            if (i3 == this.f4305a.f3843S) {
                break;
            }
            i2++;
            i = i3;
        }
        iArr[0] = this.f4305a.f3843S;
        sharedPreferences.edit().putInt("AMS_STAMP_PREF_00", iArr[0]).commit();
        sharedPreferences.edit().putInt("AMS_STAMP_PREF_01", iArr[1]).commit();
        sharedPreferences.edit().putInt("AMS_STAMP_PREF_02", iArr[2]).commit();
        sharedPreferences.edit().putInt("AMS_STAMP_PREF_03", iArr[3]).commit();
        sharedPreferences.edit().putInt("AMS_STAMP_PREF_04", iArr[4]).commit();
        this.f4305a.f3831G.m3833a(3, this.f4305a.f3843S, 0, 0);
        if (this.f4305a.f3843S < AMSStampManager.m4056a().m4063b()) {
            this.f4305a.f3863n.setImageBitmap(AMSStampManager.m4056a().m4058a(this.f4305a.f3843S));
        } else {
            this.f4305a.f3863n.setImageBitmap(AMSStampManager.m4056a().m4064b(this.f4305a.f3843S - MsgResultCode.SUCCESS));
        }
        this.f4305a.f3831G.invalidate();
        this.f4305a.m3740J();
        return true;
    }
}
