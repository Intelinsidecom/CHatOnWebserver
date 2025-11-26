package com.sec.chaton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class DataPacketDialog extends Activity {

    /* renamed from: a */
    private Button f671a;

    /* renamed from: b */
    private CheckBox f672b;

    /* renamed from: c */
    private LinearLayout f673c;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.data_packet_dialog);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        getWindow().setLayout(-2, -2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.attentionDialog);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(linearLayout.getLayoutParams());
        Configuration configuration = getResources().getConfiguration();
        int iM11085a = (int) C3172an.m11085a(5.0f);
        float f = getApplicationContext().getResources().getDisplayMetrics().density;
        if (configuration.orientation == 2) {
            i = (int) ((360.0f * f) + 0.5f);
        } else {
            i = configuration.orientation == 1 ? (int) ((320.0f * f) + 0.5f) : 0;
        }
        layoutParams.width = i;
        layoutParams.setMargins(iM11085a, iM11085a, iM11085a, iM11085a);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        this.f671a = (Button) findViewById(R.id.data_packet_ok);
        this.f672b = (CheckBox) findViewById(R.id.data_packet_chekcbox);
        this.f673c = (LinearLayout) findViewById(R.id.linear_packet_chekcbox);
        this.f673c.setOnClickListener(new ViewOnClickListenerC1668m(this));
        this.f673c.setFocusable(true);
        this.f672b.setClickable(false);
        this.f671a.setOnClickListener(new ViewOnClickListenerC1945n(this));
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m1134a();
    }

    /* renamed from: a */
    private void m1134a() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.attentionDialog);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(linearLayout.getLayoutParams());
        int i = 0;
        int iM11085a = (int) C3172an.m11085a(5.0f);
        float f = getApplicationContext().getResources().getDisplayMetrics().density;
        if (configuration.orientation == 2) {
            i = (int) ((360.0f * f) + 0.5f);
        } else if (configuration.orientation == 1) {
            i = (int) ((320.0f * f) + 0.5f);
        }
        layoutParams.width = i;
        layoutParams.setMargins(iM11085a, iM11085a, iM11085a, iM11085a);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
    }
}
