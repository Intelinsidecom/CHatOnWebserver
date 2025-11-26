package com.sec.chaton.smsplugin.spam;

import android.database.Cursor;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bc */
/* loaded from: classes.dex */
class C3999bc extends Thread {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14440a;

    private C3999bc(SetupSpamNumberList setupSpamNumberList) {
        this.f14440a = setupSpamNumberList;
    }

    /* synthetic */ C3999bc(SetupSpamNumberList setupSpamNumberList, HandlerC3982am handlerC3982am) {
        this(setupSpamNumberList);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        Message messageObtainMessage = this.f14440a.f14364n.obtainMessage();
        messageObtainMessage.what = 100;
        Cursor cursor = null;
        int i = (C3847e.m14672ad() && this.f14440a.f14370u == 0) ? 1 : 0;
        C3890m.m14996b("LOG_TAG", "QueryThread start: " + this);
        int i2 = i;
        boolean z2 = false;
        while (i2 < this.f14440a.f14366p.size()) {
            try {
                String strReplaceAll = C3782a.m14207a(((C4017bu) this.f14440a.f14366p.get(i2)).m15458c()).replaceAll("[\\s\\-()]", "");
                if (((C4017bu) this.f14440a.f14366p.get(i2)).m15458c().equals(strReplaceAll)) {
                    z2 = true;
                }
                if (z2) {
                    if (this.f14440a.f14345B.equals(((C4017bu) this.f14440a.f14366p.get(i2)).m15460e())) {
                        z = false;
                    } else {
                        ((C4017bu) this.f14440a.f14366p.get(i2)).m15455a(this.f14440a.getString(R.string.no_name));
                        z = false;
                    }
                } else {
                    ((C4017bu) this.f14440a.f14366p.get(i2)).m15455a(strReplaceAll);
                    z = z2;
                }
                i2++;
                z2 = z;
            } catch (Exception e) {
                C3890m.m14996b("Mms/SetupSpamNumberList", "Exception is  " + e);
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
        this.f14440a.f14364n.sendMessage(messageObtainMessage);
        C3890m.m14996b("Mms/SetupSpamNumberList", "QueryThread end: " + this);
    }
}
