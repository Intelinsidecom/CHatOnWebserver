package com.sec.chaton;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p055d.p056a.C1985dd;
import com.sec.chaton.p055d.p056a.C2000ds;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.q */
/* loaded from: classes.dex */
class HandlerC3118q extends Handler {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f11465a;

    HandlerC3118q(AdminMenu adminMenu) {
        this.f11465a = adminMenu;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int iM3152g;
        C0788l c0788l = (C0788l) ((C1770hp) message.obj).m8779a();
        if (c0788l != null) {
            if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.END_APP) {
                C4904y.m18641c("result code:" + c0788l.m3152g(), "AdminMenu");
                return;
            }
            if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.RESTART_APP) {
                C4904y.m18641c("result code:" + c0788l.m3152g(), "AdminMenu");
                return;
            }
            if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.RESET_BY_WEB) {
                C4904y.m18641c("result code:" + c0788l.m3152g(), "AdminMenu");
                return;
            }
            if (!c0788l.f2172a && (((iM3152g = c0788l.m3152g()) == 24 || iM3152g == 23 || iM3152g == 21) && this.f11465a.f1895af != null)) {
                String strM9657p = this.f11465a.f1895af.m9657p();
                this.f11465a.f1895af.mo9274d();
                this.f11465a.f1895af.mo9252a(strM9657p, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
            }
            switch (message.what) {
                case 0:
                    String strM9136a = "";
                    if (!c0788l.f2172a) {
                        if (this.f11465a.f1896ag < this.f11465a.f1897ah) {
                            this.f11465a.m2857l();
                            break;
                        } else {
                            this.f11465a.f1885V.dismiss();
                            C5179v.m19811a(this.f11465a.f1884U, this.f11465a.f1896ag + "chat rooms maked ...", 0).show();
                            break;
                        }
                    } else {
                        if (c0788l instanceof C1985dd) {
                            strM9136a = ((C1985dd) c0788l).m9136a();
                        } else if (c0788l instanceof C2000ds) {
                            strM9136a = ((C2000ds) c0788l).f7352d;
                        }
                        this.f11465a.f1895af.mo9244a(strM9136a);
                        if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.SUCCESS_RECEIVER_ERROR) {
                            C4904y.m18641c("result code:" + c0788l.m3152g(), "AdminMenu");
                        }
                        AdminMenu.m2829H(this.f11465a);
                        if (this.f11465a.f1896ag < this.f11465a.f1897ah) {
                            this.f11465a.f1885V.setMessage("Make Dummy ChatRoom " + (this.f11465a.f1896ag + 1));
                            this.f11465a.m2857l();
                            break;
                        } else {
                            this.f11465a.f1885V.dismiss();
                            C5179v.m19811a(this.f11465a.f1884U, this.f11465a.f1896ag + "chat rooms maked ...", 0).show();
                            break;
                        }
                    }
            }
        }
    }
}
