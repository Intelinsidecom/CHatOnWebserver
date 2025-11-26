package com.sec.vip.amschaton;

import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class AMSPlayerActivity extends AMSViewerActivity {

    /* renamed from: n */
    private String f4697n = null;

    /* renamed from: o */
    private int f4698o = 1000;

    /* renamed from: p */
    private int f4699p = 2000;

    /* renamed from: q */
    private boolean f4700q = true;

    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4697n = extras.getString("AMS_FILE_PATH");
            this.f4698o = extras.getInt("VIEWER_MODE", 1002);
            this.f4699p = extras.getInt("AMS_FILE_TYPE", 2001);
            if (this.f4698o == 1000) {
                this.f4700q = extras.getBoolean("AMS_DIRECT_PLAY", true);
            }
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f4697n = "";
        }
        if (f4630l) {
            Intent intent = new Intent(this, (Class<?>) com.sec.vip.amschaton.honeycomb.AMSPlayerActivity.class);
            intent.putExtra("AMS_FILE_PATH", this.f4697n);
            intent.putExtra("VIEWER_MODE", this.f4698o);
            intent.putExtra("AMS_FILE_TYPE", this.f4699p);
            startActivity(intent);
            finish();
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) com.sec.vip.amschaton.ics.AMSPlayerActivity.class);
        intent2.putExtra("AMS_FILE_PATH", this.f4697n);
        intent2.putExtra("VIEWER_MODE", this.f4698o);
        intent2.putExtra("AMS_FILE_TYPE", this.f4699p);
        intent2.putExtra("AMS_DIRECT_PLAY", this.f4700q);
        startActivity(intent2);
        finish();
    }
}
