package com.sec.chaton;

import android.text.TextUtils;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.util.C4904y;
import com.sec.common.p130e.InterfaceC4995d;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ej */
/* loaded from: classes.dex */
final class C2316ej {

    /* renamed from: a */
    final /* synthetic */ TabActivity f8239a;

    private C2316ej(TabActivity tabActivity) {
        this.f8239a = tabActivity;
    }

    /* synthetic */ C2316ej(TabActivity tabActivity, C1891ct c1891ct) {
        this(tabActivity);
    }

    @InterfaceC4995d
    public void onUserUnauthorized(C1067bg c1067bg) {
        this.f8239a.startActivity(ExitAppDialogActivity.m2890a(this.f8239a, c1067bg.f3362a));
    }

    @InterfaceC4995d
    public void UnreadMessageCountChanged(C1066bf c1066bf) {
        if (!TextUtils.isEmpty(c1066bf.f3360a) && C1828q.f6913a.equals(c1066bf.f3360a)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("!! Receive Event !! UnreadMessageCountChanged. Do query", TabActivity.f2029t);
            }
            if (this.f8239a.f2032A) {
                this.f8239a.f2033B = true;
                this.f8239a.f2036E = true;
            } else {
                this.f8239a.f2042K.startQuery(2, null, C2299s.m10205r(), null, "inbox_unread_count > 0 OR sms_unread_count > 0", null, null);
            }
        }
    }
}
