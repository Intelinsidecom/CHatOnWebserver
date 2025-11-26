package com.sec.chaton.chat.notification;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: FragmentScreenNotification.java */
/* renamed from: com.sec.chaton.chat.notification.n */
/* loaded from: classes.dex */
class HandlerC1825n extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentScreenNotification f6910a;

    HandlerC1825n(FragmentScreenNotification fragmentScreenNotification) {
        this.f6910a = fragmentScreenNotification;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AbstractC4932a abstractC4932aM8830a;
        C0788l c0788l = (C0788l) ((C1770hp) message.obj).m8779a();
        if (c0788l == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("resultEntry is null", FragmentScreenNotification.f6712b);
                return;
            }
            return;
        }
        if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.END_APP) {
            if (!ExitAppDialogActivity.m2892a()) {
                ExitAppDialogActivity.m2894b();
                return;
            }
            return;
        }
        if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.RESTART_APP && (abstractC4932aM8830a = this.f6910a.m8830a(EnumC0789m.RESTART_APP)) != null) {
            abstractC4932aM8830a.mo18745a().show();
        }
        if (!c0788l.f2172a) {
            int iM3152g = c0788l.m3152g();
            if (iM3152g == 24 || iM3152g == 23 || iM3152g == 21) {
                if (this.f6910a.f6721j != null) {
                    this.f6910a.f6721j.mo9274d();
                }
                this.f6910a.f6715d.setText(EnumC2214ab.m10073a(EnumC2214ab.m10070a(this.f6910a.f6723l), this.f6910a.f6722k, this.f6910a.f6725n, this.f6910a.m8825c()));
                this.f6910a.f6715d.setVisibility(0);
                this.f6910a.f6719h.setVisibility(8);
            }
        }
    }
}
