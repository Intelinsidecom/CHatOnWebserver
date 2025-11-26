package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1013al;
import com.sec.chaton.EnumC1014am;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2248i;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.aq */
/* loaded from: classes.dex */
class HandlerC1126aq extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f4344a;

    HandlerC1126aq(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f4344a = buddyEditNickNameFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4344a.f3559b != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                if (this.f4344a.f3568k != null && this.f4344a.f3568k.isShowing()) {
                    this.f4344a.f3568k.dismiss();
                }
                C5179v.m19811a(this.f4344a.f3559b, c0778b.m3107b().toString(), 0).show();
                AbstractC4932a.m18733a(this.f4344a.f3571n).mo18740a(this.f4344a.getResources().getString(R.string.ams_attention_title)).mo18749b(this.f4344a.getResources().getString(R.string.setting_profile_update_status_failed)).mo18755c(this.f4344a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1127ar(this)).mo18741a(this.f4344a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return;
            }
            C4904y.m18639b("group rename to " + this.f4344a.f3562e.getText().toString().trim(), getClass().getSimpleName());
            Intent intent = new Intent(BuddyFragment.f3588n);
            intent.putExtra(BuddyFragment.f3588n, "PROFILE_GROUP_RENAME");
            this.f4344a.getActivity().sendBroadcast(intent);
            C2212z.m10068a(new C2212z(), 2, new C2248i(this.f4344a.f3560c, this.f4344a.f3562e.getText().toString().trim(), 3));
            C2496n.m10760a(this.f4344a.f3559b, this.f4344a.f3566i, this.f4344a.f3562e.getText().toString().trim());
            C2496n.m10794g(this.f4344a.f3571n, this.f4344a.f3566i);
            if (this.f4344a.f3568k != null && this.f4344a.f3568k.isShowing()) {
                this.f4344a.f3568k.dismiss();
            }
            String strTrim = this.f4344a.f3562e.getText().toString().trim();
            Bundle bundle = new Bundle();
            Intent intent2 = this.f4344a.f3571n.getIntent();
            bundle.putString("PROFILE_GROUP_RENAME", strTrim);
            intent2.putExtras(bundle);
            this.f4344a.f3571n.setResult(-1, intent2);
            this.f4344a.f3571n.finish();
            C0991aa.m6037a().m18962d(C1013al.m6087a(EnumC1014am.NAME_CHANGED, this.f4344a.f3565h, strTrim));
        }
    }
}
