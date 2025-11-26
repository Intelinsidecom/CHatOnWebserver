package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0511a;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ci */
/* loaded from: classes.dex */
class HandlerC0578ci extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2540a;

    HandlerC0578ci(BuddyFragment buddyFragment) {
        this.f2540a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 411:
                C0267d c0267d = (C0267d) message.obj;
                if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.SUCCESS) {
                    String strM10979a = C3159aa.m10962a().m10979a("status_message", "");
                    String strM10979a2 = C3159aa.m10962a().m10979a("Push Name", "");
                    C3250y.m11450b("Me Name : " + strM10979a2, getClass().getSimpleName());
                    if (!this.f2540a.f1806ar && this.f2540a.isAdded()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new C0513c(this.f2540a.getResources().getString(R.string.setting_interaction_me), strM10979a2, strM10979a, "", "", "", false, 0, "", false, 0, 0, 0, 0, 0, 0, 0, false, false, 0, "", 0));
                        try {
                            if (this.f2540a.f1797ai.size() > 0) {
                                this.f2540a.f1797ai.remove(0);
                                if (arrayList.size() > 0) {
                                    this.f2540a.f1797ai.add(0, arrayList);
                                }
                                this.f2540a.m3284a((ArrayList<C0511a>) this.f2540a.f1796ah, (ArrayList<ArrayList<C0513c>>) this.f2540a.f1797ai);
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            C3250y.m11442a("Me group hasn't created, yet", getClass().getSimpleName());
                            return;
                        }
                    }
                }
                break;
        }
    }
}
