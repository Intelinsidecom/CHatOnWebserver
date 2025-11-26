package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC0457af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3148a;

    ViewOnClickListenerC0457af(ActivitySkinChange activitySkinChange) {
        this.f3148a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3148a.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_03);
        this.f3148a.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_03);
        this.f3148a.f3067y = "bubble_03";
        this.f3148a.f3057o.setSelected(false);
        this.f3148a.f3058p.setSelected(false);
        this.f3148a.f3059q.setSelected(true);
        this.f3148a.f3060r.setSelected(false);
        this.f3148a.f3061s.setSelected(false);
        this.f3148a.f3062t.setSelected(false);
    }
}
