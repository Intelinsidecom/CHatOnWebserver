package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.z */
/* loaded from: classes.dex */
class ViewOnClickListenerC0525z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3305a;

    ViewOnClickListenerC0525z(ActivitySkinChange activitySkinChange) {
        this.f3305a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3305a.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_01);
        this.f3305a.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_01);
        this.f3305a.f3067y = "bubble_01";
        this.f3305a.f3057o.setSelected(true);
        this.f3305a.f3058p.setSelected(false);
        this.f3305a.f3059q.setSelected(false);
        this.f3305a.f3060r.setSelected(false);
        this.f3305a.f3061s.setSelected(false);
        this.f3305a.f3062t.setSelected(false);
    }
}
