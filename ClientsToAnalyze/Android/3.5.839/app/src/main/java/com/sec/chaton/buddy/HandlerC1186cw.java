package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1104a;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cw */
/* loaded from: classes.dex */
class HandlerC1186cw extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4414a;

    HandlerC1186cw(BuddyFragment buddyFragment) {
        this.f4414a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        switch (message.what) {
            case 411:
                C0778b c0778b = (C0778b) message.obj;
                if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                    String strM18121a = C4809aa.m18104a().m18121a("status_message", "");
                    String strM18121a2 = C4809aa.m18104a().m18121a("Push Name", "");
                    C4904y.m18639b("Me Name : " + strM18121a2, getClass().getSimpleName());
                    if (!this.f4414a.f3623aD && this.f4414a.isAdded()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new C1106c(this.f4414a.getResources().getString(R.string.setting_interaction_me), strM18121a2, strM18121a, "", "", "", false, 0, "", false, 0, 0, 0, 0, 0, 0, 0, false, false, 0, "", 0));
                        try {
                            if (this.f4414a.f3666au.size() > 0) {
                                this.f4414a.f3666au.remove(0);
                                if (arrayList.size() > 0) {
                                    this.f4414a.f3666au.add(0, arrayList);
                                }
                                this.f4414a.m6371a((ArrayList<C1104a>) this.f4414a.f3665at, (ArrayList<ArrayList<C1106c>>) this.f4414a.f3666au);
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            C4904y.m18634a("Me group hasn't created, yet", getClass().getSimpleName());
                            return;
                        }
                    }
                }
                break;
        }
    }
}
