package com.sec.chaton.shop;

import android.app.Activity;
import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.shop.entrys.DownloadRequestEntry;
import com.sec.chaton.util.C4873ck;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: DownloadExecutive.java */
/* renamed from: com.sec.chaton.shop.l */
/* loaded from: classes.dex */
public class C3763l {
    /* renamed from: a */
    public void m14146a(DownloadRequestEntry downloadRequestEntry, Activity activity, Handler handler) {
        if (!C4873ck.m18504e()) {
            AbstractC4932a.m18733a(activity).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
        }
        EnumC2258bd enumC2258bdM14069a = C3733f.m14069a(downloadRequestEntry.itemType);
        if (enumC2258bdM14069a != null) {
            switch (C3764m.f13504a[enumC2258bdM14069a.ordinal()]) {
                case 1:
                    new C3765n(activity, downloadRequestEntry, handler);
                    break;
                case 2:
                    new C3726aq(activity, downloadRequestEntry, handler);
                    break;
                case 3:
                    new C3770s(activity, downloadRequestEntry, handler);
                    break;
                case 4:
                    new C3723an(activity, downloadRequestEntry, handler);
                    break;
            }
        }
    }
}
