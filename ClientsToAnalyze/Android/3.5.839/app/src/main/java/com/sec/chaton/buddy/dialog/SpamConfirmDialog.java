package com.sec.chaton.buddy.dialog;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.p055d.C2126g;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.common.p123a.AbstractC4932a;

/* loaded from: classes.dex */
public class SpamConfirmDialog extends PasswordLockActivity implements View.OnClickListener {

    /* renamed from: b */
    public static final String f4652b = SpamConfirmDialog.class.getSimpleName();

    /* renamed from: a */
    Context f4653a;

    /* renamed from: c */
    Handler f4654c = new HandlerC1210aj(this);

    /* renamed from: d */
    private String f4655d;

    /* renamed from: e */
    private String f4656e;

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    @TargetApi(11)
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f4653a = getApplicationContext();
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        getWindow().setLayout(-1, -2);
        this.f4655d = getIntent().getExtras().getString("SCD_DIALOG_BUDDY_NAME");
        this.f4656e = getIntent().getExtras().getString("SCD_DIALOG_BUDDY_NO");
        AbstractC4932a.m18733a(this).mo18740a(getString(R.string.spammer_report_title)).mo18749b(getString(R.string.spammer_report_guide, new Object[]{this.f4655d})).mo18755c(getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1209ai(this)).mo18741a(getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1208ah(this)).mo18752b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7344a() {
        C2126g.m9476a(this.f4654c).m9482b(this.f4656e, 1);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
