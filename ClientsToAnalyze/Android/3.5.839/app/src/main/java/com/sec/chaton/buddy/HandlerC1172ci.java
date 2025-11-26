package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1013al;
import com.sec.chaton.EnumC1014am;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2249j;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ci */
/* loaded from: classes.dex */
class HandlerC1172ci extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4399a;

    HandlerC1172ci(BuddyFragment buddyFragment) {
        this.f4399a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        super.handleMessage(message);
        if (this.f4399a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                if (this.f4399a.f3624aE != null && this.f4399a.f3624aE.isShowing()) {
                    this.f4399a.f3624aE.dismiss();
                }
                C5179v.m19811a(this.f4399a.getActivity(), c0778b.m3107b().toString(), 0).show();
                AbstractC4932a.m18733a(this.f4399a.getActivity()).mo18740a(this.f4399a.getResources().getString(R.string.toast_error)).mo18749b(this.f4399a.getResources().getString(R.string.dev_network_error)).mo18755c(this.f4399a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1173cj(this)).mo18741a(this.f4399a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return;
            }
            C2249j c2249j = new C2249j(this.f4399a.f3770w, Integer.parseInt(this.f4399a.f3706bk.m7046a()));
            this.f4399a.f3622aC.m19614a(this.f4399a.f3671az.m7046a());
            this.f4399a.m6587a(this.f4399a.f3671az.m7046a(), this.f4399a.f3671az.m7051b());
            C2496n.m10794g(this.f4399a.getActivity(), this.f4399a.f3706bk.m7051b());
            C2212z.m10068a(new C2212z(), 0, c2249j);
            if (this.f4399a.f3624aE != null && this.f4399a.f3624aE.isShowing()) {
                this.f4399a.f3624aE.dismiss();
            }
            C5179v.m19810a(this.f4399a.getActivity(), R.string.group_remove_toast_popup, 0).show();
            C0991aa.m6037a().m18962d(C1013al.m6086a(EnumC1014am.REMOVED));
        }
    }
}
