package com.sec.chaton.hugefiletransfer;

import android.app.IntentService;
import android.content.Intent;
import com.sec.chaton.p057e.C2218af;
import com.sec.chaton.p057e.C2296p;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class HugeFileDbArrangeService extends IntentService {

    /* renamed from: a */
    private static final String f8474a = HugeFileDbArrangeService.class.getSimpleName();

    public HugeFileDbArrangeService() {
        super(f8474a);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        long jCurrentTimeMillis = System.currentTimeMillis() - 2592000000L;
        if (C4904y.f17872b) {
            C4904y.m18639b("currentTimeMillis: " + jCurrentTimeMillis, f8474a);
        }
        int iDelete = getContentResolver().delete(C2218af.f7940a, "upload_id < ? ", new String[]{String.valueOf(jCurrentTimeMillis)});
        int iDelete2 = getContentResolver().delete(C2296p.f8206a, "upload_id < ? ", new String[]{String.valueOf(jCurrentTimeMillis)});
        if (C4904y.f17872b) {
            C4904y.m18639b("delete uploadCount: " + iDelete + ", mappingCount: " + iDelete2, f8474a);
        }
    }
}
