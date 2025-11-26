package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p016a.p017a.C0274k;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.IOException;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.dk */
/* loaded from: classes.dex */
class HandlerC1042dk extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f4153a;

    HandlerC1042dk(ChatInfoFragment chatInfoFragment) {
        this.f4153a = chatInfoFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws IOException {
        if (this.f4153a.f3740h != null) {
            switch (message.what) {
                case 804:
                    if (((C0274k) message.obj).f858a) {
                        C1335m.m5788b(this.f4153a.f3733U, this.f4153a.f3725M, this.f4153a.f3726N);
                        break;
                    } else {
                        if (this.f4153a.f3724L.isShowing()) {
                            this.f4153a.f3724L.dismiss();
                        }
                        AbstractC3271a.m11494a(this.f4153a.f3740h).mo11495a(R.string.ams_attention_title).mo11506b(R.string.toast_setting_profile_update_failed).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1044dm(this)).mo11507b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC1043dl(this)).mo11511b(true).mo11512b();
                        break;
                    }
                case 805:
                    C0267d c0267d = (C0267d) message.obj;
                    if (this.f4153a.f3724L.isShowing()) {
                        this.f4153a.f3724L.dismiss();
                    }
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        C3641ai.m13210a(this.f4153a.f3740h, R.string.toast_network_unable, 0).show();
                        break;
                    } else {
                        this.f4153a.m5041i();
                        break;
                    }
                    break;
            }
        }
    }
}
