package com.sec.vip.amschaton;

import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class AMSPlayerActivity extends AMSViewerActivity {
    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C3250y.m11453c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            C3250y.m11450b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            finish();
        } else {
            Intent intent = new Intent(this, (Class<?>) BaseAMSActivity.class);
            intent.putExtras(extras);
            intent.putExtra("AMS_ACTION", 4);
            startActivityForResult(intent, 1000);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            finish();
        }
        switch (i) {
            case 1000:
            case 1001:
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    finish();
                    break;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtras(extras);
                    setResult(-1, intent2);
                    finish();
                    break;
                }
            default:
                finish();
                break;
        }
    }
}
