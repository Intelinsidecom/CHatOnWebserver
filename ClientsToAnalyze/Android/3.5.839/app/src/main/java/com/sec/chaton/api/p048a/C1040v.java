package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: UpdateNotificationCountLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.v */
/* loaded from: classes.dex */
public class C1040v extends AbstractC1019a {

    /* renamed from: c */
    public static String f3332c = "request_discount_notification";

    /* renamed from: d */
    private final String f3333d = getClass().getSimpleName();

    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        if (intent.hasExtra(f3332c)) {
            int iIntValue = C4809aa.m18104a().m18120a("updates_notification_count", (Integer) 1).intValue();
            if (C4904y.f17873c) {
                C4904y.m18641c("update noti count:" + (iIntValue - 1), this.f3333d);
            }
            C4809aa.m18104a().m18126b("updates_notification_count", Integer.valueOf(iIntValue - 1));
            return false;
        }
        return false;
    }
}
