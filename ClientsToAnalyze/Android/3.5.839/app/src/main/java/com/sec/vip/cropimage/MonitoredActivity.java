package com.sec.vip.cropimage;

import android.os.Bundle;
import com.sec.chaton.base.BaseActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class MonitoredActivity extends BaseActivity {

    /* renamed from: n */
    private final ArrayList<InterfaceC5134u> f18658n = new ArrayList<>();

    /* renamed from: a */
    public void m19566a(InterfaceC5134u interfaceC5134u) {
        if (!this.f18658n.contains(interfaceC5134u)) {
            this.f18658n.add(interfaceC5134u);
        }
    }

    /* renamed from: b */
    public void m19567b(InterfaceC5134u interfaceC5134u) {
        this.f18658n.remove(interfaceC5134u);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator<InterfaceC5134u> it = this.f18658n.iterator();
        while (it.hasNext()) {
            it.next().mo19590b(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Iterator<InterfaceC5134u> it = this.f18658n.iterator();
        while (it.hasNext()) {
            it.next().mo19587a(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        Iterator<InterfaceC5134u> it = this.f18658n.iterator();
        while (it.hasNext()) {
            it.next().mo19591c(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Iterator<InterfaceC5134u> it = this.f18658n.iterator();
        while (it.hasNext()) {
            it.next().mo19592d(this);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
