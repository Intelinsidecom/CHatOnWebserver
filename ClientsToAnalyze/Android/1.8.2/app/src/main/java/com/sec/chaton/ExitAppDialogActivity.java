package com.sec.chaton;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Button;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* loaded from: classes.dex */
public class ExitAppDialogActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        setContentView(R.layout.exit_app_dialog);
        m582c();
    }

    /* renamed from: c */
    private void m582c() {
        C1786r.m6063c("ExitAppDialogActivity initView", null);
        ((Button) findViewById(android.R.id.button1)).setOnClickListener(new ViewOnClickListenerC0834k(this));
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        m582c();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    /* renamed from: a */
    public static boolean m580a() {
        return C1789u.m6075a().getBoolean("exit_app_done", false);
    }

    /* renamed from: b */
    public static void m581b() {
        C1786r.m6054a("Exit App. Unauthorized.", (String) null);
        C1789u.m6076a("exit_app_done", (Boolean) true);
        LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).sendBroadcast(new Intent("com.sec.chaton.ACTION_EXIT_APP"));
    }
}
