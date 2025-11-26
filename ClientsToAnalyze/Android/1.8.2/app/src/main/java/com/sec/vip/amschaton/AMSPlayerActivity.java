package com.sec.vip.amschaton;

import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class AMSPlayerActivity extends AMSViewerActivity {

    /* renamed from: p */
    private String f6684p = null;

    /* renamed from: q */
    private int f6685q = 1000;

    /* renamed from: r */
    private int f6686r = 2000;

    /* renamed from: s */
    private boolean f6687s = true;

    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6684p = extras.getString("AMS_FILE_PATH");
            this.f6685q = extras.getInt("VIEWER_MODE", 1002);
            this.f6686r = extras.getInt("AMS_FILE_TYPE", 2001);
            if (this.f6685q == 1000) {
                this.f6687s = extras.getBoolean("AMS_DIRECT_PLAY", true);
            }
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f6684p = "";
        }
        if (f6617j) {
            Intent intent = new Intent(this, (Class<?>) com.sec.vip.amschaton.honeycomb.AMSPlayerActivity.class);
            intent.putExtra("AMS_FILE_PATH", this.f6684p);
            intent.putExtra("VIEWER_MODE", this.f6685q);
            intent.putExtra("AMS_FILE_TYPE", this.f6686r);
            startActivity(intent);
            finish();
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) com.sec.vip.amschaton.ics.AMSPlayerActivity.class);
        intent2.putExtra("AMS_FILE_PATH", this.f6684p);
        intent2.putExtra("VIEWER_MODE", this.f6685q);
        intent2.putExtra("AMS_FILE_TYPE", this.f6686r);
        intent2.putExtra("AMS_DIRECT_PLAY", this.f6687s);
        startActivity(intent2);
        finish();
    }
}
