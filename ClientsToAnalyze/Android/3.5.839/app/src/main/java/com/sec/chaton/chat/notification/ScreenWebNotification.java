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
import com.sec.chaton.base.C1059a;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ScreenWebNotification extends FragmentActivity implements View.OnClickListener {

    /* renamed from: A */
    private boolean f6781A;

    /* renamed from: o */
    private Context f6783o;

    /* renamed from: p */
    private KeyguardManager f6784p;

    /* renamed from: q */
    private PowerManager f6785q;

    /* renamed from: s */
    private Runnable f6787s;

    /* renamed from: u */
    private TextView f6789u;

    /* renamed from: v */
    private TextView f6790v;

    /* renamed from: w */
    private Button f6791w;

    /* renamed from: x */
    private Button f6792x;

    /* renamed from: y */
    private String f6793y;

    /* renamed from: z */
    private boolean f6794z;

    /* renamed from: n */
    private final String f6782n = getClass().getSimpleName();

    /* renamed from: r */
    private int f6786r = 5000;

    /* renamed from: t */
    private Handler f6788t = null;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        getWindow().addFlags(2621440);
        this.f6783o = this;
        this.f6784p = (KeyguardManager) this.f6783o.getSystemService("keyguard");
        this.f6785q = (PowerManager) this.f6783o.getSystemService("power");
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_popup_web_noti, (ViewGroup) null);
        if (!this.f6785q.isScreenOn() || this.f6784p.inKeyguardRestrictedInputMode()) {
            viewInflate.setBackgroundColor(-16777216);
        } else {
            viewInflate.setBackgroundColor(0);
            this.f6788t = new Handler();
            this.f6787s = new RunnableC1811ar(this);
            this.f6788t.postDelayed(this.f6787s, this.f6786r);
        }
        setContentView(viewInflate);
        this.f6789u = (TextView) viewInflate.findViewById(R.id.textTitle);
        this.f6789u.setText(getResources().getString(R.string.app_name));
        this.f6790v = (TextView) viewInflate.findViewById(R.id.textContents);
        this.f6793y = getIntent().getStringExtra("contents");
        this.f6790v.setText(this.f6793y);
        this.f6791w = (Button) viewInflate.findViewById(R.id.button3);
        this.f6791w.setText(R.string.dialog_view);
        this.f6791w.setOnClickListener(this);
        this.f6792x = (Button) viewInflate.findViewById(R.id.button2);
        this.f6792x.setText(R.string.close);
        this.f6792x.setOnClickListener(this);
        C4904y.m18641c("[onCreate] webContent:" + this.f6793y, this.f6782n);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C4904y.m18639b("onResume", this.f6782n);
        if (this.f6794z && !this.f6781A) {
            this.f6781A = true;
        }
        if (!this.f6794z) {
            this.f6794z = true;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f6793y = intent.getStringExtra("contents");
        this.f6790v.setText(this.f6793y);
        C4904y.m18641c("[onNewIntent] webContent:" + this.f6793y, this.f6782n);
    }

    /* renamed from: f */
    protected void m8891f() {
        if (this.f6788t != null) {
            this.f6788t.removeCallbacks(this.f6787s);
        }
        C4904y.m18641c("[finishPopup]", this.f6782n);
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        C4904y.m18641c("[onDestroy]", this.f6782n);
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.f6781A) {
            m8891f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2 /* 2131165822 */:
                m8891f();
                break;
            case R.id.button3 /* 2131165823 */:
                Intent intentM2923a = IntentControllerActivity.m2923a((Context) this, true);
                intentM2923a.putExtra("chatType", EnumC2300t.WEB_AUTH.m10210a());
                intentM2923a.putExtra("fromPush", 1);
                intentM2923a.putExtra("Content", this.f6793y);
                startActivity(intentM2923a);
                m8891f();
                break;
        }
    }
}
