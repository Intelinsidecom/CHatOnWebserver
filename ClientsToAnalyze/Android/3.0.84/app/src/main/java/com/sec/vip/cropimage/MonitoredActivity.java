package com.sec.vip.cropimage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class MonitoredActivity extends BaseActivity {

    /* renamed from: a */
    private final ArrayList<InterfaceC3604aj> f13247a = new ArrayList<>();

    /* renamed from: e */
    public boolean f13248e;

    /* renamed from: a */
    public abstract int mo12916a();

    /* renamed from: b */
    public abstract int mo12917b();

    /* renamed from: c */
    public abstract float mo12918c();

    /* renamed from: a */
    public void m12975a(InterfaceC3604aj interfaceC3604aj) {
        if (!this.f13247a.contains(interfaceC3604aj)) {
            this.f13247a.add(interfaceC3604aj);
        }
    }

    /* renamed from: b */
    public void m12976b(InterfaceC3604aj interfaceC3604aj) {
        this.f13247a.remove(interfaceC3604aj);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator<InterfaceC3604aj> it = this.f13247a.iterator();
        while (it.hasNext()) {
            it.next().mo12983d(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Iterator<InterfaceC3604aj> it = this.f13247a.iterator();
        while (it.hasNext()) {
            it.next().mo12978a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        Iterator<InterfaceC3604aj> it = this.f13247a.iterator();
        while (it.hasNext()) {
            it.next().mo12982c(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Iterator<InterfaceC3604aj> it = this.f13247a.iterator();
        while (it.hasNext()) {
            it.next().mo12981b(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m12974d();
    }

    /* renamed from: d */
    private void m12974d() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
