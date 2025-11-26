package com.sec.chaton.api;

import android.app.IntentService;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BackgroundRequestService extends IntentService {

    /* renamed from: a */
    private static final String f1501a = BackgroundRequestService.class.getSimpleName();

    /* renamed from: b */
    private static final List<InterfaceC0441b> f1502b = new ArrayList();

    static {
        f1502b.add(new C0439a());
    }

    public BackgroundRequestService() {
        super(f1501a);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        Iterator<InterfaceC0441b> it = f1502b.iterator();
        while (it.hasNext() && !it.next().mo3065a(intent)) {
        }
    }
}
