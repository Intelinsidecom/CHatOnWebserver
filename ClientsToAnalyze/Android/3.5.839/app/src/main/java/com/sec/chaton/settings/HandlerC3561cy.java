package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetPrivacyList;
import com.sec.chaton.p065io.entry.inner.PrivacyList;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.widget.C5179v;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.cy */
/* loaded from: classes.dex */
class HandlerC3561cy extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f13050a;

    HandlerC3561cy(ActivityPrivacy activityPrivacy) {
        this.f13050a = activityPrivacy;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f13050a.f12624b != null) {
            if (this.f13050a.f12628f != null) {
                this.f13050a.f12628f.dismiss();
            }
            switch (message.what) {
                case 304:
                    C0778b c0778b = (C0778b) message.obj;
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f13050a.f12626d.setChecked(C4809aa.m18104a().m18119a("show_phone_number_to_all", (Boolean) true).booleanValue());
                        this.f13050a.f12627e.setChecked(C4809aa.m18104a().m18119a("samsung_account_show", (Boolean) false).booleanValue());
                        C5179v.m19810a(this.f13050a.f12624b, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else {
                        this.f13050a.m13517b();
                        C5179v.m19810a(this.f13050a.f12624b, R.string.buddy_profile_saveprofile_toast_success, 0).show();
                        break;
                    }
                    break;
                case 322:
                    C0778b c0778b2 = (C0778b) message.obj;
                    if (!c0778b2.m18954n() || c0778b2.m3107b() == EnumC2464o.ERROR) {
                        this.f13050a.f12646x = true;
                        this.f13050a.f12626d.setEnabled(false);
                        this.f13050a.f12627e.setEnabled(false);
                        if (this.f13050a.f12628f != null) {
                            this.f13050a.f12628f.dismiss();
                        }
                        C5179v.m19810a(this.f13050a.f12624b, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else {
                        this.f13050a.f12646x = false;
                        GetPrivacyList getPrivacyList = (GetPrivacyList) c0778b2.m3110e();
                        if (getPrivacyList != null) {
                            this.f13050a.f12643u = getPrivacyList.privacy;
                            for (int i = 0; i < this.f13050a.f12643u.size(); i++) {
                                this.f13050a.m13514a(((PrivacyList) this.f13050a.f12643u.get(i)).name, ((PrivacyList) this.f13050a.f12643u.get(i))._value);
                            }
                            this.f13050a.m13517b();
                            if (this.f13050a.f12628f != null) {
                                this.f13050a.f12628f.dismiss();
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
