package com.sec.chaton;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.C1092fg;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p025d.p026a.C1221cv;
import com.sec.chaton.p025d.p026a.C1230dd;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.h */
/* loaded from: classes.dex */
class HandlerC1497h extends Handler {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f5533a;

    HandlerC1497h(AdminMenu adminMenu) {
        this.f5533a = adminMenu;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int iM1365f;
        C0272i c0272i = (C0272i) ((C1092fg) message.obj).m5376a();
        if (c0272i != null) {
            if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.END_APP) {
                C3250y.m11453c("result code:" + c0272i.m1365f(), "AdminMenu");
                return;
            }
            if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.RESTART_APP) {
                C3250y.m11453c("result code:" + c0272i.m1365f(), "AdminMenu");
                return;
            }
            if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.RESET_BY_WEB) {
                C3250y.m11453c("result code:" + c0272i.m1365f(), "AdminMenu");
                return;
            }
            if (!c0272i.f858a && (((iM1365f = c0272i.m1365f()) == 24 || iM1365f == 23 || iM1365f == 21) && this.f5533a.f640M != null)) {
                String strM5906o = this.f5533a.f640M.m5906o();
                this.f5533a.f640M.m5901j();
                this.f5533a.f640M.m5880a(strM5906o, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
            }
            switch (message.what) {
                case 0:
                    String strM5550a = "";
                    if (!c0272i.f858a) {
                        if (this.f5533a.f641N < this.f5533a.f642O) {
                            this.f5533a.m1110g();
                            break;
                        } else {
                            this.f5533a.f631D.dismiss();
                            C3641ai.m13211a(this.f5533a.f630C, this.f5533a.f641N + "chat rooms maked ...", 0).show();
                            break;
                        }
                    } else {
                        if (c0272i instanceof C1221cv) {
                            strM5550a = ((C1221cv) c0272i).m5550a();
                        } else if (c0272i instanceof C1230dd) {
                            strM5550a = ((C1230dd) c0272i).f4766d;
                        }
                        this.f5533a.f640M.m5894c(strM5550a);
                        if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.SUCCESS_RECEIVER_ERROR) {
                            C3250y.m11453c("result code:" + c0272i.m1365f(), "AdminMenu");
                        }
                        AdminMenu.m1090A(this.f5533a);
                        if (this.f5533a.f641N < this.f5533a.f642O) {
                            this.f5533a.f631D.setMessage("Make Dummy ChatRoom " + (this.f5533a.f641N + 1));
                            this.f5533a.m1110g();
                            break;
                        } else {
                            this.f5533a.f631D.dismiss();
                            C3641ai.m13211a(this.f5533a.f630C, this.f5533a.f641N + "chat rooms maked ...", 0).show();
                            break;
                        }
                    }
            }
        }
    }
}
