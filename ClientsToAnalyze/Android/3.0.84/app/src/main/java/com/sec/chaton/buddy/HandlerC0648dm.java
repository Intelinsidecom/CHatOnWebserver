package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1417h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: BuddyGroupMemberEditFragment.java */
/* renamed from: com.sec.chaton.buddy.dm */
/* loaded from: classes.dex */
class HandlerC0648dm extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupMemberEditFragment f2868a;

    HandlerC0648dm(BuddyGroupMemberEditFragment buddyGroupMemberEditFragment) {
        this.f2868a = buddyGroupMemberEditFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f2868a.f1900e != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                if (this.f2868a.f1907l != null && this.f2868a.f1907l.isShowing()) {
                    this.f2868a.f1907l.dismiss();
                }
                C3641ai.m13211a(this.f2868a.f1904i, c0267d.m1351b().toString(), 0).show();
                AbstractC3271a.m11494a(this.f2868a.f1904i).mo11509b(this.f2868a.getResources().getString(R.string.setting_profile_update_status_failed)).mo11510b(this.f2868a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0649dn(this)).mo11501a(this.f2868a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return;
            }
            C1379w.m6203a(new C1379w(), 0, new C1417h(this.f2868a.f1897b, this.f2868a.f1898c.m3960a(), this.f2868a.f1901f, true));
            if (this.f2868a.f1907l != null && this.f2868a.f1907l.isShowing()) {
                this.f2868a.f1907l.dismiss();
            }
            C3641ai.m13210a(this.f2868a.f1904i, R.string.buddy_profile_saveprofile_toast_success, 0).show();
            this.f2868a.f1904i.finish();
        }
    }
}
