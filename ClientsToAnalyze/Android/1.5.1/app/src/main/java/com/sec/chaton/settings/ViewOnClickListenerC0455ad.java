package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.settings.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC0455ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3146a;

    ViewOnClickListenerC0455ad(ActivitySkinChange activitySkinChange) {
        this.f3146a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3146a.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_05);
        this.f3146a.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_05);
        this.f3146a.f3067y = "bubble_05";
        this.f3146a.f3057o.setSelected(false);
        this.f3146a.f3058p.setSelected(false);
        this.f3146a.f3059q.setSelected(false);
        this.f3146a.f3060r.setSelected(false);
        this.f3146a.f3061s.setSelected(true);
        this.f3146a.f3062t.setSelected(false);
    }
}
