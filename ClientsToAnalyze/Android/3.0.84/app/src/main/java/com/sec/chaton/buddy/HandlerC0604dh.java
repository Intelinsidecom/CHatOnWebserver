package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1418i;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dh */
/* loaded from: classes.dex */
class HandlerC0604dh extends Handler {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0599dc f2596a;

    HandlerC0604dh(AlertDialogC0599dc alertDialogC0599dc) {
        this.f2596a = alertDialogC0599dc;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f2596a.f2581d != null) {
            String strReplace = this.f2596a.f2587j.m11463a().toString().trim().replace(",", "");
            C0267d c0267d = (C0267d) message.obj;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                this.f2596a.m4076e();
                C3641ai.m13211a(this.f2596a.f2581d, c0267d.m1351b().toString(), 0).show();
                AbstractC3271a.m11494a(this.f2596a.f2581d).mo11500a(this.f2596a.f2581d.getResources().getString(R.string.ams_attention_title)).mo11509b(this.f2596a.f2581d.getResources().getString(R.string.setting_profile_update_status_failed)).mo11510b(this.f2596a.f2581d.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0605di(this, strReplace)).mo11501a(this.f2596a.f2581d.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
            } else if (this.f2596a.f2583f.length > 0) {
                C3250y.m11458g("NEW GROUP NAME : " + strReplace, AlertDialogC0599dc.f2578a);
                C3250y.m11458g("MEMBER COUNT  : " + this.f2596a.f2583f.length, AlertDialogC0599dc.f2578a);
                C1379w.m6203a(new C1379w(), 2, new C1418i(this.f2596a.f2580c, strReplace, this.f2596a.f2583f, 2));
            }
        }
    }
}
