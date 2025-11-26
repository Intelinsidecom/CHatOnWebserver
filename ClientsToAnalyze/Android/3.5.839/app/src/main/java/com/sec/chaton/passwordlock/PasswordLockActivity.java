package com.sec.chaton.passwordlock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class PasswordLockActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b(getClass().getSimpleName() + " onCreate : " + isTaskRoot(), "ActivityHelper");
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        C1059a.m6163a(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        C1059a.m6170f(this);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C1059a.m6167c(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C1059a.m6166b(this);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        C1059a.m6168d(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1059a.m6171g(this);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C1059a.m6169e(this);
    }
}
