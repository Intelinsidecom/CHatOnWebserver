package com.sec.chaton.registration;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class ActivityCountDown extends Activity {

    /* renamed from: a */
    TextView f3148a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_countdown);
        this.f3148a = (TextView) findViewById(R.id.countdown);
        new CountDownTimerC0974f(this, 30000L, 1000L).start();
    }
}
