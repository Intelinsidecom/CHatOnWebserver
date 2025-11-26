package com.sec.chaton.registration;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class ActivityCountDown extends Activity {

    /* renamed from: a */
    TextView f4169a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_countdown);
        this.f4169a = (TextView) findViewById(R.id.countdown);
        new CountDownTimerC1193f(this, 30000L, 1000L).start();
    }
}
