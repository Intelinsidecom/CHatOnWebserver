package com.sec.chaton.api;

import android.app.IntentService;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BackgroundRequestService extends IntentService {

    /* renamed from: a */
    private static final String f3313a = BackgroundRequestService.class.getSimpleName();

    /* renamed from: b */
    private static final List<InterfaceC1044d> f3314b = new ArrayList();

    static {
        f3314b.add(new C1043c());
    }

    public BackgroundRequestService() {
        super(f3313a);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        Iterator<InterfaceC1044d> it = f3314b.iterator();
        while (it.hasNext() && !it.next().mo6152a(intent)) {
        }
    }
}
