package com.sec.chaton.trunk;

import android.hardware.motion.MotionRecognitionManager;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4880cr;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.cl */
/* loaded from: classes.dex */
class ViewOnClickListenerC4654cl implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f16865a;

    ViewOnClickListenerC4654cl(TrunkView trunkView) {
        this.f16865a = trunkView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.sendAccessibilityEvent(MotionRecognitionManager.EVENT_SMART_ALERT_SETTING);
        if (this.f16865a.f16619F.isChecked()) {
            this.f16865a.f16619F.setChecked(false);
            this.f16865a.f16647s.m17699a(false);
        } else {
            this.f16865a.f16619F.setChecked(true);
            this.f16865a.f16647s.m17699a(true);
        }
        if (this.f16865a.f16647s.m17694a().isEmpty()) {
            this.f16865a.f16623J.findItem(R.id.btnDeleteComplete).setEnabled(false);
            C4880cr.m18523a(this.f16865a.f16623J.findItem(R.id.btnDeleteComplete));
        } else {
            this.f16865a.f16623J.findItem(R.id.btnDeleteComplete).setEnabled(true);
            C4880cr.m18523a(this.f16865a.f16623J.findItem(R.id.btnDeleteComplete));
        }
        this.f16865a.f16641m.invalidateViews();
    }
}
