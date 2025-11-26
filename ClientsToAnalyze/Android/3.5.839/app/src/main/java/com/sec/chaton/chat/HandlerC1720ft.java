package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1013al;
import com.sec.chaton.EnumC1014am;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2248i;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.ft */
/* loaded from: classes.dex */
class HandlerC1720ft extends Handler {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1716fp f6331a;

    HandlerC1720ft(AlertDialogC1716fp alertDialogC1716fp) {
        this.f6331a = alertDialogC1716fp;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f6331a.f6325e != null) {
            C0778b c0778b = (C0778b) message.obj;
            if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                this.f6331a.f6323c.m8341d();
                C5179v.m19811a(this.f6331a.f6325e, c0778b.m3107b().toString(), 0).show();
                AbstractC4932a.m18733a(this.f6331a.f6325e).mo18740a(this.f6331a.f6323c.getResources().getString(R.string.ams_attention_title)).mo18749b(this.f6331a.f6323c.getResources().getString(R.string.setting_profile_update_status_failed)).mo18755c(this.f6331a.f6323c.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1721fu(this)).mo18741a(this.f6331a.f6323c.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f6331a.f6323c.f5823h.size(); i++) {
                arrayList.add(((C1106c) this.f6331a.f6323c.f5823h.get(i)).m7046a());
            }
            arrayList.add(0, this.f6331a.f6324d.m18658a().toString());
            C2212z.m10068a(new C2212z(), 2, new C2248i(this.f6331a.f6322b, (String[]) arrayList.toArray(new String[0]), 2));
            C0991aa.m6037a().m18962d(C1013al.m6086a(EnumC1014am.ADDED));
        }
    }
}
