package com.sec.chaton.settings;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncInfo;
import android.content.SyncStatusObserver;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Handler;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import java.util.List;

/* loaded from: classes.dex */
public class SyncStatePreference extends Preference {

    /* renamed from: a */
    private boolean f9265a;

    /* renamed from: b */
    private Object f9266b;

    /* renamed from: c */
    private final Handler f9267c;

    /* renamed from: d */
    private Runnable f9268d;

    /* renamed from: e */
    private SyncStatusObserver f9269e;

    public SyncStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9265a = false;
        this.f9267c = new Handler();
        this.f9268d = new RunnableC2701fk(this);
        this.f9269e = new SyncStatusObserverC2702fl(this);
        setWidgetLayoutResource(R.layout.preference_widget_sync_now);
        setOnPreferenceClickListener(new C2699fi(this, context));
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.sync_active);
        View viewFindViewById = view.findViewById(R.id.sync_pending);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (this.f9265a) {
            imageView.setVisibility(0);
            viewFindViewById.setVisibility(8);
            imageView.post(new RunnableC2700fj(this, animationDrawable));
        } else {
            imageView.setVisibility(8);
            viewFindViewById.setVisibility(0);
            animationDrawable.stop();
        }
    }

    /* renamed from: a */
    private void m9205a(boolean z) {
        if (this.f9265a != z) {
            this.f9265a = z;
            callChangeListener(null);
            setEnabled(!z);
        }
    }

    /* renamed from: a */
    public void m9211a() {
        m9212b();
        this.f9266b = ContentResolver.addStatusChangeListener(7, this.f9269e);
        m9210e();
    }

    /* renamed from: b */
    public void m9212b() {
        if (this.f9266b != null) {
            this.f9267c.removeCallbacks(this.f9268d);
            ContentResolver.removeStatusChangeListener(this.f9266b);
            this.f9266b = null;
        }
    }

    /* renamed from: c */
    private boolean m9208c() {
        SyncInfo currentSync = ContentResolver.getCurrentSync();
        return (currentSync == null || currentSync.account == null || !"com.sec.chaton".equals(currentSync.account.type)) ? false : true;
    }

    @TargetApi(11)
    /* renamed from: d */
    private boolean m9209d() {
        List<SyncInfo> currentSyncs = ContentResolver.getCurrentSyncs();
        if (currentSyncs == null || currentSyncs.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < currentSyncs.size(); i++) {
            if (currentSyncs.get(i).account != null && "com.sec.chaton".equals(currentSyncs.get(i).account.type)) {
                z = true;
            }
            C3250y.m11450b("isSyncing return value = " + z, "SyncStatePreference");
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m9210e() {
        boolean zM9208c;
        if (Build.VERSION.SDK_INT >= 11) {
            zM9208c = m9209d();
        } else {
            zM9208c = m9208c();
        }
        C3250y.m11450b("onSyncStateUpdated " + zM9208c, "SyncStatePreference");
        m9205a(zM9208c);
    }
}
