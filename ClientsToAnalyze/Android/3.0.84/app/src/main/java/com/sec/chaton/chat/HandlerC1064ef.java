package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1418i;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.ef */
/* loaded from: classes.dex */
class HandlerC1064ef extends Handler {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1060eb f4182a;

    HandlerC1064ef(AlertDialogC1060eb alertDialogC1060eb) {
        this.f4182a = alertDialogC1060eb;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f4182a.f4176f != null) {
            C0267d c0267d = (C0267d) message.obj;
            if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                this.f4182a.f4173c.m5073d();
                C3641ai.m13211a(this.f4182a.f4176f, c0267d.m1351b().toString(), 0).show();
                AbstractC3271a.m11494a(this.f4182a.f4176f).mo11500a(this.f4182a.f4173c.getResources().getString(R.string.ams_attention_title)).mo11509b(this.f4182a.f4173c.getResources().getString(R.string.setting_profile_update_status_failed)).mo11510b(this.f4182a.f4173c.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1065eg(this)).mo11501a(this.f4182a.f4173c.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f4182a.f4173c.f3767i.size(); i++) {
                arrayList.add(((C0513c) this.f4182a.f4173c.f3767i.get(i)).m3975b());
            }
            arrayList.add(0, this.f4182a.f4175e.m11463a().toString());
            C1379w.m6203a(new C1379w(), 2, new C1418i(this.f4182a.f4172b, (String[]) arrayList.toArray(new String[0]), 2));
            this.f4182a.f4173c.m5073d();
            ((InterfaceC1066eh) this.f4182a.f4173c.getActivity()).mo5065c();
        }
    }
}
