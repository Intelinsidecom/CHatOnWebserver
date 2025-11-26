package com.sec.chaton.hide;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.widget.C5179v;

/* compiled from: HideBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.d */
/* loaded from: classes.dex */
class HandlerC2369d extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2366a f8444a;

    HandlerC2369d(C2366a c2366a) {
        this.f8444a = c2366a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0778b c0778b = (C0778b) message.obj;
        switch (message.what) {
            case 704:
                if (this.f8444a.f8438g != null && this.f8444a.f8438g.isShowing() && !((Activity) this.f8444a.f8434c).isFinishing()) {
                    this.f8444a.f8438g.dismiss();
                }
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    C5179v.m19810a(this.f8444a.f8434c, R.string.dev_network_error, 0).show();
                    break;
                } else {
                    for (int i = 0; i < this.f8444a.f8432a.size(); i++) {
                        if (this.f8444a.f8436e.equals(this.f8444a.f8432a.get(i).f3484a)) {
                            C5179v.m19811a(this.f8444a.f8434c, this.f8444a.f8434c.getResources().getString(R.string.hide_contacts_button_shown), 0).show();
                            this.f8444a.f8432a.remove(i);
                        }
                    }
                    this.f8444a.notifyDataSetChanged();
                    this.f8444a.f8439h.mo10355a(c0778b.m3107b());
                    break;
                }
                break;
        }
    }
}
