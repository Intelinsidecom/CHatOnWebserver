package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.fh */
/* loaded from: classes.dex */
class HandlerC2698fh extends Handler {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f9994a;

    HandlerC2698fh(SuggestionsActivity suggestionsActivity) {
        this.f9994a = suggestionsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9994a.f9253a != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                try {
                    this.f9994a.f9261i.dismiss();
                } catch (Exception e) {
                    C3250y.m11442a("Exception occurred while trying to dismiss progress dialog", getClass().getSimpleName());
                }
                int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                if (-3 != iM6733a && -2 != iM6733a) {
                    C3641ai.m13210a(this.f9994a.f9253a, R.string.toast_network_unable, 0).show();
                    return;
                }
                return;
            }
            if (this.f9994a.f9256d.m10977a("recomned_receive", (Boolean) true).booleanValue()) {
                this.f9994a.f9254b = true;
                this.f9994a.f9256d.m10983b("recomned_receive", (Boolean) true);
            } else {
                this.f9994a.f9254b = false;
                this.f9994a.f9256d.m10983b("recomned_receive", (Boolean) false);
            }
            this.f9994a.f9259g.setChecked(this.f9994a.f9254b);
            try {
                this.f9994a.f9261i.dismiss();
            } catch (Exception e2) {
                C3250y.m11442a("Exception occurred while trying to dismiss progress dialog", getClass().getSimpleName());
            }
            C3641ai.m13211a(this.f9994a.f9253a, this.f9994a.getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
        }
    }
}
