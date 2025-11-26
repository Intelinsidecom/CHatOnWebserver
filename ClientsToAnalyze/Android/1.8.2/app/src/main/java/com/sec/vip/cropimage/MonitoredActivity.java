package com.sec.vip.cropimage;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class MonitoredActivity extends Activity {

    /* renamed from: a */
    private final ArrayList f7533a = new ArrayList();

    /* renamed from: e */
    public boolean f7534e;

    /* renamed from: a */
    public abstract int mo7298a();

    /* renamed from: b */
    public abstract int mo7299b();

    /* renamed from: c */
    public abstract float mo7300c();

    /* renamed from: a */
    public void m7316a(InterfaceC2118o interfaceC2118o) {
        if (!this.f7533a.contains(interfaceC2118o)) {
            this.f7533a.add(interfaceC2118o);
        }
    }

    /* renamed from: b */
    public void m7317b(InterfaceC2118o interfaceC2118o) {
        this.f7533a.remove(interfaceC2118o);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator it = this.f7533a.iterator();
        while (it.hasNext()) {
            ((InterfaceC2118o) it.next()).mo7429b(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Iterator it = this.f7533a.iterator();
        while (it.hasNext()) {
            ((InterfaceC2118o) it.next()).mo7383a(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Iterator it = this.f7533a.iterator();
        while (it.hasNext()) {
            ((InterfaceC2118o) it.next()).mo7384c(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Iterator it = this.f7533a.iterator();
        while (it.hasNext()) {
            ((InterfaceC2118o) it.next()).mo7385d(this);
        }
    }
}
