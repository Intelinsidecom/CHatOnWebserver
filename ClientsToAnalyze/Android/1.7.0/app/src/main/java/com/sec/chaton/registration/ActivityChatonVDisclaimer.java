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
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class ActivityChatonVDisclaimer extends BaseActivity {

    /* renamed from: a */
    private GeneralHeaderView f3139a;

    /* renamed from: b */
    private TextView f3140b;

    /* renamed from: c */
    private Button f3141c;

    /* renamed from: d */
    private Button f3142d;

    /* renamed from: e */
    private CheckBox f3143e;

    /* renamed from: f */
    private boolean f3144f = false;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_chatonv_disclaimer);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C1341p.m4658b("onStart : ActivityChatonVDisclaimer", getClass().getSimpleName());
        this.f3139a = (GeneralHeaderView) findViewById(R.id.chatonv_txt_title);
        this.f3139a.setMarquee();
        String string = C1323bs.m4575a().getString("country_ISO", null);
        this.f3141c = (Button) findViewById(R.id.chatonv_disclaimer_terms);
        this.f3141c.setText("SDS " + getString(R.string.setting_disclaimer_terms));
        this.f3142d = (Button) findViewById(R.id.chatonv_disclaimer_accept);
        if (string != null && string.equals("KR")) {
            findViewById(R.id.layout_chekcbox_3rdparty).setVisibility(0);
            this.f3142d.setEnabled(false);
            this.f3143e = (CheckBox) findViewById(R.id.chekcbox_3rdparty);
            this.f3143e.setText("개인정보 제3자 정보제공 동의");
            this.f3143e.setOnCheckedChangeListener(new C0979k(this));
            this.f3140b = (TextView) findViewById(R.id.chatonv_disclaimer_3rdparty_detail);
            this.f3140b.setText(Html.fromHtml("<u>자세히 보기</u>"));
            this.f3140b.requestFocus();
            this.f3140b.setOnClickListener(new ViewOnClickListenerC0978j(this));
        } else {
            this.f3144f = true;
            this.f3142d.setEnabled(true);
        }
        this.f3141c.setOnClickListener(new ViewOnClickListenerC0980l(this));
        this.f3142d.setOnClickListener(new ViewOnClickListenerC0981m(this));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        GlobalApplication.m3102a(this);
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f3144f) {
            this.f3142d.setEnabled(true);
        } else {
            this.f3142d.setEnabled(false);
        }
    }
}
