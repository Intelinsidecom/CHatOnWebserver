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
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class SyncStatePreference extends Preference {

    /* renamed from: a */
    private boolean f3132a;

    /* renamed from: b */
    private Object f3133b;

    /* renamed from: c */
    private final Handler f3134c;

    /* renamed from: d */
    private SyncStatusObserver f3135d;

    public SyncStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3132a = false;
        this.f3134c = new Handler();
        this.f3135d = new SyncStatusObserverC0488bj(this);
        setWidgetLayoutResource(C0062R.layout.preference_widget_sync_now);
        setOnPreferenceClickListener(new C0490bl(this));
    }

    /* renamed from: a */
    private void m3214a(boolean z) {
        if (this.f3132a != z) {
            this.f3132a = z;
            setEnabled(!z);
        }
    }

    /* renamed from: c */
    private boolean m3216c() {
        SyncInfo currentSync = ContentResolver.getCurrentSync();
        return (currentSync == null || currentSync.account == null || !"com.sec.chaton".equals(currentSync.account.type)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3217d() {
        boolean zM3216c = m3216c();
        ChatONLogWriter.m3506b("onSyncStateUpdated " + zM3216c, "SyncStatePreference");
        m3214a(zM3216c);
    }

    /* renamed from: a */
    public void m3218a() {
        m3219b();
        this.f3133b = ContentResolver.addStatusChangeListener(7, this.f3135d);
        m3217d();
    }

    /* renamed from: b */
    public void m3219b() {
        if (this.f3133b != null) {
            ContentResolver.removeStatusChangeListener(this.f3133b);
            this.f3133b = null;
        }
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(C0062R.id.sync_active);
        View viewFindViewById = view.findViewById(C0062R.id.sync_pending);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (this.f3132a) {
            imageView.setVisibility(0);
            viewFindViewById.setVisibility(8);
            imageView.post(new RunnableC0491bm(this, animationDrawable));
        } else {
            imageView.setVisibility(8);
            viewFindViewById.setVisibility(0);
            animationDrawable.stop();
        }
    }
}
