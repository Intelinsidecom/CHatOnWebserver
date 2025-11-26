package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1013al;
import com.sec.chaton.EnumC1014am;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2247h;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupMemberEditFragment.java */
/* renamed from: com.sec.chaton.buddy.eg */
/* loaded from: classes.dex */
class HandlerC1273eg extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupMemberEditFragment f4807a;

    HandlerC1273eg(BuddyGroupMemberEditFragment buddyGroupMemberEditFragment) {
        this.f4807a = buddyGroupMemberEditFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4807a.f3778e != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                if (this.f4807a.f3784k != null && this.f4807a.f3784k.isShowing()) {
                    this.f4807a.f3784k.dismiss();
                }
                C5179v.m19811a(this.f4807a.f3782i, c0778b.m3107b().toString(), 0).show();
                AbstractC4932a.m18733a(this.f4807a.f3782i).mo18749b(this.f4807a.getResources().getString(R.string.setting_profile_update_status_failed)).mo18755c(this.f4807a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1274eh(this)).mo18741a(this.f4807a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return;
            }
            C2212z.m10068a(new C2212z(), 0, new C2247h(this.f4807a.f3775b, this.f4807a.f3776c.m7034a(), this.f4807a.f3779f, true));
            if (this.f4807a.f3784k != null && this.f4807a.f3784k.isShowing()) {
                this.f4807a.f3784k.dismiss();
            }
            C5179v.m19810a(this.f4807a.f3782i, R.string.buddy_profile_saveprofile_toast_success, 0).show();
            C0991aa.m6037a().m18962d(C1013al.m6086a(EnumC1014am.MEMBER_CHANGED));
            this.f4807a.f3782i.finish();
        }
    }
}
