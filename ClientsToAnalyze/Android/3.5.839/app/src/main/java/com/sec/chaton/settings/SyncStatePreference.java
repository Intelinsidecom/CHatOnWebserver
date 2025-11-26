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
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import java.util.List;

/* loaded from: classes.dex */
public class SyncStatePreference extends Preference {

    /* renamed from: a */
    private boolean f12838a;

    /* renamed from: b */
    private Object f12839b;

    /* renamed from: c */
    private final Handler f12840c;

    /* renamed from: d */
    private Runnable f12841d;

    /* renamed from: e */
    private SyncStatusObserver f12842e;

    public SyncStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12838a = false;
        this.f12840c = new Handler();
        this.f12841d = new RunnableC3658gk(this);
        this.f12842e = new SyncStatusObserverC3659gl(this);
        setWidgetLayoutResource(R.layout.preference_widget_sync_now);
        setOnPreferenceClickListener(new C3656gi(this, context));
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.sync_active);
        View viewFindViewById = view.findViewById(R.id.sync_pending);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (this.f12838a) {
            imageView.setVisibility(0);
            viewFindViewById.setVisibility(8);
            imageView.post(new RunnableC3657gj(this, animationDrawable));
        } else {
            imageView.setVisibility(8);
            viewFindViewById.setVisibility(0);
            animationDrawable.stop();
        }
    }

    /* renamed from: a */
    private void m13691a(boolean z) {
        if (this.f12838a != z) {
            this.f12838a = z;
            callChangeListener(null);
            setEnabled(!z);
        }
    }

    /* renamed from: a */
    public void m13697a() {
        m13698b();
        this.f12839b = ContentResolver.addStatusChangeListener(7, this.f12842e);
        m13696e();
    }

    /* renamed from: b */
    public void m13698b() {
        if (this.f12839b != null) {
            this.f12840c.removeCallbacks(this.f12841d);
            ContentResolver.removeStatusChangeListener(this.f12839b);
            this.f12839b = null;
        }
    }

    /* renamed from: c */
    private boolean m13694c() {
        SyncInfo currentSync = ContentResolver.getCurrentSync();
        return (currentSync == null || currentSync.account == null || !Config.CHATON_PACKAGE_NAME.equals(currentSync.account.type)) ? false : true;
    }

    @TargetApi(11)
    /* renamed from: d */
    private boolean m13695d() {
        List<SyncInfo> currentSyncs = ContentResolver.getCurrentSyncs();
        if (currentSyncs == null || currentSyncs.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < currentSyncs.size(); i++) {
            if (currentSyncs.get(i).account != null && Config.CHATON_PACKAGE_NAME.equals(currentSyncs.get(i).account.type)) {
                z = true;
            }
            C4904y.m18639b("isSyncing return value = " + z, "SyncStatePreference");
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m13696e() {
        boolean zM13694c;
        if (Build.VERSION.SDK_INT >= 11) {
            zM13694c = m13695d();
        } else {
            zM13694c = m13694c();
        }
        C4904y.m18639b("onSyncStateUpdated " + zM13694c, "SyncStatePreference");
        m13691a(zM13694c);
    }
}
