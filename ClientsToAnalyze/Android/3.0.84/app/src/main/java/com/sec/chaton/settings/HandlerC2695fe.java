package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetPrivacyList;
import com.sec.chaton.p035io.entry.inner.PrivacyList;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.widget.C3641ai;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.fe */
/* loaded from: classes.dex */
class HandlerC2695fe extends Handler {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f9991a;

    HandlerC2695fe(SuggestionsActivity suggestionsActivity) {
        this.f9991a = suggestionsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f9991a.f9253a != null) {
            if (this.f9991a.f9261i != null) {
                this.f9991a.f9261i.dismiss();
            }
            switch (message.what) {
                case 322:
                    C0267d c0267d = (C0267d) message.obj;
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        if (this.f9991a.f9261i != null) {
                            this.f9991a.f9261i.dismiss();
                        }
                        C3641ai.m13211a(this.f9991a.f9253a, this.f9991a.getResources().getString(R.string.dev_network_error), 0).show();
                        break;
                    } else {
                        GetPrivacyList getPrivacyList = (GetPrivacyList) c0267d.m1354e();
                        if (getPrivacyList != null) {
                            this.f9991a.f9262j = getPrivacyList.privacy;
                            for (int i = 0; i < this.f9991a.f9262j.size(); i++) {
                                this.f9991a.m9195a(((PrivacyList) this.f9991a.f9262j.get(i)).name, ((PrivacyList) this.f9991a.f9262j.get(i))._value);
                            }
                            if (this.f9991a.f9261i != null) {
                                this.f9991a.f9261i.dismiss();
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
