package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.BuddyProfile;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.sns.p114b.C4392ar;
import com.sec.chaton.sns.p114b.InterfaceC4377ac;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.av */
/* loaded from: classes.dex */
class HandlerC3504av extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityManageAccounts f12992a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3504av(ActivityManageAccounts activityManageAccounts, Looper looper) {
        super(looper);
        this.f12992a = activityManageAccounts;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String strM3112g;
        if (!this.f12992a.f12533p) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 209:
                    if (!(this.f12992a.f12529l instanceof C4392ar)) {
                        this.f12992a.m13404e();
                    }
                    if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Success to deregister with SNS", this.f12992a.f12519b);
                        }
                        if (this.f12992a.f12529l instanceof C4392ar) {
                            this.f12992a.f12529l.mo16642a(new C3505aw(this));
                            break;
                        } else {
                            this.f12992a.f12529l.mo16642a((InterfaceC4377ac) null);
                            C4809aa.m18104a().m18123a("register_sns_type");
                            this.f12992a.finish();
                            break;
                        }
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Failed to deregister with SNS", this.f12992a.f12519b);
                        }
                        if (c0778b == null) {
                            strM3112g = "";
                        } else {
                            strM3112g = c0778b.m3112g();
                        }
                        InterfaceC4936e interfaceC4936eMo18745a = C4859bx.m18375a(AbstractC4932a.m18733a(this.f12992a.f12526i).mo18740a(this.f12992a.getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(this.f12992a.getResources().getString(R.string.toast_network_unable), this.f12992a.getResources().getString(R.string.error_code_common), strM3112g)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3507ay(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3506ax(this)), this.f12992a.f12526i, strM3112g).mo18745a();
                        if (!this.f12992a.f12533p) {
                            interfaceC4936eMo18745a.show();
                            break;
                        }
                    }
                    break;
                case 411:
                    if (this.f12992a.f12524g != null && this.f12992a.f12524g.isShowing()) {
                        this.f12992a.f12524g.dismiss();
                    }
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        Toast.makeText(this.f12992a.f12526i, R.string.toast_network_unable, 0).show();
                        break;
                    } else if (((BuddyProfile) c0778b.m3110e()) != null) {
                        this.f12992a.f12523f.setTitle(C4822an.m18254v());
                        break;
                    }
                    break;
            }
        }
    }
}
