package com.sec.chaton.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncInfo;
import android.content.SyncStatusObserver;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class SyncStatePreference extends Preference {

    /* renamed from: a */
    private boolean f4756a;

    /* renamed from: b */
    private Object f4757b;

    /* renamed from: c */
    private final Handler f4758c;

    /* renamed from: d */
    private SyncStatusObserver f4759d;

    public SyncStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4756a = false;
        this.f4758c = new Handler();
        this.f4759d = new SyncStatusObserverC1324dv(this);
        setWidgetLayoutResource(R.layout.preference_widget_sync_now);
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.sync_active);
        View viewFindViewById = view.findViewById(R.id.sync_pending);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (this.f4756a) {
            imageView.setVisibility(0);
            viewFindViewById.setVisibility(8);
            imageView.post(new RunnableC1323du(this, animationDrawable));
        } else {
            imageView.setVisibility(8);
            viewFindViewById.setVisibility(0);
            animationDrawable.stop();
        }
    }

    /* renamed from: a */
    private void m4732a(boolean z) {
        if (this.f4756a != z) {
            this.f4756a = z;
            setEnabled(!z);
        }
    }

    /* renamed from: a */
    public void m4736a() {
        m4737b();
        this.f4757b = ContentResolver.addStatusChangeListener(7, this.f4759d);
        m4735d();
    }

    /* renamed from: b */
    public void m4737b() {
        if (this.f4757b != null) {
            ContentResolver.removeStatusChangeListener(this.f4757b);
            this.f4757b = null;
        }
    }

    /* renamed from: c */
    private boolean m4734c() {
        SyncInfo currentSync = ContentResolver.getCurrentSync();
        return (currentSync == null || currentSync.account == null || !"com.sec.chaton".equals(currentSync.account.type)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4735d() {
        boolean zM4734c = m4734c();
        C1786r.m6061b("onSyncStateUpdated " + zM4734c, "SyncStatePreference");
        m4732a(zM4734c);
    }
}
