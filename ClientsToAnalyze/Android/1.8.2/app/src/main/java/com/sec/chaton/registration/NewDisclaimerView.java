package com.sec.chaton.registration;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class NewDisclaimerView extends Activity {

    /* renamed from: a */
    private Button f4327a;

    /* renamed from: b */
    private CheckBox f4328b;

    /* renamed from: c */
    private CheckBox f4329c;

    /* renamed from: d */
    private LinearLayout f4330d;

    /* renamed from: e */
    private LinearLayout f4331e;

    /* renamed from: f */
    private LinearLayout f4332f;

    /* renamed from: g */
    private ImageButton f4333g;

    /* renamed from: h */
    private ImageButton f4334h;

    /* renamed from: i */
    private ImageButton f4335i;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.new_disclaimer_view);
        this.f4327a = (Button) findViewById(R.id.accept_button);
        this.f4328b = (CheckBox) findViewById(R.id.disclaimer_chekcbox);
        this.f4330d = (LinearLayout) findViewById(R.id.linear_disclaimer_chekcbox);
        this.f4329c = (CheckBox) findViewById(R.id.disclaimer_chekcbox2);
        this.f4331e = (LinearLayout) findViewById(R.id.linear_disclaimer_chekcbox2);
        this.f4333g = (ImageButton) findViewById(R.id.link_button);
        this.f4334h = (ImageButton) findViewById(R.id.link_button2);
        this.f4335i = (ImageButton) findViewById(R.id.link_button3);
        this.f4332f = (LinearLayout) findViewById(R.id.layout_disclaimer);
        if (getResources().getConfiguration().orientation == 2) {
            this.f4332f.setPadding(getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_land), 0, getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_land), 0);
        } else {
            this.f4332f.setPadding(getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_port), 0, getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_port), 0);
        }
        ((Button) findViewById(R.id.back_key)).setOnClickListener(new ViewOnClickListenerC1182bi(this));
        this.f4333g.setOnClickListener(new ViewOnClickListenerC1183bj(this));
        this.f4334h.setOnClickListener(new ViewOnClickListenerC1184bk(this));
        this.f4335i.setOnClickListener(new ViewOnClickListenerC1185bl(this));
        this.f4330d.setOnClickListener(new ViewOnClickListenerC1186bm(this));
        this.f4331e.setOnClickListener(new ViewOnClickListenerC1187bn(this));
        this.f4330d.setFocusable(true);
        this.f4328b.setClickable(false);
        this.f4331e.setFocusable(true);
        this.f4329c.setClickable(false);
        this.f4327a.setOnClickListener(new ViewOnClickListenerC1188bo(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4443a() {
        if (this.f4328b.isChecked() && this.f4329c.isChecked()) {
            this.f4327a.setEnabled(true);
        } else {
            this.f4327a.setEnabled(false);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.f4332f.setPadding(getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_land), 0, getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_land), 0);
        } else {
            this.f4332f.setPadding(getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_port), 0, getResources().getDimensionPixelOffset(R.dimen.terms_and_condition_padding_port), 0);
        }
    }
}
