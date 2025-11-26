package com.sec.chaton.registration;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class ActivityChatonVDownloads extends BaseActivity {

    /* renamed from: a */
    private GeneralHeaderView f4166a;

    /* renamed from: b */
    private TextView f4167b;

    /* renamed from: c */
    private Button f4168c;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_chatonv_downloads);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C1786r.m6061b("onStart : ActivityChatonVDownloads", getClass().getSimpleName());
        this.f4166a = (GeneralHeaderView) findViewById(R.id.chatonv_txt_title);
        this.f4166a.setMarquee();
        this.f4167b = (TextView) findViewById(R.id.chatonv_download_text);
        this.f4168c = (Button) findViewById(R.id.chatonv_download_accept);
        this.f4168c.setOnClickListener(new ViewOnClickListenerC1192e(this));
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
    }
}
