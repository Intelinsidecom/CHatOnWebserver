package com.sec.vip.cropimage;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MonitoredActivity extends Activity {

    /* renamed from: a */
    private final ArrayList f4443a = new ArrayList();

    public class LifeCycleAdapter implements LifeCycleListener {
        @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
        /* renamed from: a */
        public void mo4332a(MonitoredActivity monitoredActivity) {
        }

        @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
        /* renamed from: b */
        public void mo4333b(MonitoredActivity monitoredActivity) {
        }

        @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
        /* renamed from: c */
        public void mo4334c(MonitoredActivity monitoredActivity) {
        }

        @Override // com.sec.vip.cropimage.MonitoredActivity.LifeCycleListener
        /* renamed from: d */
        public void mo4335d(MonitoredActivity monitoredActivity) {
        }
    }

    public interface LifeCycleListener {
        /* renamed from: a */
        void mo4332a(MonitoredActivity monitoredActivity);

        /* renamed from: b */
        void mo4333b(MonitoredActivity monitoredActivity);

        /* renamed from: c */
        void mo4334c(MonitoredActivity monitoredActivity);

        /* renamed from: d */
        void mo4335d(MonitoredActivity monitoredActivity);
    }

    /* renamed from: a */
    public void m4330a(LifeCycleListener lifeCycleListener) {
        if (this.f4443a.contains(lifeCycleListener)) {
            return;
        }
        this.f4443a.add(lifeCycleListener);
    }

    /* renamed from: b */
    public void m4331b(LifeCycleListener lifeCycleListener) {
        this.f4443a.remove(lifeCycleListener);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator it = this.f4443a.iterator();
        while (it.hasNext()) {
            ((LifeCycleListener) it.next()).mo4332a(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Iterator it = this.f4443a.iterator();
        while (it.hasNext()) {
            ((LifeCycleListener) it.next()).mo4333b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Iterator it = this.f4443a.iterator();
        while (it.hasNext()) {
            ((LifeCycleListener) it.next()).mo4334c(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Iterator it = this.f4443a.iterator();
        while (it.hasNext()) {
            ((LifeCycleListener) it.next()).mo4335d(this);
        }
    }
}
