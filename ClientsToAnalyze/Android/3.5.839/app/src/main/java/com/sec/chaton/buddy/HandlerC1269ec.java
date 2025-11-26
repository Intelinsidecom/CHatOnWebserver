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
import com.sec.chaton.p057e.p059b.C2248i;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.ec */
/* loaded from: classes.dex */
class HandlerC1269ec extends Handler {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1262dw f4802a;

    HandlerC1269ec(AlertDialogC1262dw alertDialogC1262dw) {
        this.f4802a = alertDialogC1262dw;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4802a.f4785d != null) {
            String strReplace = this.f4802a.f4791j.m18658a().toString().trim().replace(",", "");
            C0778b c0778b = (C0778b) message.obj;
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                this.f4802a.m7426e();
                C5179v.m19811a(this.f4802a.f4785d, c0778b.m3107b().toString(), 0).show();
                AbstractC4932a.m18733a(this.f4802a.f4785d).mo18740a(this.f4802a.f4785d.getResources().getString(R.string.ams_attention_title)).mo18749b(this.f4802a.f4785d.getResources().getString(R.string.setting_profile_update_status_failed)).mo18755c(this.f4802a.f4785d.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1270ed(this, strReplace)).mo18741a(this.f4802a.f4785d.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
            } else if (this.f4802a.f4787f.length > 0) {
                C4904y.m18639b("NEW GROUP NAME : " + strReplace, AlertDialogC1262dw.f4782a);
                C4904y.m18639b("MEMBER COUNT  : " + this.f4802a.f4787f.length, AlertDialogC1262dw.f4782a);
                C2212z.m10068a(new C2212z(), 2, new C2248i(this.f4802a.f4784c, strReplace, this.f4802a.f4787f, 2));
                C0991aa.m6037a().m18962d(C1013al.m6086a(EnumC1014am.ADDED));
            }
        }
    }
}
