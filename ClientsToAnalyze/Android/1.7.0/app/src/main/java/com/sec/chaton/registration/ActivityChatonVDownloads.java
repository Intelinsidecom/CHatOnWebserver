package com.sec.chaton.registration;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1341p;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class ActivityChatonVDownloads extends BaseActivity {

    /* renamed from: a */
    private GeneralHeaderView f3145a;

    /* renamed from: b */
    private TextView f3146b;

    /* renamed from: c */
    private Button f3147c;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_chatonv_downloads);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C1341p.m4658b("onStart : ActivityChatonVDownloads", getClass().getSimpleName());
        this.f3145a = (GeneralHeaderView) findViewById(R.id.chatonv_txt_title);
        this.f3145a.setMarquee();
        this.f3146b = (TextView) findViewById(R.id.chatonv_download_text);
        this.f3147c = (Button) findViewById(R.id.chatonv_download_accept);
        this.f3147c.setOnClickListener(new ViewOnClickListenerC0973e(this));
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
    }
}
