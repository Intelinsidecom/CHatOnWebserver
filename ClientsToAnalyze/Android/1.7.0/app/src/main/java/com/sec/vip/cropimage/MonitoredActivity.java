package com.sec.vip.cropimage;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class MonitoredActivity extends Activity {

    /* renamed from: a */
    private final ArrayList f5494a = new ArrayList();

    /* renamed from: e */
    public boolean f5495e;

    /* renamed from: a */
    public abstract int mo5709a();

    /* renamed from: b */
    public abstract int mo5710b();

    /* renamed from: c */
    public abstract float mo5711c();

    /* renamed from: a */
    public void m5726a(InterfaceC1601r interfaceC1601r) {
        if (!this.f5494a.contains(interfaceC1601r)) {
            this.f5494a.add(interfaceC1601r);
        }
    }

    /* renamed from: b */
    public void m5727b(InterfaceC1601r interfaceC1601r) {
        this.f5494a.remove(interfaceC1601r);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator it = this.f5494a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1601r) it.next()).mo5728a(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Iterator it = this.f5494a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1601r) it.next()).mo5729b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Iterator it = this.f5494a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1601r) it.next()).mo5730c(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Iterator it = this.f5494a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1601r) it.next()).mo5731d(this);
        }
    }
}
