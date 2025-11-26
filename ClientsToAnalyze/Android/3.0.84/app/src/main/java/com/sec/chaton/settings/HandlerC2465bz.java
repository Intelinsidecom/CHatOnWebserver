package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetPrivacyList;
import com.sec.chaton.p035io.entry.inner.PrivacyList;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.widget.C3641ai;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.bz */
/* loaded from: classes.dex */
class HandlerC2465bz extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f9325a;

    HandlerC2465bz(ActivityPrivacy activityPrivacy) {
        this.f9325a = activityPrivacy;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9325a.f9064b != null) {
            if (this.f9325a.f9068f != null) {
                this.f9325a.f9068f.dismiss();
            }
            switch (message.what) {
                case HttpResponseCode.NOT_MODIFIED /* 304 */:
                    C0267d c0267d = (C0267d) message.obj;
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f9325a.f9066d.setChecked(C3159aa.m10962a().m10977a("show_phone_number_to_all", (Boolean) true).booleanValue());
                        this.f9325a.f9067e.setChecked(C3159aa.m10962a().m10977a("samsung_account_show", (Boolean) false).booleanValue());
                        C3641ai.m13210a(this.f9325a.f9064b, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else {
                        this.f9325a.m9048b();
                        C3641ai.m13210a(this.f9325a.f9064b, R.string.buddy_profile_saveprofile_toast_success, 0).show();
                        break;
                    }
                    break;
                case 322:
                    C0267d c0267d2 = (C0267d) message.obj;
                    if (!c0267d2.m11704n() || c0267d2.m1351b() == EnumC1587o.ERROR) {
                        this.f9325a.f9088z = true;
                        this.f9325a.f9066d.setEnabled(false);
                        this.f9325a.f9067e.setEnabled(false);
                        if (this.f9325a.f9068f != null) {
                            this.f9325a.f9068f.dismiss();
                        }
                        C3641ai.m13210a(this.f9325a.f9064b, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else {
                        this.f9325a.f9088z = false;
                        GetPrivacyList getPrivacyList = (GetPrivacyList) c0267d2.m1354e();
                        if (getPrivacyList != null) {
                            this.f9325a.f9085w = getPrivacyList.privacy;
                            for (int i = 0; i < this.f9325a.f9085w.size(); i++) {
                                this.f9325a.m9045a(((PrivacyList) this.f9325a.f9085w.get(i)).name, ((PrivacyList) this.f9325a.f9085w.get(i))._value);
                            }
                            this.f9325a.m9048b();
                            if (this.f9325a.f9068f != null) {
                                this.f9325a.f9068f.dismiss();
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
