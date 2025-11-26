package com.sec.chaton.shop;

import android.app.Activity;
import android.os.Handler;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.p097a.AsyncTaskC3437d;
import com.sec.chaton.settings.p096a.p097a.AsyncTaskC3440g;
import com.sec.chaton.settings.p096a.p097a.AsyncTaskC3450q;
import com.sec.chaton.settings.p096a.p097a.AsyncTaskC3453t;
import com.sec.chaton.shop.entrys.DeleteRequestEntry;
import com.sec.chaton.util.C4904y;

/* compiled from: ShopDownloadDelete.java */
/* renamed from: com.sec.chaton.shop.q */
/* loaded from: classes.dex */
public class C3768q {
    /* renamed from: a */
    public void m14156a(DeleteRequestEntry deleteRequestEntry, Activity activity, Handler handler) {
        EnumC2258bd enumC2258bdM14069a = C3733f.m14069a(deleteRequestEntry.itemType);
        if (enumC2258bdM14069a == null) {
            if (C4904y.f17875e) {
                C4904y.m18634a("itemtype is invalid", "ShopDownloadDelete.class");
                return;
            }
            return;
        }
        m14155a(deleteRequestEntry, enumC2258bdM14069a, activity, handler);
    }

    /* renamed from: a */
    private void m14155a(DeleteRequestEntry deleteRequestEntry, EnumC2258bd enumC2258bd, Activity activity, Handler handler) {
        String string = Long.toString(deleteRequestEntry.itemId);
        switch (C3769r.f13514a[enumC2258bd.ordinal()]) {
            case 1:
                AsyncTaskC3437d.m13706a(activity, false, handler, deleteRequestEntry).execute(string);
                break;
            case 2:
                AsyncTaskC3450q.m13733a(activity, false, handler, deleteRequestEntry).execute(string);
                break;
            case 3:
                AsyncTaskC3453t.m13738a(activity, false, handler, deleteRequestEntry).execute(string);
                break;
            case 4:
                AsyncTaskC3440g.m13711a(activity, false, handler, deleteRequestEntry).execute(string);
                break;
        }
    }
}
