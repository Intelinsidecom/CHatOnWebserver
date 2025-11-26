package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0993ac;
import com.sec.chaton.EnumC1005ad;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2250k;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4828at;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.au */
/* loaded from: classes.dex */
class HandlerC1130au extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f4348a;

    HandlerC1130au(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f4348a = buddyEditNickNameFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4348a.f3559b != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                if (this.f4348a.f3568k != null && this.f4348a.f3568k.isShowing()) {
                    this.f4348a.f3568k.dismiss();
                    AbstractC4932a.m18733a(this.f4348a.f3571n).mo18740a(this.f4348a.getResources().getString(R.string.ams_attention_title)).mo18749b(this.f4348a.getResources().getString(R.string.setting_profile_update_status_failed)).mo18755c(this.f4348a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1131av(this)).mo18741a(this.f4348a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                    return;
                }
                return;
            }
            C5179v.m19810a(this.f4348a.f3559b, R.string.buddy_profile_saveprofile_toast_success, 0).show();
            Intent intent = new Intent();
            String strTrim = this.f4348a.f3562e.getText().toString().trim();
            C2212z.m10068a(new C2212z(), 1, new C2250k(this.f4348a.f3560c, strTrim, this.f4348a.f3565h, 2));
            intent.putExtra("PROFILE_BUDDY_RENAME", strTrim);
            C4828at.m18280a(strTrim, this.f4348a.f3565h);
            this.f4348a.f3571n.setResult(-1, intent);
            this.f4348a.f3571n.finish();
            C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.NAME_CHANGED, this.f4348a.f3565h, strTrim));
        }
    }
}
