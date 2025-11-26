package com.sec.chaton.registration;

import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class ActivityChatonVDisclaimer extends BaseActivity {

    /* renamed from: a */
    private GeneralHeaderView f4160a;

    /* renamed from: b */
    private TextView f4161b;

    /* renamed from: c */
    private Button f4162c;

    /* renamed from: d */
    private Button f4163d;

    /* renamed from: e */
    private CheckBox f4164e;

    /* renamed from: i */
    private boolean f4165i = false;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_chatonv_disclaimer);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C1786r.m6061b("onStart : ActivityChatonVDisclaimer", getClass().getSimpleName());
        this.f4160a = (GeneralHeaderView) findViewById(R.id.chatonv_txt_title);
        this.f4160a.setMarquee();
        String string = C1789u.m6075a().getString("country_ISO", null);
        this.f4162c = (Button) findViewById(R.id.chatonv_disclaimer_terms);
        this.f4162c.setText("SDS " + getString(R.string.setting_disclaimer_terms));
        this.f4163d = (Button) findViewById(R.id.chatonv_disclaimer_accept);
        if (string != null && string.equals("KR")) {
            findViewById(R.id.layout_chekcbox_3rdparty).setVisibility(0);
            this.f4163d.setEnabled(false);
            this.f4164e = (CheckBox) findViewById(R.id.chekcbox_3rdparty);
            this.f4164e.setText("개인정보 제3자 정보제공 동의");
            this.f4164e.setOnCheckedChangeListener(new C1146a(this));
            this.f4161b = (TextView) findViewById(R.id.chatonv_disclaimer_3rdparty_detail);
            this.f4161b.setText(Html.fromHtml("<u>자세히 보기</u>"));
            this.f4161b.requestFocus();
            this.f4161b.setOnClickListener(new ViewOnClickListenerC1173b(this));
        } else {
            this.f4165i = true;
            this.f4163d.setEnabled(true);
        }
        this.f4162c.setOnClickListener(new ViewOnClickListenerC1190c(this));
        this.f4163d.setOnClickListener(new ViewOnClickListenerC1191d(this));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        GlobalApplication.m3258a(this);
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f4165i) {
            this.f4163d.setEnabled(true);
        } else {
            this.f4163d.setEnabled(false);
        }
    }
}
