package com.sec.chaton.event;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import java.io.File;

/* loaded from: classes.dex */
public class EventDialog extends Activity {

    /* renamed from: a */
    private Button f5418a;

    /* renamed from: b */
    private Button f5419b;

    /* renamed from: c */
    private CheckBox f5420c;

    /* renamed from: d */
    private LinearLayout f5421d;

    /* renamed from: e */
    private ImageView f5422e;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.layout_event_dialog);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        this.f5418a = (Button) findViewById(R.id.button3);
        this.f5419b = (Button) findViewById(R.id.button2);
        this.f5420c = (CheckBox) findViewById(R.id.event_popup_checkbox);
        this.f5421d = (LinearLayout) findViewById(R.id.layout_event_popup_checkbox_area);
        this.f5418a.setText(R.string.image_view_details);
        this.f5419b.setText(R.string.close);
        this.f5420c.setText(R.string.ams_never_show_again);
        this.f5422e = (ImageView) findViewById(R.id.event_popup_main_image);
        this.f5421d.setOnClickListener(new ViewOnClickListenerC1460b(this));
        this.f5421d.setFocusable(true);
        this.f5420c.setClickable(true);
        this.f5418a.setOnClickListener(new ViewOnClickListenerC1461c(this));
        this.f5419b.setOnClickListener(new ViewOnClickListenerC1462d(this));
        File fileM6407n = C1464f.m6407n();
        if (fileM6407n != null && fileM6407n.exists()) {
            this.f5422e.setImageDrawable(Drawable.createFromPath(fileM6407n.getPath()));
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m6370a();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (C1464f.m6403j()) {
            C3159aa.m10965a("event_do_not_show_popup_time", Long.valueOf(System.currentTimeMillis()));
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: a */
    private void m6370a() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
