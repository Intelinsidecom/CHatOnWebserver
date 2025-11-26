package com.sec.chaton.for3rd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.sec.chaton.coolots.CreateAccountStartService;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p015d.p016a.C0577br;

/* loaded from: classes.dex */
public class AddonStatusService extends Service {

    /* renamed from: a */
    private static final String f2741a = AddonStatusService.class.getSimpleName();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i(f2741a, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.i(f2741a, "onDestroy");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Log.i(f2741a, "onStart " + i);
        String stringExtra = intent.getStringExtra("package_name");
        if (stringExtra != null) {
            boolean booleanExtra = intent.getBooleanExtra("is_installed", false);
            intent.getBooleanExtra("is_removed", false);
            boolean booleanExtra2 = intent.getBooleanExtra("need_update", false);
            Log.i(f2741a, "package=" + stringExtra + ", installed=" + booleanExtra);
            if ("com.coolots.chaton".equals(stringExtra)) {
                if (booleanExtra) {
                    startService(new Intent(this, (Class<?>) CreateAccountStartService.class));
                }
                HandlerC0744a handlerC0744a = new HandlerC0744a(this);
                int i2 = (booleanExtra || booleanExtra2) ? 1 : 0;
                String[] strArr = {"voip", "vcall", "call"};
                int[] iArr = new int[3];
                iArr[0] = i2;
                iArr[1] = C0577br.m2770i() ? 1 : 0;
                iArr[2] = C0577br.m2769h() ? 1 : 0;
                new C0633e(handlerC0744a).m2856a(strArr.length, strArr, iArr, false);
            }
            stopSelf();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
