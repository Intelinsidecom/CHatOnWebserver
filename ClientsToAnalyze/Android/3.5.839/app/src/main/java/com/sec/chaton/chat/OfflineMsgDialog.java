package com.sec.chaton.chat;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.smsplugin.transaction.BackgroundSenderService;
import com.sec.chaton.util.C4809aa;
import com.sec.common.p123a.AbstractC4932a;

/* loaded from: classes.dex */
public class OfflineMsgDialog extends PasswordLockActivity implements View.OnClickListener {

    /* renamed from: b */
    public static final String f5831b = OfflineMsgDialog.class.getSimpleName();

    /* renamed from: a */
    Context f5832a;

    /* renamed from: c */
    boolean f5833c = false;

    /* renamed from: d */
    boolean f5834d = false;

    /* renamed from: e */
    private String f5835e;

    /* renamed from: f */
    private String f5836f;

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f5832a = getApplicationContext();
        getWindow().setLayout(-1, -2);
        this.f5835e = getIntent().getExtras().getString("OFFLINE_DIALOG_BUDDY_NAME");
        this.f5836f = getIntent().getExtras().getString("OFFLINE_DIALOG_BUDDY_PHONENUMBER");
        AbstractC4932a.m18733a(this).mo18740a(getString(R.string.chat_go_to_sms)).mo18749b(String.format(GlobalApplication.m10283b().getString(R.string.offline_default_free_sms_msg), C4809aa.m18104a().m18121a("Push Name", "")) + "\n\n" + String.format(GlobalApplication.m10283b().getString(R.string.offline_send_as_sms), this.f5835e, Integer.valueOf(C4809aa.m18104a().m18120a("free_sms_remain_count", (Integer) 200).intValue()), Integer.valueOf(C4809aa.m18104a().m18120a("free_sms_max_count", (Integer) 200).intValue()))).mo18755c(getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1772hr(this)).mo18741a(getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1771hq(this)).mo18752b();
    }

    /* renamed from: a */
    protected void m8351a() {
        BackgroundSenderService.m15513a(this.f5832a, String.format(GlobalApplication.m10283b().getString(R.string.offline_default_free_sms_msg), C4809aa.m18104a().m18121a("Push Name", "")), new String[]{this.f5836f});
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

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
