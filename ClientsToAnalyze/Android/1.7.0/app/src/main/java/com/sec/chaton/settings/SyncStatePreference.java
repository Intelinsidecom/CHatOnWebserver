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
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class SyncStatePreference extends Preference {

    /* renamed from: a */
    private boolean f3598a;

    /* renamed from: b */
    private Object f3599b;

    /* renamed from: c */
    private final Handler f3600c;

    /* renamed from: d */
    private Runnable f3601d;

    /* renamed from: e */
    private SyncStatusObserver f3602e;

    public SyncStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3598a = false;
        this.f3600c = new Handler();
        this.f3601d = new RunnableC1054by(this);
        this.f3602e = new SyncStatusObserverC1055bz(this);
        setWidgetLayoutResource(R.layout.preference_widget_sync_now);
        setOnPreferenceClickListener(new C1058cb(this, context));
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.sync_active);
        View viewFindViewById = view.findViewById(R.id.sync_pending);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (this.f3598a) {
            imageView.setVisibility(0);
            viewFindViewById.setVisibility(8);
            imageView.post(new RunnableC1059cc(this, animationDrawable));
        } else {
            imageView.setVisibility(8);
            viewFindViewById.setVisibility(0);
            animationDrawable.stop();
        }
    }

    /* renamed from: a */
    private void m3910a(boolean z) {
        if (this.f3598a != z) {
            this.f3598a = z;
            callChangeListener(null);
            setEnabled(!z);
        }
    }

    /* renamed from: a */
    public void m3915a() {
        m3916b();
        this.f3599b = ContentResolver.addStatusChangeListener(7, this.f3602e);
        m3914d();
    }

    /* renamed from: b */
    public void m3916b() {
        if (this.f3599b != null) {
            this.f3600c.removeCallbacks(this.f3601d);
            ContentResolver.removeStatusChangeListener(this.f3599b);
            this.f3599b = null;
        }
    }

    /* renamed from: c */
    private boolean m3913c() {
        SyncInfo currentSync = ContentResolver.getCurrentSync();
        return (currentSync == null || currentSync.account == null || !"com.sec.chaton".equals(currentSync.account.type)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3914d() {
        boolean zM3913c = m3913c();
        C1341p.m4658b("onSyncStateUpdated " + zM3913c, "SyncStatePreference");
        m3910a(zM3913c);
    }
}
