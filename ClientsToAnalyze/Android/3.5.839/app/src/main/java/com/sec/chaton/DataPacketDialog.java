package com.sec.chaton;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.common.util.C5034k;

/* loaded from: classes.dex */
public class DataPacketDialog extends PasswordLockActivity {

    /* renamed from: a */
    private Button f1919a;

    /* renamed from: b */
    private CheckBox f1920b;

    /* renamed from: c */
    private LinearLayout f1921c;

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.data_packet_dialog);
        m2881a();
        getWindow().setLayout(-2, -2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.attentionDialog);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(linearLayout.getLayoutParams());
        Configuration configuration = getResources().getConfiguration();
        int iM19088a = (int) C5034k.m19088a(5.0f);
        float f = getApplicationContext().getResources().getDisplayMetrics().density;
        if (configuration.orientation == 2) {
            i = (int) ((360.0f * f) + 0.5f);
        } else {
            i = configuration.orientation == 1 ? (int) ((320.0f * f) + 0.5f) : 0;
        }
        layoutParams.width = i;
        layoutParams.setMargins(iM19088a, iM19088a, iM19088a, iM19088a);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        this.f1919a = (Button) findViewById(R.id.data_packet_ok);
        this.f1920b = (CheckBox) findViewById(R.id.data_packet_chekcbox);
        this.f1921c = (LinearLayout) findViewById(R.id.linear_packet_chekcbox);
        this.f1921c.setOnClickListener(new ViewOnClickListenerC4906v(this));
        this.f1921c.setFocusable(true);
        this.f1920b.setClickable(false);
        this.f1919a.setOnClickListener(new ViewOnClickListenerC4907w(this));
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.attentionDialog);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(linearLayout.getLayoutParams());
        int i = 0;
        int iM19088a = (int) C5034k.m19088a(5.0f);
        float f = getApplicationContext().getResources().getDisplayMetrics().density;
        if (configuration.orientation == 2) {
            i = (int) ((360.0f * f) + 0.5f);
        } else if (configuration.orientation == 1) {
            i = (int) ((320.0f * f) + 0.5f);
        }
        layoutParams.width = i;
        layoutParams.setMargins(iM19088a, iM19088a, iM19088a, iM19088a);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m2881a() {
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
    }
}
