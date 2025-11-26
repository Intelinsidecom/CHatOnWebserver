package com.sec.chaton.buddy.dialog;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.passwordlock.PasswordLockActivity;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* loaded from: classes.dex */
public class ChatONVRedirectDialog extends PasswordLockActivity {

    /* renamed from: b */
    public static final String f4542b = ChatONVRedirectDialog.class.getSimpleName();

    /* renamed from: a */
    Context f4543a;

    /* renamed from: c */
    private final String f4544c = "com.sec.android.app.samsungapps";

    /* renamed from: d */
    private final String f4545d = "com.android.vending";

    /* renamed from: e */
    private final String f4546e = "com.coolots.chaton";

    /* renamed from: f */
    private InterfaceC4936e f4547f;

    @Override // com.sec.chaton.passwordlock.PasswordLockActivity, android.app.Activity
    @TargetApi(11)
    protected void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        this.f4543a = this;
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        m7278a();
    }

    /* renamed from: a */
    private void m7278a() {
        if (C4904y.f17872b) {
            C4904y.m18641c("showAlertDailog", f4542b);
        }
        this.f4547f = AbstractC4932a.m18733a(this.f4543a).mo18740a(getResources().getString(R.string.chaton_voice_video_chat)).mo18749b(getResources().getString(R.string.chatonv_redirect_dialog_content_new)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1246x(this)).mo18741a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1245w(this)).mo18745a();
        this.f4547f.setOnCancelListener(new DialogInterfaceOnCancelListenerC1247y(this));
        this.f4547f.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m7281b() {
        return m7280a("com.sec.android.app.samsungapps");
    }

    /* renamed from: a */
    private boolean m7280a(String str) throws PackageManager.NameNotFoundException {
        try {
            GlobalApplication.m18732r().getPackageManager().getApplicationInfo(str, 128);
            if (C4904y.f17872b) {
                C4904y.m18639b("isInstalled(" + str + ") true", f4542b);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            if (C4904y.f17872b) {
                C4904y.m18639b("isInstalled(" + str + ") false", f4542b);
            }
            return false;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
