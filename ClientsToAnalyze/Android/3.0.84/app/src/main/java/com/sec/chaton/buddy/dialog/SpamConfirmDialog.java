package com.sec.chaton.buddy.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;

/* loaded from: classes.dex */
public class SpamConfirmDialog extends Activity implements View.OnClickListener {

    /* renamed from: b */
    public static final String f2783b = SpamConfirmDialog.class.getSimpleName();

    /* renamed from: a */
    Context f2784a;

    /* renamed from: c */
    Handler f2785c = new HandlerC0644z(this);

    /* renamed from: d */
    private String f2786d;

    /* renamed from: e */
    private String f2787e;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f2784a = getApplicationContext();
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        getWindow().setLayout(-1, -2);
        this.f2786d = getIntent().getExtras().getString("SCD_DIALOG_BUDDY_NAME");
        this.f2787e = getIntent().getExtras().getString("SCD_DIALOG_BUDDY_NO");
        AbstractC3271a.m11494a(this).mo11500a(getString(R.string.spammer_report_title)).mo11509b(getString(R.string.spammer_report_guide, new Object[]{this.f2786d})).mo11510b(getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0643y(this)).mo11501a(getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0642x(this)).mo11512b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4278a() {
        new C1328f(this.f2785c).m5709b(this.f2787e, 1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getWindow().getDecorView().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && motionEvent.getAction() == 0) {
            finish();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4281b();
    }

    /* renamed from: b */
    private void m4281b() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
