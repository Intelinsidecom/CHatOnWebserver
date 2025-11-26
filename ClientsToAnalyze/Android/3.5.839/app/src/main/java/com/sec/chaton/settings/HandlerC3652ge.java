package com.sec.chaton.settings;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetPrivacyList;
import com.sec.chaton.p065io.entry.inner.PrivacyList;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.widget.C5179v;

/* compiled from: SuggestionsActivity.java */
/* renamed from: com.sec.chaton.settings.ge */
/* loaded from: classes.dex */
class HandlerC3652ge extends Handler {

    /* renamed from: a */
    final /* synthetic */ SuggestionsActivity f13226a;

    HandlerC3652ge(SuggestionsActivity suggestionsActivity) {
        this.f13226a = suggestionsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f13226a.f12828a != null) {
            if (this.f13226a.f12834g != null) {
                this.f13226a.f12834g.dismiss();
            }
            switch (message.what) {
                case 322:
                    C0778b c0778b = (C0778b) message.obj;
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        if (this.f13226a.f12834g != null) {
                            this.f13226a.f12834g.dismiss();
                        }
                        C5179v.m19811a(this.f13226a.f12828a, this.f13226a.getResources().getString(R.string.dev_network_error), 0).show();
                        break;
                    } else {
                        GetPrivacyList getPrivacyList = (GetPrivacyList) c0778b.m3110e();
                        if (getPrivacyList != null) {
                            this.f13226a.f12835h = getPrivacyList.privacy;
                            for (int i = 0; i < this.f13226a.f12835h.size(); i++) {
                                this.f13226a.m13683a(((PrivacyList) this.f13226a.f12835h.get(i)).name, ((PrivacyList) this.f13226a.f12835h.get(i))._value);
                            }
                            if (this.f13226a.f12834g != null) {
                                this.f13226a.f12834g.dismiss();
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
