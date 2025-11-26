package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1419j;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3205bt;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bw */
/* loaded from: classes.dex */
class HandlerC0565bw extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2527a;

    HandlerC0565bw(BuddyFragment buddyFragment) {
        this.f2527a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        super.handleMessage(message);
        if (this.f2527a.getActivity() != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                if (this.f2527a.f1807as != null && this.f2527a.f1807as.isShowing()) {
                    this.f2527a.f1807as.dismiss();
                }
                C3641ai.m13211a(this.f2527a.getActivity(), c0267d.m1351b().toString(), 0).show();
                AbstractC3271a.m11494a(this.f2527a.getActivity()).mo11500a(this.f2527a.getResources().getString(R.string.toast_error)).mo11509b(this.f2527a.getResources().getString(R.string.dev_network_error)).mo11510b(this.f2527a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0566bx(this)).mo11501a(this.f2527a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return;
            }
            C1419j c1419j = new C1419j(this.f2527a.f1887r, Integer.parseInt(this.f2527a.f1786aX.m3975b()));
            C3205bt.m11182a(this.f2527a.getActivity()).m11219a(this.f2527a.f1786aX.m3976c(), true);
            C1379w.m6203a(new C1379w(), -1, c1419j);
            if (this.f2527a.f1807as != null && this.f2527a.f1807as.isShowing()) {
                this.f2527a.f1807as.dismiss();
            }
            C3641ai.m13210a(this.f2527a.getActivity(), R.string.trunk_toast_deleted, 0).show();
        }
    }
}
