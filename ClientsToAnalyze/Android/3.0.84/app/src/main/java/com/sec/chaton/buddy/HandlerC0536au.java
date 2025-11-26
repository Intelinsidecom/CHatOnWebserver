package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1418i;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.au */
/* loaded from: classes.dex */
class HandlerC0536au extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f2495a;

    HandlerC0536au(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f2495a = buddyEditNickNameFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        super.handleMessage(message);
        if (this.f2495a.f1709b != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                if (this.f2495a.f1717j != null && this.f2495a.f1717j.isShowing()) {
                    this.f2495a.f1717j.dismiss();
                }
                C3641ai.m13211a(this.f2495a.f1709b, c0267d.m1351b().toString(), 0).show();
                AbstractC3271a.m11494a(this.f2495a.f1720m).mo11500a(this.f2495a.getResources().getString(R.string.ams_attention_title)).mo11509b(this.f2495a.getResources().getString(R.string.setting_profile_update_status_failed)).mo11510b(this.f2495a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0537av(this)).mo11501a(this.f2495a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return;
            }
            C3250y.m11450b("group rename to " + this.f2495a.f1712e.getText().toString().trim(), getClass().getSimpleName());
            C1379w.m6203a(new C1379w(), 2, new C1418i(this.f2495a.f1710c, this.f2495a.f1712e.getText().toString().trim(), 3));
            C3205bt.m11182a(this.f2495a.f1709b).m11217a(this.f2495a.f1715h, this.f2495a.f1712e.getText().toString().trim());
            C3205bt.m11182a(this.f2495a.f1709b).m11219a(this.f2495a.f1715h, true);
            if (this.f2495a.f1717j != null && this.f2495a.f1717j.isShowing()) {
                this.f2495a.f1717j.dismiss();
            }
            this.f2495a.f1712e.getText().toString().trim();
            Bundle bundle = new Bundle();
            Intent intent = this.f2495a.f1720m.getIntent();
            bundle.putString("PROFILE_GROUP_RENAME", this.f2495a.f1712e.getText().toString().trim());
            intent.putExtras(bundle);
            this.f2495a.f1720m.setResult(-1, intent);
            this.f2495a.f1720m.finish();
        }
    }
}
