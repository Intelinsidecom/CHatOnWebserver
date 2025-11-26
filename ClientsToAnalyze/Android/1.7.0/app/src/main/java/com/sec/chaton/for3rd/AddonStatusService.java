package com.sec.chaton.for3rd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.sec.chaton.coolots.CreateAccountStartService;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p013a.p014a.C0159bh;

/* loaded from: classes.dex */
public class AddonStatusService extends Service {

    /* renamed from: a */
    private static final String f2388a = AddonStatusService.class.getSimpleName();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i(f2388a, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.i(f2388a, "onDestroy");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Log.i(f2388a, "onStart " + i);
        String stringExtra = intent.getStringExtra("package_name");
        if (stringExtra != null) {
            boolean booleanExtra = intent.getBooleanExtra("is_installed", false);
            intent.getBooleanExtra("is_removed", false);
            boolean booleanExtra2 = intent.getBooleanExtra("need_update", false);
            Log.i(f2388a, "package=" + stringExtra + ", installed=" + booleanExtra);
            if ("com.coolots.chaton".equals(stringExtra)) {
                if (booleanExtra) {
                    startService(new Intent(this, (Class<?>) CreateAccountStartService.class));
                }
                HandlerC0707d handlerC0707d = new HandlerC0707d(this);
                int i2 = (booleanExtra || booleanExtra2) ? 1 : 0;
                String[] strArr = {"voip", "vcall", "call"};
                int[] iArr = new int[3];
                iArr[0] = i2;
                iArr[1] = C0159bh.m695h() ? 1 : 0;
                iArr[2] = C0159bh.m694g() ? 1 : 0;
                new C0202ao(handlerC0707d).m759a(strArr.length, strArr, iArr, false);
            }
            stopSelf();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
