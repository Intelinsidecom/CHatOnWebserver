package com.sec.chaton;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ExitAppDialogActivity extends Activity {

    /* renamed from: a */
    private int f246a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.exit_app_dialog);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f246a = getIntent().getIntExtra("reason", 0);
        m626c();
    }

    /* renamed from: c */
    private void m626c() {
        C1341p.m4660c("ExitAppDialogActivity initView", null);
        ((Button) findViewById(android.R.id.button1)).setOnClickListener(new ViewOnClickListenerC0247aj(this));
        if (1 == this.f246a) {
            ((TextView) findViewById(R.id.exit_error_content)).setText(R.string.popup_not_enough_memory);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            this.f246a = intent.getIntExtra("reason", 0);
        } else {
            this.f246a = 0;
        }
        m626c();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    /* renamed from: a */
    public static boolean m624a() {
        return C1323bs.m4575a().getBoolean("exit_app_done", false);
    }

    /* renamed from: b */
    public static void m625b() {
        C1341p.m4651a("Exit App. Unauthorized.", (String) null);
        m623a(0);
    }

    /* renamed from: a */
    public static void m623a(int i) {
        C1323bs.m4576a("exit_app_done", (Boolean) true);
        Intent intent = new Intent("com.sec.chaton.ACTION_EXIT_APP");
        intent.putExtra("reason", i);
        LocalBroadcastManager.getInstance(GlobalApplication.m3100a()).sendBroadcast(intent);
    }
}
