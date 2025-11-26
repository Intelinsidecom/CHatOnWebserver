package com.sec.chaton.chat.notification;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ScreenWebNotification extends FragmentActivity implements View.OnClickListener {

    /* renamed from: b */
    private Context f4427b;

    /* renamed from: c */
    private KeyguardManager f4428c;

    /* renamed from: d */
    private PowerManager f4429d;

    /* renamed from: f */
    private Runnable f4431f;

    /* renamed from: h */
    private TextView f4433h;

    /* renamed from: i */
    private TextView f4434i;

    /* renamed from: j */
    private Button f4435j;

    /* renamed from: k */
    private Button f4436k;

    /* renamed from: l */
    private String f4437l;

    /* renamed from: m */
    private boolean f4438m;

    /* renamed from: n */
    private boolean f4439n;

    /* renamed from: a */
    private final String f4426a = getClass().getSimpleName();

    /* renamed from: e */
    private int f4430e = 5000;

    /* renamed from: g */
    private Handler f4432g = null;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        getWindow().addFlags(2621440);
        this.f4427b = this;
        this.f4428c = (KeyguardManager) this.f4427b.getSystemService("keyguard");
        this.f4429d = (PowerManager) this.f4427b.getSystemService("power");
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_popup_web_noti, (ViewGroup) null);
        if (!this.f4429d.isScreenOn() || this.f4428c.inKeyguardRestrictedInputMode()) {
            viewInflate.setBackgroundColor(-16777216);
        } else {
            viewInflate.setBackgroundColor(0);
            this.f4432g = new Handler();
            this.f4431f = new RunnableC1104aa(this);
            this.f4432g.postDelayed(this.f4431f, this.f4430e);
        }
        setContentView(viewInflate);
        this.f4433h = (TextView) viewInflate.findViewById(R.id.textTitle);
        this.f4433h.setText(getResources().getString(R.string.app_name));
        this.f4434i = (TextView) viewInflate.findViewById(R.id.textContents);
        this.f4437l = getIntent().getStringExtra("contents");
        this.f4434i.setText(this.f4437l);
        this.f4435j = (Button) viewInflate.findViewById(R.id.button3);
        this.f4435j.setText(R.string.dialog_view);
        this.f4435j.setOnClickListener(this);
        this.f4436k = (Button) viewInflate.findViewById(R.id.button2);
        this.f4436k.setText(R.string.close);
        this.f4436k.setOnClickListener(this);
        C3250y.m11453c("[onCreate] webContent:" + this.f4437l, this.f4426a);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C3250y.m11450b("onResume", this.f4426a);
        if (this.f4438m && !this.f4439n) {
            this.f4439n = true;
        }
        if (!this.f4438m) {
            this.f4438m = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f4437l = intent.getStringExtra("contents");
        this.f4434i.setText(this.f4437l);
        C3250y.m11453c("[onNewIntent] webContent:" + this.f4437l, this.f4426a);
    }

    /* renamed from: a */
    protected void m5430a() {
        if (this.f4432g != null) {
            this.f4432g.removeCallbacks(this.f4431f);
        }
        C3250y.m11453c("[finishPopup]", this.f4426a);
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        C3250y.m11453c("[onDestroy]", this.f4426a);
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.f4439n) {
            m5430a();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2 /* 2131165902 */:
                m5430a();
                break;
            case R.id.button3 /* 2131165903 */:
                Intent intentM1171a = IntentControllerActivity.m1171a((Context) this, true);
                intentM1171a.putExtra("chatType", EnumC1450r.WEB_AUTH.m6342a());
                intentM1171a.putExtra("fromPush", 1);
                intentM1171a.putExtra("Content", this.f4437l);
                startActivity(intentM1171a);
                m5430a();
                break;
        }
    }
}
