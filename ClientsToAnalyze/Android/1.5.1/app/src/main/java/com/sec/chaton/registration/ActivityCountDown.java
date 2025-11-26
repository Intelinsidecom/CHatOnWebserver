package com.sec.chaton.registration;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class ActivityCountDown extends Activity {

    /* renamed from: a */
    TextView f2806a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_countdown);
        this.f2806a = (TextView) findViewById(C0062R.id.countdown);
        new CountDownTimerC0433i(this, 30000L, 1000L).start();
    }
}
