package com.sec.chaton.sharedialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ShareActivity extends Activity {

    /* renamed from: a */
    public static final String[] f13294a = {Config.CHATON_PACKAGE_NAME, "com.sec.chatonforcanada", "com.samsung.groupcast", "com.sec.android.homesync", "com.samsung.android.snote", "com.sec.android.widgetapp.diotek.smemo", "com.sec.android.app.memo"};

    /* renamed from: b */
    private AsyncTaskC3694b f13295b;

    /* renamed from: c */
    private DialogC3696d f13296c;

    /* renamed from: a */
    public static Intent m13949a(Context context, Intent intent) {
        Intent intent2 = new Intent(context, (Class<?>) ShareActivity.class);
        intent2.putExtra("baseIntent", intent);
        return intent2;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13295b = new AsyncTaskC3694b(this, this, (Intent) getIntent().getExtra("baseIntent"));
        this.f13295b.execute((Void) null);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (!this.f13295b.isCancelled()) {
            this.f13295b.cancel(true);
        }
    }
}
