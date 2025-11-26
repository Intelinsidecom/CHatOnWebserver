package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3178at;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.ay */
/* loaded from: classes.dex */
class HandlerC0540ay extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f2499a;

    HandlerC0540ay(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f2499a = buddyEditNickNameFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f2499a.f1709b != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                if (this.f2499a.f1717j != null && this.f2499a.f1717j.isShowing()) {
                    this.f2499a.f1717j.dismiss();
                    AbstractC3271a.m11494a(this.f2499a.f1720m).mo11500a(this.f2499a.getResources().getString(R.string.ams_attention_title)).mo11509b(this.f2499a.getResources().getString(R.string.setting_profile_update_status_failed)).mo11510b(this.f2499a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0541az(this)).mo11501a(this.f2499a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                    return;
                }
                return;
            }
            C3641ai.m13210a(this.f2499a.f1709b, R.string.buddy_profile_saveprofile_toast_success, 0).show();
            new Bundle();
            Intent intent = new Intent();
            String strTrim = this.f2499a.f1712e.getText().toString().trim();
            intent.putExtra("PROFILE_BUDDY_RENAME", strTrim);
            C3178at.m11107a(strTrim, this.f2499a.f1714g);
            this.f2499a.f1720m.setResult(-1, intent);
            this.f2499a.f1720m.finish();
        }
    }
}
