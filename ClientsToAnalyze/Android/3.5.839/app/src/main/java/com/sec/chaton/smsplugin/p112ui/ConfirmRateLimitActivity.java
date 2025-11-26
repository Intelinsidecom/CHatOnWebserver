package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Button;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class ConfirmRateLimitActivity extends Activity {

    /* renamed from: a */
    private long f14755a;

    /* renamed from: b */
    private Handler f14756b;

    /* renamed from: c */
    private Runnable f14757c;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.confirm_rate_limit_activity);
        ((Button) findViewById(R.id.btn_yes)).setOnClickListener(new ViewOnClickListenerC4346m(this));
        ((Button) findViewById(R.id.btn_no)).setOnClickListener(new ViewOnClickListenerC4347n(this));
        this.f14756b = new Handler();
        this.f14757c = new RunnableC4348o(this);
        this.f14755a = System.currentTimeMillis();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        long jCurrentTimeMillis = (this.f14755a - System.currentTimeMillis()) + 19500;
        if (jCurrentTimeMillis <= 0) {
            m15747a(false);
        } else if (this.f14756b != null) {
            this.f14756b.postDelayed(this.f14757c, jCurrentTimeMillis);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f14756b != null) {
            this.f14756b.removeCallbacks(this.f14757c);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            m15747a(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15747a(boolean z) {
        Intent intent = new Intent("com.sec.chaton.smsplugin.RATE_LIMIT_CONFIRMED");
        intent.putExtra("answer", z);
        sendBroadcast(intent);
        finish();
    }
}
